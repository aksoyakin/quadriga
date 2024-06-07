import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Color } from '../../../models/color';
import { ColorService } from '../../../services/color.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-color',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-color.component.html',
  styleUrl: './create-color.component.css',
})
export class CreateColorComponent {

  color: Color = new Color();

  constructor(private colorService: ColorService,
              private router: Router
  ){}

  createColor(){
    this.colorService.createColor(this.color)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.color = data;
          this.router.navigate(['/colors/colors-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Color created successfully!")
      })
  }

  onSubmit(){
    console.log(this.color)
    this.createColor();
  }
}
