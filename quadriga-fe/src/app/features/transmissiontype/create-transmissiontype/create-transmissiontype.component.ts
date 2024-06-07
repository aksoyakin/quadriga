import { CommonModule } from '@angular/common';
import { Component, type OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TransmissionType } from '../../../models/transmissiontype';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-transmissiontype',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './create-transmissiontype.component.html',
  styleUrl: './create-transmissiontype.component.css',
})
export class CreateTransmissionTypeComponent {

  transmissiontype: TransmissionType = new TransmissionType();

  constructor(private transmissiontypeService: TransmissionTypeService,
              private router: Router
  ){}

  createTransmissionType(){
    this.transmissiontypeService.createTransmissionType(this.transmissiontype)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.transmissiontype = data;
          this.router.navigate(['/transmissiontypes/transmissiontypes-list']);
        },
        error: (error) => console.log(error),
        complete: () => console.log("Tranmission Type created successfully!")
      })
  }

  onSubmit(){
    console.log(this.transmissiontype)
    this.createTransmissionType();
  }
}
