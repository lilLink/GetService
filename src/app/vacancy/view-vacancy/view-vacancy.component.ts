import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Vacancy } from '../../models/vacancy/vacancy.model';
import { Role } from '../../models/roles.model';
import { Resume } from '../../models/resume.model';
import { Company } from '../../models/company/company.model';
import { UserPrincipal } from '../../models/userPrincipal.model';

import { VacancyService } from '../../services/vacancy.service';
import { CompanyService } from '../../services/company.service';
import { ResumeService } from '../../services/resume.service';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-view-vacancy',
  templateUrl: './view-vacancy.component.html',
  styleUrls: ['./view-vacancy.component.scss']
})
export class ViewVacancyComponent implements OnInit {

  vacancy: Vacancy = new Vacancy();
  company: Company = new Company();
  resume: Resume = new Resume();
  currentUser: UserPrincipal;

  constructor(private location: Location, private app: AuthenticationService, private resumeService: ResumeService, private route: ActivatedRoute,
    private router: Router, private vacancyService: VacancyService, private companyService: CompanyService) {
    this.app.currentUser.subscribe(data => this.currentUser = data);
  }

  goBack() {
    this.location.back();
  }

  ngOnInit() {
    let vacancyId = this.route.snapshot.paramMap.get('vacancyId');
    if (vacancyId !== null) {
      this.vacancyService.get(vacancyId)
        .subscribe(data => {
          this.vacancy = data;
        });

      this.companyService.getCompanyByVacanycId(vacancyId)
        .subscribe(com => {
          this.company = com;
        });
    }
  };

  // sendResume() {
  //   this.resumeService.findByUserId()
  //     .subscribe(data => {
  //       this.resume = data;
  //     });

  //   this.vacancyService.sendResume(this.resume, this.vacancyId)
  //     .subscribe(data => {
  //       alert("Resume was sent on this resume")
  //     }, error => console.error(error));
  // }

  showPreviewPdf() {
    this.resumeService.findByUserId()
      .subscribe(data => {
        if (data != null) {
          this.resume = data;
          this.router.navigate(['/previewResumePdf', this.resume.resumeId, this.vacancy.vacancyId])
        } else {
          alert("Validation problem has been occured");
        }
      });
  }

  get isCowner() {
    return this.currentUser && this.currentUser.roles && this.currentUser.roles.indexOf(Role.ROLE_COWNER) > -1;
  }

  get isUser() {
    return this.currentUser && this.currentUser.roles && this.currentUser.roles.indexOf(Role.ROLE_USER) > -1;
  }

}
