import { Component, OnInit } from '@angular/core';
import { CarService } from '../../../services/car.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrandService } from '../../../services/brand.service';
import { Car } from '../../../models/car';
import { ModelService } from '../../../services/model.service';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { FuelTypeService } from '../../../services/fueltype.service';
import { CategoryService } from '../../../services/category.service';
import { ColorService } from '../../../services/color.service';

@Component({
  selector: 'app-car-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './car-list.component.html',
  styleUrl: './car-list.component.scss'
})
export class CarListComponent implements OnInit {
  cars: Car[] = [];
  carCount: number = 0;

  brands: any[] = [];
  models: any[] = [];
  transmissionTypes: any[] = [];
  fuelTypes: any[] = [];
  categories: any[] = [];
  colors: any[] = [];

  constructor(private carService: CarService,
              private router: Router,
              private brandService: BrandService,
              private modelService: ModelService,
              private transmissionTypeService: TransmissionTypeService,
              private fuelTypeService: FuelTypeService,
              private categoryService: CategoryService,
              private colorService: ColorService,
  ){}

  ngOnInit(): void {
    this.getAllCars();
    this.countCars();
    this.loadData();
  }

  getAllCars() {
    this.carService.getAllCars().subscribe(data => {
      this.cars = data;
    });
  }

  updateCarById(id: number){
    this.router.navigate(['cars/update-car', id])
  }

  carDetails(id: number){
    this.router.navigate(['cars/car-details', id]);
  }

  deleteCarById(id:number) {
    this.carService.deleteCarById(id).
      subscribe({
        next: (data) => {
          console.log("Car deleted successfully!");
          this.getAllCars();
        },
        error: (error) => console.log(error)
      });
  }

  countCars(){
    this.carService.getAllCars().subscribe(data => {
      this.carCount = data.length;
    })
  }

  redirectToCreateCar() {
    this.router.navigate(['/cars/create-car']);
  }

  loadData() {
    this.brandService.getAllBrands().subscribe(data => this.brands = data);
    this.modelService.getAllModels().subscribe(data => this.models = data);
    this.transmissionTypeService.getAllTransmissionTypes().subscribe(data => this.transmissionTypes = data);
    this.fuelTypeService.getAllFuelTypes().subscribe(data => this.fuelTypes = data);
    this.categoryService.getAllCategories().subscribe(data => this.categories = data);
    this.colorService.getAllColors().subscribe(data => this.colors = data);
  }

  getColorName(colorId: number): string {
    const color = this.colors.find(c => c.id === colorId);
    return color ? color.name : 'Unknown Color';
  }

  getTransmissionTypeName(transmissionTypeId: number): string {
    const transmissionType = this.transmissionTypes.find(tt => tt.id === transmissionTypeId);
    return transmissionType ? transmissionType.type : 'Unknown Transmission Type';
  }

  getFuelTypeName(fuelTypeId: number): string {
    const fuelType = this.fuelTypes.find(ft => ft.id === fuelTypeId);
    return fuelType ? fuelType.type : 'Unknown Fuel Type';
  }

  getModelName(modelId: number): string {
    const model = this.models.find(m => m.id === modelId);
    return model ? model.name : 'Unknown Model';
  }

  getCategoryName(categoryId: number): string {
    const category = this.categories.find(c => c.id === categoryId);
    return category ? category.name : 'Unknown Category';
  }
}




  
