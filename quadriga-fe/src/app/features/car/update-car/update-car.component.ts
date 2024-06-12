import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CarService } from '../../../services/car.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BrandService } from '../../../services/brand.service';
import { Car } from '../../../models/car';

@Component({
  selector: 'app-update-car',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-car.component.html',
  styleUrl: './update-car.component.scss'
})
export class UpdateCarComponent implements OnInit {
  id: number = 0;
  car: Car = new Car();

  constructor(private carService: CarService,
              private route: ActivatedRoute,
              private router: Router
){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.carService.getCarById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.car = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Car updated successfully.")
      })
  }

  onSubmit(){
    this.updateCarById();
  }

  updateCarById(){
    this.carService.updateCarById(this.id, this.car)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToCarList()
      })
  }

  goToCarList(){
    this.router.navigate(['/cars/cars-list']);
  }
}
