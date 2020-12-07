import { Component, OnInit } from '@angular/core';
import { Contract } from 'src/app/models/contract';
import { ContractService } from 'src/app/services/contract.service';

@Component({
  selector: 'app-view-contract',
  templateUrl: './view-contract.component.html',
  styleUrls: ['./view-contract.component.scss']
})
export class ViewContractComponent implements OnInit {

  contracts: Contract[];

  constructor(private contractService: ContractService) { }

  ngOnInit() {
    this.contractService.findAll()
      .subscribe(data => {
        this.contracts = data;
      });
  };

  deleteById(cv: Contract): void {
    this.contractService.deleteById(cv)
      .subscribe(() => {
        this.contracts = this.contracts.filter(p => p !== cv);
      });
  }

}
