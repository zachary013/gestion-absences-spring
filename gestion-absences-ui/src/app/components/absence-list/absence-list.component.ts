import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Absence } from '../../models/absence.model';
import { AbsenceService } from '../../services/absence.service';

@Component({
  selector: 'app-absence-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './absence-list.component.html',
  styleUrls: ['./absence-list.component.scss']
})
export class AbsenceListComponent implements OnInit {
  absences: Absence[] = [];

  constructor(private absenceService: AbsenceService) {}

  ngOnInit(): void {
    this.loadAbsences();
  }

  loadAbsences(): void {
    this.absenceService.getAbsences().subscribe(
      (data) => {
        this.absences = data;
      },
      (error) => {
        console.error('Error fetching absences:', error);
      }
    );
  }

  deleteAbsence(id: number | undefined): void {
    if (id === undefined) {
      console.error('Cannot delete absence with undefined id');
      return;
    }

    if (confirm('Are you sure you want to delete this absence?')) {
      this.absenceService.deleteAbsence(id).subscribe(
        () => {
          this.loadAbsences();
        },
        (error) => {
          console.error('Error deleting absence:', error);
        }
      );
    }
  }
}

