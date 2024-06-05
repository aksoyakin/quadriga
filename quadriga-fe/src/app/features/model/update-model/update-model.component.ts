import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Model } from '../../../models/model';
import { ModelService } from '../../../services/model.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BrandService } from '../../../services/brand.service';

@Component({
  selector: 'app-update-model',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-model.component.html',
  styleUrl: './update-model.component.scss'
})
export class UpdateModelComponent implements OnInit {
  id: number = 0;
  model: Model = new Model();

  constructor(private modelService: ModelService,
              private route: ActivatedRoute,
              private router: Router
){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.modelService.getModelById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.model = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Model updated successfully.")
      })
  }

  onSubmit(){
    this.updateModelById();
  }

  updateModelById(){
    this.modelService.updateModelById(this.id, this.model)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToModelList()
      })
  }

  goToModelList(){
    this.router.navigate(['/models/models-list']);
  }
}
