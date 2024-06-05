import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Model } from '../../../models/model';
import { ModelService } from '../../../services/model.service';
import { Router } from '@angular/router';
import { BrandService } from '../../../services/brand.service';

@Component({
  selector: 'app-create-model',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-model.component.html',
  styleUrl: './create-model.component.scss'
})
export class CreateModelComponent implements OnInit {
  model: Model = new Model();
  brands: any[] = [];

  constructor(private modelService: ModelService,
              private brandService: BrandService,
              private router: Router
  ){}

  ngOnInit(): void {
    this.brandService.getAllBrands().subscribe(data => {
      this.brands = data;
    })
  }

  createModel(){
    this.modelService.createModel(this.model)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.model = data;
          this.router.navigate(['/models/models-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Model created successfully!")
      })
  }

  onSubmit(){
    console.log(this.model)
    this.createModel();
  }

}
