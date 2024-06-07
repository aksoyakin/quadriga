import { Component, OnInit } from '@angular/core';
import { Category } from '../../../models/category';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from '../../../services/category.service';

@Component({
  selector: 'app-category-details',
  standalone: true,
  imports: [],
  templateUrl: './category-details.component.html',
  styleUrl: './category-details.component.scss'
})
export class CategoryDetailsComponent implements OnInit {

  id: number = 0;
  category: Category = new Category();

  constructor(private route: ActivatedRoute,
              private categoryService: CategoryService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.category = new Category();
    this.categoryService.getCategoryById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.category = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }
}
