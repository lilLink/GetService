import { Component, OnInit } from '@angular/core';
import { Contract } from 'src/app/models/contract';
import { ContractService } from 'src/app/services/contract.service';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.scss']
})
export class ContractsComponent implements OnInit {

  contracts: Contract[];

  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.contractService.findAll()
      .subscribe( data => {
        this.contracts = data;
      });
  }
}
