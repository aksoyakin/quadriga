import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Brand } from '../models/brand';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  private baseURL = "http://localhost:8080/api/v1/brands";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllBrands(): Observable<Brand[]> {
    return this.httpClient.get<Brand[]>(`${this.baseURL}`);
  }

  createBrand(brand: Brand): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, brand);
  }

  getBrandById(id: number): Observable<Brand> {
    return this.httpClient.get<Brand>(this.baseURL + '/' + id);
  }
  
  updateBrandById(id: number, brand: Brand): Observable<Object>{
    return this.httpClient.put(this.baseURL + '/' + id, brand);
  }

  deleteBrandById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }



}
