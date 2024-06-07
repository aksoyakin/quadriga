import { Component, OnInit } from '@angular/core';
import { Category } from '../../../models/category';
import { CategoryService } from '../../../services/category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-category',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-category.component.html',
  styleUrl: './update-category.component.scss'
})
export class UpdateCategoryComponent implements OnInit {
  id: number = 0;
  category: Category = new Category();

  constructor(private categoryService: CategoryService,
              private route: ActivatedRoute,
              private router: Router
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.categoryService.getCategoryById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.category = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Category updated successfully.")
      })
  }

  onSubmit(){
    this.updateCategoryById();
  }

  updateCategoryById(){
    this.categoryService.updateCategoryById(this.id, this.category)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToCategoryList()
      })
  }

  goToCategoryList(){
    this.router.navigate(['/categories/category-list']);
  }

}
