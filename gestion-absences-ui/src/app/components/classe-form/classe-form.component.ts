import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Classe} from '../../models/classe.model';
import {ActivatedRoute, Router} from '@angular/router';
import {ClasseService} from '../../services/classe.service';

@Component({
  selector: 'app-classe-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './classe-form.component.html',
  styleUrl: './classe-form.component.scss'
})
export class ClasseFormComponent {
  classeForm: FormGroup;
  isEditMode = false;

  constructor(
    private formBuilder: FormBuilder,
    private classeService: ClasseService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.classeForm = this.formBuilder.group({
      nom: ['', Validators.required],
      niveau: ['', [Validators.required, Validators.min(1)]]
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.loadClasse(+id);
    }
  }

  loadClasse(id: number): void {
    this.classeService.getClasse(id).subscribe(
      (data) => {
        this.classeForm.patchValue(data);
      },
      (error) => {
        console.error('Error fetching class:', error);
      }
    );
  }

  onSubmit(): void {
    if (this.classeForm.valid) {
      const classe: Classe = this.classeForm.value;
      if (this.isEditMode) {
        const id = this.route.snapshot.paramMap.get('id');
        this.classeService.updateClasse(+id!, classe).subscribe(
          () => {
            this.router.navigate(['/classes']);
          },
          (error) => {
            console.error('Error updating class:', error);
          }
        );
      } else {
        this.classeService.createClasse(classe).subscribe(
          () => {
            this.router.navigate(['/classes']);
          },
          (error) => {
            console.error('Error creating class:', error);
          }
        );
      }
    }
  }
}
