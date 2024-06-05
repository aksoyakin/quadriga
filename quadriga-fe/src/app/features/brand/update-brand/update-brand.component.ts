import { Component, OnInit } from '@angular/core';
import { Brand } from '../../../models/brand';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BrandService } from '../../../services/brand.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-brand',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-brand.component.html',
  styleUrl: './update-brand.component.scss'
})
export class UpdateBrandComponent implements OnInit {
  id: number = 0;
  brand: Brand = new Brand();

  constructor(private brandService: BrandService,
              private route: ActivatedRoute,
              private router: Router
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.brandService.getBrandById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.brand = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Brand updated successfully.")
      })
  }

  onSubmit(){
    this.updateBrandById();
  }

  updateBrandById(){
    this.brandService.updateBrandById(this.id, this.brand)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToBrandList()
      })
  }

  goToBrandList(){
    this.router.navigate(['/brands/brands-list']);
  }

}
