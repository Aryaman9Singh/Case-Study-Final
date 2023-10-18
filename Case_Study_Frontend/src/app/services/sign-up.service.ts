import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  url="http://localhost:8081/auth";

  constructor(private http:HttpClient) { }
  
  doSignUp(credentials:any,show:any){
    //token generate
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      // 'Authorization': "Basic" + btoa(credentials)
  });
  console.log(show);
  if(show==='farmer'){
    return this.http.post(`${this.url}/registerFarmer`,credentials,{headers,responseType:'text'})
  }
  else if(show==='dealer'){
    return this.http.post(`${this.url}/registerDealer`,credentials,{headers,responseType:'text'})
  }
  else{
    return console.error("error");
    
  }

  }

}
