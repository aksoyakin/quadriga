import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FuelType } from '../../../models/fueltype';
import { FuelTypeService } from '../../../services/fueltype.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-fueltype',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-fueltype.component.html',
  styleUrl: './create-fueltype.component.css',
})
export class CreateFuelTypeComponent {

  fueltype: FuelType = new FuelType();

  constructor(private fueltypeService: FuelTypeService,
              private router: Router
  ){}

  createFuelType(){
    this.fueltypeService.createFuelType(this.fueltype)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.fueltype = data;
          this.router.navigate(['/fueltypes/fueltypes-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Fuel Type created successfully!")
      })
  }

  onSubmit(){
    console.log(this.fueltype)
    this.createFuelType();
  }
}
