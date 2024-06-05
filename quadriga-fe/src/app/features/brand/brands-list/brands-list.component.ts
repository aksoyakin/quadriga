import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { Brand } from '../../../models/brand';
import { BrandService } from '../../../services/brand.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-brands-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './brands-list.component.html',
  styleUrl: './brands-list.component.css',
})

export class BrandsListComponent implements OnInit {
  brands: Brand[] = [];
  brandCount: number = 0;

  constructor(private brandService: BrandService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllBrands();
    this.countBrands();
   }

  getAllBrands() {
    this.brandService.getAllBrands().subscribe(data => {
      this.brands = data;
    });
  }

  updateBrandById(id: number){
    this.router.navigate(['brands/update-brand', id])
  }

  brandDetails(id: number){
    this.router.navigate(['brands/brand-details', id]);
  }

  deleteBrandById(id: number) {
    this.brandService.deleteBrandById(id).
      subscribe({
        next: (data) => {
          console.log("Brand deleted successfully!");
          this.getAllBrands();
        },
        error: (error) => console.log(error)
      });
  }

  countBrands(){
    this.brandService.getAllBrands().subscribe(data => {
      this.brandCount = data.length;
    });
  }

}
