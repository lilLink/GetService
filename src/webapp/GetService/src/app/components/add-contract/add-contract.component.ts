import { Component, OnInit } from '@angular/core';
import { Contract } from '../../models/contract.model';


@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.scss']
})
export class AddContractComponent implements OnInit {
   
  contract: Contract = new Contract();

  constructor() { }

  ngOnInit(): void {
  }

  newSkill() {
    this.contract.neededSkills.push();
  }

}
