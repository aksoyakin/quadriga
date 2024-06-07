import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../models/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseURL = "http://localhost:8080/api/v1/categories";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllCategories(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.baseURL}`);
  }

  createCategory(category: Category): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, category);
  }

  getCategoryById(id:number): Observable<Category>{
    return this.httpClient.get<Category>(this.baseURL + '/' + id);
  }

  updateCategoryById(id: number, category: Category): Observable<Object>{
    return this.httpClient.put(this.baseURL + '/' + id, category);
  }

  deleteCategoryById(id:number): Observable<Object>{
    return this.httpClient.delete(this.baseURL + '/' + id);
  }

}
