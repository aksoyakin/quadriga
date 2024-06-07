import { Component, OnInit } from '@angular/core';
import { TransmissionType } from '../../../models/transmissiontype';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TransmissionTypeService } from '../../../services/transmissiontype.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-transmissiontype',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './update-transmissiontype.component.html',
  styleUrl: './update-transmissiontype.component.scss'
})
export class UpdateTransmissionTypeComponent implements OnInit {
  id: number = 0;
  transmissiontype: TransmissionType = new TransmissionType();

  constructor(private transmissiontypeService: TransmissionTypeService,
              private route: ActivatedRoute,
              private router: Router
  ){}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.transmissiontypeService.getTransmissionTypeById(this.id)
      .subscribe({
        next: (data) => {
          console.log(data)
          this.transmissiontype = data;
        },
        error: (error) => console.log(error),
        complete: () => console.log("TransmissionType updated successfully.")
      })
  }

  onSubmit(){
    this.updateTransmissionTypeById();
  }

  updateTransmissionTypeById(){
    this.transmissiontypeService.updateTransmissionTypeById(this.id, this.transmissiontype)
      .subscribe({
        next: (data) => console.log(data),
        error: (error) => console.log(error),
        complete: () => this.goToTransmissionTypeList()
      })
  }

  goToTransmissionTypeList(){
    this.router.navigate(['/transmissiontypes/transmissiontypes-list']);
  }

}
