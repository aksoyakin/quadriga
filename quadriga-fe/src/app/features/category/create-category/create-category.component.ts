import { Component } from '@angular/core';
import { Category } from '../../../models/category';
import { CategoryService } from '../../../services/category.service';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-category',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-category.component.html',
  styleUrl: './create-category.component.scss'
})
export class CreateCategoryComponent {

  category: Category = new Category();

  constructor(private categoryService: CategoryService,
              private router: Router
  ){}

  createCategory(){
    this.categoryService.createCategory(this.category)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.category = data;
          this.router.navigate(['/categories/category-list'])
        },
        error: (error) => console.log(error),
        complete: () => console.log("Category created successfully!")
      })
  }

  onSubmit(){
    console.log(this.category)
    this.createCategory();
  }
}
