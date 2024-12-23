import { Component } from '@angular/core';
import {Student} from '../../models/student.model';
import {StudentService} from '../../services/student.service';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [
    DatePipe
  ],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.scss'
})
export class StudentListComponent {
  students: Student[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getStudents().subscribe(
      (data) => {
        this.students = data;
      },
      (error) => {
        console.error('Error fetching students:', error);
      }
    );
  }

  deleteStudent(id: number): void {
    if (confirm('Are you sure you want to delete this student?')) {
      this.studentService.deleteStudent(id).subscribe(
        () => {
          this.loadStudents();
        },
        (error) => {
          console.error('Error deleting student:', error);
        }
      );
    }
  }
}
