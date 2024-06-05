import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ModelService } from '../../../services/model.service';
import { Brand } from '../../../models/brand';
import { Model } from '../../../models/model';

@Component({
  selector: 'app-model-details',
  standalone: true,
  imports: [],
  templateUrl: './model-details.component.html',
  styleUrl: './model-details.component.scss'
})
export class ModelDetailsComponent implements OnInit {
  id: number = 0;
  model: Model = new Model();

  constructor(private route: ActivatedRoute,
              private modelService: ModelService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.model = new Model();
    this.modelService.getModelById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.model = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }



}
