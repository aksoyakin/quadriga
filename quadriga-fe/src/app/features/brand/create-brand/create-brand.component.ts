import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Brand } from '../../../models/brand';
import { BrandService } from '../../../services/brand.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-brand',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-brand.component.html',
  styleUrl: './create-brand.component.css',
})
export class CreateBrandComponent {

  brand: Brand = new Brand();

  constructor(private brandService: BrandService,
              private router: Router
  ){}

  createBrand(){
    this.brandService.createBrand(this.brand)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.brand = data;
          this.router.navigate(['/brands/brands-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Brand created successfully!")
      })
  }

  onSubmit(){
    console.log(this.brand)
    this.createBrand();
  }
}
