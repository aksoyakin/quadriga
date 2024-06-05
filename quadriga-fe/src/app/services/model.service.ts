import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Model } from '../models/model';

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  private baseURL = "http://localhost:8080/api/v1/models";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllModels(): Observable<Model[]> {
    return this.httpClient.get<Model[]>(`${this.baseURL}`);
  }

  createModel(model: Model): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, model);
  }

  getModelById(id: number): Observable<Model> {
    return this.httpClient.get<Model>(this.baseURL + '/' + id);
  }

  updateModelById(id: number, model: Model): Observable<Object> {
    return this.httpClient.put(this.baseURL + '/' + id, model);
  }

  deleteModelById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }


}
