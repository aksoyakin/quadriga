import { Component, OnInit } from '@angular/core';
import { Category } from '../../../models/category';
import { CarService } from '../../../services/car.service';
import { CategoryService } from '../../../services/category.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-car-category-menu',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './car-category-menu.component.html',
  styleUrl: './car-category-menu.component.scss'
})
export class CarCategoryMenuComponent implements OnInit {

  carCategories: Category[] = [];

  constructor(private carService: CarService,
              private categoryService: CategoryService
  ){

  }

  ngOnInit(): void {
    this.listCarCategories();
  }

  listCarCategories() {
    this.categoryService.getAllCategories().subscribe(
      data => {
        console.log('Car Category=' + JSON.stringify(data));
        this.carCategories = data;
      }
    )
  }

}
