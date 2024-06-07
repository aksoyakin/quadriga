import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FuelTypeService } from '../../../services/fueltype.service';
import { FuelType } from '../../../models/fueltype';

@Component({
  selector: 'app-fueltype-details',
  standalone: true,
  imports: [],
  templateUrl: './fueltype-details.component.html',
  styleUrl: './fueltype-details.component.scss'
})
export class FuelTypeDetailsComponent implements OnInit {

  id: number = 0;
  fueltype: FuelType = new FuelType();
  
  constructor(private route: ActivatedRoute,
              private fueltypeService: FuelTypeService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.fueltype = new FuelType();
    this.fueltypeService.getFuelTypeById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.fueltype = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }
}
