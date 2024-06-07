import { Component, OnInit } from '@angular/core';
import { FuelType } from '../../../models/fueltype';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FuelTypeService } from '../../../services/fueltype.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-fueltype',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-fueltype.component.html',
  styleUrl: './update-fueltype.component.scss'
})
export class UpdateFuelTypeComponent implements OnInit {
  id: number = 0;
  fueltype: FuelType = new FuelType();

  constructor(private fueltypeService: FuelTypeService,
              private route: ActivatedRoute,
              private router: Router
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.fueltypeService.getFuelTypeById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.fueltype = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("FuelType updated successfully.")
      })
  }

  onSubmit(){
    this.updateFuelTypeById();
  }

  updateFuelTypeById(){
    this.fueltypeService.updateFuelTypeById(this.id, this.fueltype)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToFuelTypeList()
      })
  }

  goToFuelTypeList(){
    this.router.navigate(['/fueltypes/fueltypes-list']);
  }

}
