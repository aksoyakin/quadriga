import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BrandService } from '../../../services/brand.service';
import { Brand } from '../../../models/brand';

@Component({
  selector: 'app-brand-details',
  standalone: true,
  imports: [],
  templateUrl: './brand-details.component.html',
  styleUrl: './brand-details.component.scss'
})
export class BrandDetailsComponent implements OnInit {

  id: number = 0;
  brand: Brand = new Brand();
  
  constructor(private route: ActivatedRoute,
              private brandService: BrandService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.brand = new Brand();
    this.brandService.getBrandById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.brand = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }



}
