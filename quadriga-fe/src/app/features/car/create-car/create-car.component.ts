import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CarService } from '../../../services/car.service';
import { Router } from '@angular/router';
import { BrandService } from '../../../services/brand.service';
import { Car } from '../../../models/car';
import { ModelService } from '../../../services/model.service';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { FuelTypeService } from '../../../services/fueltype.service';
import { CategoryService } from '../../../services/category.service';
import { ColorService } from '../../../services/color.service';

@Component({
  selector: 'app-create-car',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-car.component.html',
  styleUrl: './create-car.component.scss'
})
export class CreateCarComponent implements OnInit {
  carForm: FormGroup;
  brands: any[] = [];
  models: any[] = [];
  transmissionTypes: any[] = [];
  fuelTypes: any[] = [];
  categories: any[] = [];
  colors: any[] = [];

  constructor(
    private fb: FormBuilder,
    private brandService: BrandService,
    private modelService: ModelService,
    private carService: CarService,
    private transmissionTypeService: TransmissionTypeService,
    private fuelTypeService: FuelTypeService,
    private categoryService: CategoryService,
    private colorService: ColorService,
    private router: Router
  ) {
    this.carForm = this.fb.group({
      available: [true, Validators.required],
      year: ['', Validators.required],
      mileageCounter: ['', [Validators.required, Validators.min(0)]],
      seatingCapacity: ['', Validators.required],
      plate: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      colorId: ['', Validators.required],
      categoryId: ['', Validators.required],
      modelId: ['', Validators.required],
      fuelTypeId: ['', Validators.required],
      transmissionTypeId: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.brandService.getAllBrands().subscribe(data => this.brands = data);
    this.modelService.getAllModels().subscribe(data => this.models = data);
    this.transmissionTypeService.getAllTransmissionTypes().subscribe(data => this.transmissionTypes = data);
    this.fuelTypeService.getAllFuelTypes().subscribe(data => this.fuelTypes = data);
    this.categoryService.getAllCategories().subscribe(data => this.categories = data);
    this.colorService.getAllColors().subscribe(data => this.colors = data);
  }

  createCar() {
    if (this.carForm.invalid) {
      return;
    }
    const carData: Car = this.carForm.value;
    this.carService.createCar(carData)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.router.navigate(['/cars/cars-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Car created successfully!")
      });
  }

  onSubmit() {
    this.createCar();
  }

}
