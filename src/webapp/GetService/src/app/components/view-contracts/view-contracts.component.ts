import { Component, OnInit } from '@angular/core';
import {Contract} from '../../models/contract.model';
import { ContractService } from '../../services/contract.service';


@Component({
  selector: 'app-view-contracts',
  templateUrl: './view-contracts.component.html',
  styleUrls: ['./view-contracts.component.scss']
})
export class ViewContractsComponent implements OnInit {

  contracts: Contract[];

  constructor(private contractService: ContractService) { }

  ngOnInit() {
    
    this.contractService.findAll()
      .subscribe(data => {
        console.log(data);
        this.contracts = data;
      });
      
  };

  deleteById(con: Contract): void {
    console.log(con.contractId);
    this.contractService.deleteById(con)
      .subscribe(() => {
        this.contracts = this.contracts.filter(p => p !== con);
      });
  }

}
