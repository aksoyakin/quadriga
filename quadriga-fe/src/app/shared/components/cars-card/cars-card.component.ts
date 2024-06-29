import { Component, OnInit } from '@angular/core';
import { Car } from '../../../models/car';
import { CarService } from '../../../services/car.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BrandService } from '../../../services/brand.service';
import { ModelService } from '../../../services/model.service';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { FuelTypeService } from '../../../services/fueltype.service';
import { CategoryService } from '../../../services/category.service';
import { ColorService } from '../../../services/color.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cars-card',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './cars-card.component.html',
  styleUrl: './cars-card.component.scss'
})
export class CarsCardComponent implements OnInit {
  cars: Car[] = [];
  carCount: number = 0;

  currentCategoryId: number = 1;

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
              private route: ActivatedRoute
  ){}

/*   ngOnInit(): void {
    this.getAllCars();
    this.loadData();
  }

  getAllCars() {

     this.carService.getAllCars().subscribe(data => {
      this.cars = data;
    });
  } */

    ngOnInit() {
      this.route.paramMap.subscribe(() =>  {
        this.listCars();
      });
      this.getAllCars(); // Başlangıçta tüm araçları listelemek için
      this.loadData();
    }

    getAllCars() {
      this.carService.getAllCars().subscribe(data => {
        this.cars = data;
      });
    }

    listCars(){
      this.handleListCars();
    }

    handleListCars(){
      const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
      
      if(hasCategoryId){
        //get the "id" param string. convert string to a number using "+" symbol
        this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      }
      else {
        // not category id available .... default to category id 1
        this.currentCategoryId = 1;
      }

      this.carService.getCarByCategoryId(this.currentCategoryId).subscribe(
        data=> {
          this.cars = data;
        }
      )
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
