import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { TransmissionType } from '../../../models/transmissiontype';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transmissiontypes-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './transmissiontypes-list.component.html',
  styleUrl: './transmissiontypes-list.component.css',
})

export class TransmissionTypesListComponent implements OnInit {
  transmissiontypes: TransmissionType[] = [];
  transmissiontypeCount: number = 0;

  constructor(private transmissiontypeService: TransmissionTypeService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllTransmissionTypes();
    this.countTransmissionTypes();
   }

  getAllTransmissionTypes() {
    this.transmissiontypeService.getAllTransmissionTypes().subscribe(data => {
      this.transmissiontypes = data;
    });
  }

  updateTransmissionTypeById(id: number){
    this.router.navigate(['transmissiontypes/update-transmissiontype', id])
  }

  transmissiontypeDetails(id: number){
    this.router.navigate(['transmissiontypes/transmissiontype-details', id]);
  }

  deleteTransmissionTypeById(id: number) {
    this.transmissiontypeService.deleteTransmissionTypeById(id).
      subscribe({
        next: (data) => {
          console.log("Transmission Type deleted successfully!");
          this.getAllTransmissionTypes();
        },
        error: (error) => console.log(error)
      });
  }

  countTransmissionTypes(){
    this.transmissiontypeService.getAllTransmissionTypes().subscribe(data => {
      this.transmissiontypeCount = data.length;
    });
  }

  redirectToCreateTransmissionType() {
    this.router.navigate(['/transmissiontypes/create-transmissiontype']);
  }
}
