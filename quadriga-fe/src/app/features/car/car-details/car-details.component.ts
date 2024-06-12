import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarService } from '../../../services/car.service';
import { Car } from '../../../models/car';


@Component({
  selector: 'app-car-details',
  standalone: true,
  imports: [],
  templateUrl: './car-details.component.html',
  styleUrl: './car-details.component.scss'
})
export class CarDetailsComponent implements OnInit {
  id: number = 0;
  car: Car = new Car();

  constructor(private route: ActivatedRoute,
              private carService: CarService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.car = new Car();
    this.carService.getCarById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.car = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }



}
