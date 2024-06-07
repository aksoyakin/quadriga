import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { Color } from '../../../models/color';
import { ColorService } from '../../../services/color.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-colors-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './colors-list.component.html',
  styleUrl: './colors-list.component.css',
})

export class ColorsListComponent implements OnInit {
  colors: Color[] = [];
  colorCount: number = 0;

  constructor(private colorService: ColorService,
              private router: Router,
  ){}

  ngOnInit(): void {
    this.getAllColors();
    this.countColors();
   }

  getAllColors() {
    this.colorService.getAllColors().subscribe(data => {
      this.colors = data;
    });
  }

  updateColorById(id: number){
    this.router.navigate(['colors/update-color', id])
  }

  colorDetails(id: number){
    this.router.navigate(['colors/color-details', id]);
  }

  deleteColorById(id: number) {
    this.colorService.deleteColorById(id).
      subscribe({
        next: (data) => {
          console.log("Color deleted successfully!");
          this.getAllColors();
        },
        error: (error) => console.log(error)
      });
  }

  countColors(){
    this.colorService.getAllColors().subscribe(data => {
      this.colorCount = data.length;
    });
  }

  redirectToCreateColor() {
    this.router.navigate(['/colors/create-color']);
  }
}
