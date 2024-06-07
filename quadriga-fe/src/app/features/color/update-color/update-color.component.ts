import { Component, OnInit } from '@angular/core';
import { Color } from '../../../models/color';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ColorService } from '../../../services/color.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-color',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-color.component.html',
  styleUrl: './update-color.component.scss'
})
export class UpdateColorComponent implements OnInit {
  id: number = 0;
  color: Color = new Color();

  constructor(private colorService: ColorService,
              private route: ActivatedRoute,
              private router: Router
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.colorService.getColorById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.color = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Color updated successfully.")
      })
  }

  onSubmit(){
    this.updateColorById();
  }

  updateColorById(){
    this.colorService.updateColorById(this.id, this.color)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToColorList()
      })
  }

  goToColorList(){
    this.router.navigate(['/colors/colors-list']);
  }

}
