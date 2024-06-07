import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { TransmissionType } from '../../../models/transmissiontype';

@Component({
  selector: 'app-transmissiontype-details',
  standalone: true,
  imports: [],
  templateUrl: './transmissiontype-details.component.html',
  styleUrl: './transmissiontype-details.component.scss'
})
export class TransmissionTypeDetailsComponent implements OnInit {

  id: number = 0;
  transmissiontype: TransmissionType = new TransmissionType();
  
  constructor(private route: ActivatedRoute,
              private transmissiontypeService: TransmissionTypeService
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.transmissiontype = new TransmissionType();
    this.transmissiontypeService.getTransmissionTypeById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.transmissiontype = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("Data init completed.")
      })
  }
}
