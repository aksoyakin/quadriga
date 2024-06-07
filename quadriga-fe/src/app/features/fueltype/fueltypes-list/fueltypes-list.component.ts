import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { FuelType } from '../../../models/fueltype';
import { FuelTypeService } from '../../../services/fueltype.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fueltypes-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './fueltypes-list.component.html',
  styleUrl: './fueltypes-list.component.css',
})

export class FuelTypesListComponent implements OnInit {
  fueltypes: FuelType[] = [];
  fueltypeCount: number = 0;

  constructor(private fueltypeService: FuelTypeService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllFuelTypes();
    this.countFuelTypes();
   }

  getAllFuelTypes() {
    this.fueltypeService.getAllFuelTypes().subscribe(data => {
      this.fueltypes = data;
    });
  }

  updateFuelTypeById(id: number){
    this.router.navigate(['fueltypes/update-fueltype', id])
  }

  fueltypeDetails(id: number){
    this.router.navigate(['fueltypes/fueltype-details', id]);
  }

  deleteFuelTypeById(id: number) {
    this.fueltypeService.deleteFuelTypeById(id).
      subscribe({
        next: (data) => {
          console.log("FuelType deleted successfully!");
          this.getAllFuelTypes();
        },
        error: (error) => console.log(error)
      });
  }

  countFuelTypes(){
    this.fueltypeService.getAllFuelTypes().subscribe(data => {
      this.fueltypeCount = data.length;
    });
  }

  redirectToCreateFuelType() {
    this.router.navigate(['/fueltypes/create-fueltype']);
  }
}
