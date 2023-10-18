import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:8081/auth"
  constructor( private http:HttpClient) { }


  //calling server to generate token
  

  doLogin(credentials:any){
    //token generate
    const headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Authorization': "Basic" + btoa(credentials)
});

    return this.http.post(`${this.url}/authenticate`,credentials,{headers,responseType:'text'})

  }
  //for login user
  loginUser(token:string){
    localStorage.setItem('token',token);
     // Retrieve the token from localStorage

  
    return true;
  }
  getRoles(token:string){
    if (token) {
      const tokenPayload = JSON.parse(atob(token.split('.')[1]));
      console.log(tokenPayload);
  
    // Now you can access the roles from the token payload
    const roles = tokenPayload.roles; // Assuming 'roles' is the field in the payload containing roles
    console.log('Roles:', roles);
    return roles;
    }
  }
  //check user is logged in or not
  isLoggedIn(){
    let token = localStorage.getItem('token');
    
    
    if(token===undefined || token==='' || token === null ){
      
      
      return false;
    }
    else{
      return true;
    }
  }
  //for log out user
  logout(){
    localStorage.removeItem('token');
    return true;
  }
  getToken(){
    return localStorage.getItem('token');
  }
}
