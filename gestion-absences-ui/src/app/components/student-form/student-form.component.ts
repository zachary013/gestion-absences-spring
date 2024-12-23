import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Classe} from '../../models/classe.model';
import {StudentService} from '../../services/student.service';
import {ClasseService} from '../../services/classe.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Student} from '../../models/student.model';

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './student-form.component.html',
  styleUrl: './student-form.component.scss'
})
export class StudentFormComponent implements OnInit {
  studentForm: FormGroup;
  isEditMode = false;
  classes: Classe[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private studentService: StudentService,
    private classeService: ClasseService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.studentForm = this.formBuilder.group({
      prenom: ['', Validators.required],
      nom: ['', Validators.required],
      dateNaissance: ['', Validators.required],
      classeId: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadClasses();
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.loadStudent(+id);
    }
  }

  loadClasses(): void {
    this.classeService.getClasses().subscribe(
      (data) => {
        this.classes = data;
      },
      (error) => {
        console.error('Error fetching classes:', error);
      }
    );
  }

  loadStudent(id: number): void {
    this.studentService.getStudent(id).subscribe(
      (data) => {
        this.studentForm.patchValue(data);
      },
      (error) => {
        console.error('Error fetching student:', error);
      }
    );
  }

  onSubmit(): void {
    if (this.studentForm.valid) {
      const student: Student = this.studentForm.value;
      if (this.isEditMode) {
        const id = this.route.snapshot.paramMap.get('id');
        this.studentService.updateStudent(+id!, student).subscribe(
          () => {
            this.router.navigate(['/students']);
          },
          (error) => {
            console.error('Error updating student:', error);
          }
        );
      } else {
        this.studentService.createStudent(student).subscribe(
          () => {
            this.router.navigate(['/students']);
          },
          (error) => {
            console.error('Error creating student:', error);
          }
        );
      }
    }
  }
}
