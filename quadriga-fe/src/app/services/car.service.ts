import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseURL = "http://localhost:8080/api/v1/cars";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllCars(): Observable<Car[]> {
    return this.httpClient.get<Car[]>(`${this.baseURL}`);
  }

  createCar(car: Car): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, car);
  }

  getCarById(id: number): Observable<Car> {
    return this.httpClient.get<Car>(this.baseURL + '/' + id);
  }
  
  updateCarById(id: number, car: Car): Observable<Object>{
    return this.httpClient.put(this.baseURL + '/' + id, car);
  }

  deleteCarById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }

  getCarByCategoryId(categoryId: number): Observable<Car[]> {
    return this.httpClient.get<Car[]>(`${this.baseURL}/getByCategoryId?categoryId=${categoryId}`);
  }
}
