import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ColorService } from '../../../services/color.service';
import { Color } from '../../../models/color';

@Component({
  selector: 'app-color-details',
  standalone: true,
  imports: [],
  templateUrl: './color-details.component.html',
  styleUrl: './color-details.component.scss'
})
export class ColorDetailsComponent implements OnInit {

  id: number = 0;
  color: Color = new Color();
  
  constructor(private route: ActivatedRoute,
              private colorService: ColorService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.color = new Color();
    this.colorService.getColorById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.color = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }
}
