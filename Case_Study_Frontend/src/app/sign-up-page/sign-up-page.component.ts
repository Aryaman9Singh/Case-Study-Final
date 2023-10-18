import { Component } from '@angular/core';
import { SignUpService } from '../services/sign-up.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent {
  constructor(private signUpService:SignUpService,private loginService:LoginService){

  }
  show = '';
  farmerCredentials={
    farmerName:'',
    farmerEmail:'',
    farmerPassword:'',
    farmerBank:'',
    farmerPaytmId:'',
    farmerAccountNo:'',
    farmerBankBranch:'',
    farmerContact:'',
    farmerLocation:'',
    farmerAbout:''
  }
  dealerCredentials={
    dealerName:'',
    dealerEmail:'',
    dealerPassword:'',
    dealerBank:'',
    dealerPaytmId:'',
    dealerAccountNo:'',
    dealerBankBranch:'',
    dealerContact:'',
    dealerLocation:'',
    dealerAbout:''
  }
  userCredentials={
    username:'',
    password:''
  }
  toggleFarmerShow(){
    this.show='farmer';
  }
  toggleDealerShow(){
    this.show='dealer';
  }

  onSubmit(){
    console.log(this.show + "hello signupo compo")
    if(this.show==='farmer'){

      if(this.farmerCredentials.farmerName!==null 
        &&
        this.farmerCredentials.farmerPassword!==null
        &&
        this.farmerCredentials.farmerPaytmId!==null
        &&
        this.farmerCredentials.farmerLocation!==null
        &&
        this.farmerCredentials.farmerEmail!== null
        &&
        this.farmerCredentials.farmerContact!==null
        &&
        this.farmerCredentials.farmerAbout!==null
        &&
        this.farmerCredentials.farmerAccountNo!==null
        && 
        this.farmerCredentials.farmerBank!== null
        && 
        this.farmerCredentials.farmerBankBranch!==null){
  
          this.signUpService.doSignUp(this.farmerCredentials,this.show)?.subscribe({
            next:(response:string)=>{
              // console.log(response)
              
             
              if(this.show='farmer' ) {
                this.userCredentials.username=this.farmerCredentials.farmerName;
                this.userCredentials.password=this.farmerCredentials.farmerPassword;
                this.loginService.doLogin(this.userCredentials).subscribe({
                  next:(response:string)=>{
                    // console.log(response)
                    this.loginService.loginUser(response)
                    if(this.loginService.getRoles(response)==="ROLE_FARMER" ) {
                      // console.log("dealer");
                      window.location.href="/farmer";
                    }
                  },
                  error:(error:any)=>console.log(error),
                  complete:()=>console.log("completed")
                  
                  
                })
              } 
            },
            error:(error:any)=>console.log(error),
            complete:()=>console.log("completed")
            
            
          })
  
  
        }
    }
    else if(this.show==='dealer'){

      if(this.dealerCredentials.dealerName!==null 
        &&
        this.dealerCredentials.dealerPassword!==null
        &&
        this.dealerCredentials.dealerPaytmId!==null
        &&
        this.dealerCredentials.dealerLocation!==null
        &&
        this.dealerCredentials.dealerEmail!== null
        &&
        this.dealerCredentials.dealerContact!==null
        &&
        this.dealerCredentials.dealerAbout!==null
        &&
        this.dealerCredentials.dealerAccountNo!==null
        && 
        this.dealerCredentials.dealerBank!== null
        && 
        this.dealerCredentials.dealerBankBranch!==null){

          
          this.signUpService.doSignUp(this.dealerCredentials,this.show)?.subscribe({
              next:(response:string)=>{
                if(this.show==="dealer" ) {
                  this.userCredentials.username=this.dealerCredentials.dealerName;
                  this.userCredentials.password=this.dealerCredentials.dealerPassword;
                  this.loginService.doLogin(this.userCredentials).subscribe({
                    next:(response:string)=>{
                      // console.log(response)
                      this.loginService.loginUser(response)
                      if(this.loginService.getRoles(response)==="ROLE_DEALER" ) {
                        // console.log("dealer");
                        window.location.href="/dealer";
                      }
                    },
                    error:(error:any)=>console.log(error),
                    complete:()=>console.log("completed")
                    
                    
                  })
                  // console.log("dealer");
                }
              },
              error:(error:any)=>console.log(error),
            complete:()=>console.log("completed")
            })
        }
    }
    

  }

  
}
