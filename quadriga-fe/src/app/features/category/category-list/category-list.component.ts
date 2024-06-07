import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Category } from '../../../models/category';
import { CategoryService } from '../../../services/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.scss'
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = [];
  categoryCount: number = 0;

  constructor(private categoryService: CategoryService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllCategories();
    this.countCategories();
  }

  getAllCategories(){
    this.categoryService.getAllCategories().subscribe(data => {
      this.categories = data;
    });
  }

  updateCategoryById(id: number){
    this.router.navigate(['categories/update-category', id]);
  }

  categoryDetails(id: number){
    this.router.navigate(['categories/category-details', id]);
  }

  deleteCategoryById(id: number){
    this.categoryService.deleteCategoryById(id).
      subscribe({
        next: (data) => {
          console.log("Category deleted successfully!");
          this.getAllCategories();
        },
        error: (error) => console.log(error)
      });
  }

  countCategories(){
    this.categoryService.getAllCategories(). subscribe(data => {
      this.categoryCount = data.length;
    });
  }

  redirectToCreateCategory(){
    this.router.navigate(['/categories/create-category']);
  }
}
