import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {Classe} from '../../models/classe.model';
import {ClasseService} from '../../services/classe.service';

@Component({
  selector: 'app-classe-list',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './classe-list.component.html',
  styleUrl: './classe-list.component.scss'
})
export class ClasseListComponent {
  classes: Classe[] = [];

  constructor(private classeService: ClasseService) {}

  ngOnInit(): void {
    this.loadClasses();
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

  deleteClasse(id: number): void {
    if (confirm('Are you sure you want to delete this class?')) {
      this.classeService.deleteClasse(id).subscribe(
        () => {
          this.loadClasses();
        },
        (error) => {
          console.error('Error deleting class:', error);
        }
      );
    }
  }
}
