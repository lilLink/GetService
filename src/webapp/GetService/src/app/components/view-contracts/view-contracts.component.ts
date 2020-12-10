import { Component, OnInit } from '@angular/core';
import {Contract} from '../../models/contract.model';


@Component({
  selector: 'app-view-contracts',
  templateUrl: './view-contracts.component.html',
  styleUrls: ['./view-contracts.component.scss']
})
export class ViewContractsComponent implements OnInit {

  contracts: Contract[];
  contruct: Contract;
  

  constructor() { }

  ngOnInit(): void {
    this.contruct = new Contract();
    this.contruct[1] = {
      description: "dasdasd",
      price: 12
    };
    
    
    this.contracts.push(this.contruct);
    console.log(this.contracts);

  }

}
