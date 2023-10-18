import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Crop } from '../models/crop';
import { Farmer } from '../models/farmer';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8090/farmer-service";

  getCrops(email:string){
    return this.http.get<Crop[]>(`${this.url}/fetchCropsFarmerEmail/${email}`);
  }
  getFarmerName(){
    return this.http.get
  }
  getFarmerEmail(token:any){
    const payloadEmail=JSON.parse(atob(token.split('.')[1]));
    const email:string= payloadEmail.email;
    return email;
  }
  getToken(){
    return localStorage.getItem('token')
  }
  // getFarmer(email:string){
  //   return this.http.get<Farmer>(`${this.url}/fetchCropsFarmerEmail/${email}`);
  // }
}
