import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TransmissionType } from '../models/transmissiontype';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransmissionTypeService {

  private baseURL = "http://localhost:8080/api/v1/transmissiontypes";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllTransmissionTypes(): Observable<TransmissionType[]> {
    return this.httpClient.get<TransmissionType[]>(`${this.baseURL}`);
  }

  createTransmissionType(fueltype: TransmissionType): Observable<any> {
    return this.httpClient.post(`${this.baseURL}`, fueltype);
  }

  getTransmissionTypeById(id: number): Observable<TransmissionType> {
    return this.httpClient.get<TransmissionType>(this.baseURL + '/' + id);
  }

  updateTransmissionTypeById(id: number, fueltype: TransmissionType): Observable<Object> {
    return this.httpClient.put(this.baseURL + '/' + id, fueltype);
  }

  deleteTransmissionTypeById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }



}
