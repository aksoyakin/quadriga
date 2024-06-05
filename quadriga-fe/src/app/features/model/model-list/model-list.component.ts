import { Component, OnInit } from '@angular/core';
import { Model } from '../../../models/model';
import { ModelService } from '../../../services/model.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrandService } from '../../../services/brand.service';

@Component({
  selector: 'app-model-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './model-list.component.html',
  styleUrl: './model-list.component.scss'
})
export class ModelListComponent implements OnInit {
  models: Model[] = [];
  modelCount: number = 0;

  constructor(private modelService: ModelService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllModels();
    this.countModels();
  }

  getAllModels() {
    this.modelService.getAllModels().subscribe(data => {
      this.models = data;
    });
  }

  updateModelById(id: number){
    this.router.navigate(['models/update-model', id])
  }

  modelDetails(id: number){
    this.router.navigate(['models/model-details', id]);
  }

  deleteModelById(id:number) {
    this.modelService.deleteModelById(id).
      subscribe({
        next: (data) => {
          console.log("Model deleted successfully!");
          this.getAllModels();
        },
        error: (error) => console.log(error)
      });
  }

  countModels(){
    this.modelService.getAllModels().subscribe(data => {
      this.modelCount = data.length;
    })
  }

  redirectToCreateModel() {
    this.router.navigate(['/models/create-model']);
  }


  

}
