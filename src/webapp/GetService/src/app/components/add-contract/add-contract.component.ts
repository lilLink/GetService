import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';



import { Contract } from '../../models/contract.model';

import { Skill } from 'src/app/models/skill.model';
import { ContractService } from 'src/app/services/contract.service';
import { SkillService } from 'src/app/services/skill.service';


@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.scss']
})
export class AddContractComponent implements OnInit {
   
  contract: Contract = new Contract();
  skills: Skill[] = Array<Skill>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private contractService: ContractService,
              private skillService: SkillService) { }

  ngOnInit(): void {
    var cvId = this.route.snapshot.paramMap.get("contractId");
    if (cvId !== null) {
      this.contractService.findById(cvId)
        .subscribe(data => {
          this.contract = data;
        });
    }
  };

  update(): void {
    this.contractService.update(this.contract)
      .subscribe(data => {
        if (data != null) {
          this.router.navigate(['/contract/view']);
        } else {
          alert("Validation problem has been occured");
        }
      });
  };

  insert(): void {
    console.log(this.contract);
    this.contractService.create(this.contract)
      .subscribe(data => {
        if (data != null) {
          this.router.navigate(['/contract/view']);
        } else {
          alert("Validation problem has been occured");
        }
      });
  };

  deleteSkill(skill: Skill): void {
    this.skillService.deleteById(skill)
      .subscribe(() => {
        this.skills = this.skills.filter(p => p !== skill);
        window.location.reload();
      })
  }

  newSkill() {
    console.log("this.contract.neededSkills");
    console.log(this.contract.neededSkills);
    this.contract.neededSkills.push(new Skill());
  }

  removeInputFieldSkill(index: number): void {
    this.contract.neededSkills.splice(index, 1);
  }

}
