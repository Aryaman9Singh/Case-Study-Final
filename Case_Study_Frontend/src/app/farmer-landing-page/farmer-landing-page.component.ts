import { Component } from '@angular/core';
import { Crop } from '../models/crop';
import { FarmerService } from '../services/farmer.service';
import { Farmer } from '../models/farmer';

@Component({
  selector: 'app-farmer-landing-page',
  templateUrl: './farmer-landing-page.component.html',
  styleUrls: ['./farmer-landing-page.component.css']
})
export class FarmerLandingPageComponent {

  constructor(private farmerService:FarmerService){
    // this.farmer=new Farmer();
  }
  crops:Crop[]=[];
  cropTemp:Crop[]=[];
  // farmer:Farmer;

  quantity:number=0;
  

  ngOnInit():void{
    this.getCrops();
    // this.getFarmer();
    console.log(this.quantity)
   
  }
  getCrops():void{
    const email=this.farmerService.getFarmerEmail(this.farmerService.getToken())
    console.log(email)
    this.farmerService.getCrops(email).subscribe({ next:(response:Crop[])=>{
      this.crops=response
      // this.quantity=this.crops.
      // console.log(response)
      // console.log(this.crops)
      this.cropTemp=this.crops
      console.log(this.cropTemp)
    },
    error:(error:any)=>console.log(error)}
    )
  }
  onQuantityChange(crop: Crop): void {
    // This function is called when the quantity of a specific crop changes.
    console.log(`New quantity for ${crop.cropName}: ${crop.cropqnty}`);
  }


  // getFarmer(){
  //   const email=this.farmerService.getFarmerEmail(this.farmerService.getToken())
  // }

  
}
