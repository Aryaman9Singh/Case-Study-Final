import { Crop } from "./crop";

export class Farmer {
    farmerId: string;
    farmerEmail: string;
    farmerPassword: string;
    farmerName: string;
    farmerBank: string;
    farmerPaytmId: string;
    farmerAccountNo: string;
    farmerBankBranch: string;
    farmerContact: string;
    farmerLocation: string;
    farmerAbout: string;
    crops: Crop[];
  
    constructor() {
      this.farmerId = '';
      this.farmerEmail = '';
      this.farmerPassword = '';
      this.farmerName = '';
      this.farmerBank = '';
      this.farmerPaytmId = '';
      this.farmerAccountNo = '';
      this.farmerBankBranch = '';
      this.farmerContact = '';
      this.farmerLocation = '';
      this.farmerAbout = '';
      this.crops = [];
    }
  }
  