import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FuelType } from '../models/fueltype';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FuelTypeService {

  private baseURL = "http://localhost:8080/api/v1/fueltypes";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllFuelTypes(): Observable<FuelType[]> {
    return this.httpClient.get<FuelType[]>(`${this.baseURL}`);
  }

  createFuelType(fueltype: FuelType): Observable<any> {
    return this.httpClient.post(`${this.baseURL}`, fueltype);
  }

  getFuelTypeById(id: number): Observable<FuelType> {
    return this.httpClient.get<FuelType>(this.baseURL + '/' + id);
  }

  updateFuelTypeById(id: number, fueltype: FuelType): Observable<Object> {
    return this.httpClient.put(this.baseURL + '/' + id, fueltype);
  }

  deleteFuelTypeById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }



}
