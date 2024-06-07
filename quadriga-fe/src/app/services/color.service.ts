import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Color } from '../models/color';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ColorService {

  private baseURL = "http://localhost:8080/api/v1/colors";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAllColors(): Observable<Color[]> {
    return this.httpClient.get<Color[]>(`${this.baseURL}`);
  }

  createColor(Color: Color): Observable<any>{
    return this.httpClient.post(`${this.baseURL}`, Color);
  }

  getColorById(id: number): Observable<Color> {
    return this.httpClient.get<Color>(this.baseURL + '/' + id);
  }
  
  updateColorById(id: number, Color: Color): Observable<Object>{
    return this.httpClient.put(this.baseURL + '/' + id, Color);
  }

  deleteColorById(id: number): Observable<Object> {
    return this.httpClient.delete(this.baseURL + '/' + id);
  }



}
