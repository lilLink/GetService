/*import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Search } from '../models/search/search.model';
import { SearchVacancyResponse } from '../models/search/SearchVacancyResponse.model';
import { Role } from '../models/roles.model';
import { UserPrincipal } from '../models/userPrincipal.model';

import { SearchService } from '../services/search.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-search-vacancy',
  templateUrl: './search-vacancy.component.html',
  styleUrls: ['./search-vacancy.component.scss'],
})
export class SearchVacancyComponent implements OnInit {

  currentUser: UserPrincipal;
  search: Search = new Search();
  searchVacancyResponse: SearchVacancyResponse = new SearchVacancyResponse();
  pageNumber: number;
  pagesCount: number;
  resultText = true;
  topButtons = true;
  previousButton: boolean;
  nextButton: boolean;
  bottomButtons = true;
  vacancySelect = false;
  resumeSelect = true;
  posHidden = false;
  coHidden = true;
  cHidden = true;
  emHidden = true;
  sHidden = true;

  constructor(private app: AuthenticationService,
    private router: Router,
    private route: ActivatedRoute,
    private searchService: SearchService) {
    this.app.currentUser.subscribe(x => this.currentUser = x);
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit() {
    this.route.params
      .subscribe(params => {
        this.search.searchDocument = params['searchDoc'];
        this.search.searchText = params['searchText'];
        this.search.searchParameter = params['searchParameter'];
      });
    if (this.search.searchText !== undefined) {
      this.startSearch();
    } else {
      this.search.searchDocument = 'vacancies';
      this.search.searchParameter = 'position';
    }
  }

  get isCowner() {
    return this.currentUser && this.currentUser.roles && this.currentUser.roles.indexOf(Role.ROLE_COWNER) > -1;
  }

  startSearch() {
    this.search.firstResultNumber = 0;
    this.resultText = false;
    this.searchService.getVacancyResult(this.search)
      .subscribe(data => {
        this.searchVacancyResponse = data;
        this.buttonsEnabled();
      });
  }

  buttonsEnabled() {
    this.pagesCount = Math.ceil(this.searchVacancyResponse.count / parseInt(this.search.resultsOnPage, 10));
    if (this.searchVacancyResponse.count > parseInt(this.search.resultsOnPage, 10)) {
      this.topButtons = false;
      this.nextButton = false;
      this.previousButton = true;
      this.pageNumber = 1;
      this.bottomButtonsShow();
    } else {
      this.topButtons = true;
      this.nextButton = true;
      this.previousButton = true;
      this.pageNumber = 1;
      this.bottomButtons = true;
    }
  }

  bottomButtonsShow() {
    if (parseInt(this.search.resultsOnPage, 10) > 4 && this.searchVacancyResponse.searchVacancyDtos.length > 4) {
      this.bottomButtons = false;
    } else {
      this.bottomButtons = true;
    }
  }

  nextPage() {
    this.search.firstResultNumber = this.search.firstResultNumber + parseInt(this.search.resultsOnPage, 10);
    this.searchService.getVacancyResult(this.search)
      .subscribe(data => {
        this.searchVacancyResponse = data;
        this.bottomButtonsShow();
        this.pageNumber++;
        if (this.pageNumber === this.pagesCount) {
          this.nextButton = true;
        }
        if (this.pageNumber !== 1) {
          this.previousButton = false;
        }
      });
  }

  previousPage() {
    this.search.firstResultNumber = this.search.firstResultNumber - parseInt(this.search.resultsOnPage, 10);
    this.searchService.getVacancyResult(this.search)
      .subscribe(data => {
        this.searchVacancyResponse = data;
        this.bottomButtonsShow();
        this.pageNumber--;
        if (this.pageNumber === this.pagesCount) {
          this.nextButton = true;
        } else {
          this.nextButton = false;
        }
        if (this.pageNumber > 1) {
          this.previousButton = false;
        } else {
          this.previousButton = true;
        }
      });
  }

  selectDocument() {
    switch (this.search.searchDocument) {
      case 'resume':
        this.resumeSelect = false;
        this.vacancySelect = true;
        break;
      case 'vacancies':
        this.resumeSelect = true;
        this.vacancySelect = false;
        break;
    }
  }

  start() {
    switch (this.search.searchDocument) {
      case 'resume':
        this.router.navigate(['/searchResume', {
          searchDoc: this.search.searchDocument,
          searchText: this.search.searchText,
          searchParameter: this.search.searchParameter
        }]);
        break;
      case 'vacancies':
        this.startSearch();
        break;
    }
  }

  sort(sortText: string) {
    switch (sortText) {
      case 'position':
        if (this.posHidden === false) {
          this.search.direction === 'desc' ? this.search.direction = 'asc' : this.search.direction = 'desc';
          this.hideAll();
          this.posHidden = false;
        } else {
          this.hideAll();
          this.posHidden = false;
          this.search.direction = 'asc';
        }
        break;
      case 'company':
        if (this.coHidden === false) {
          this.search.direction === 'desc' ? this.search.direction = 'asc' : this.search.direction = 'desc';
          this.hideAll();
          this.coHidden = false;
        } else {
          this.hideAll();
          this.coHidden = false;
          this.search.direction = 'asc';
        }
        break;
      case 'city':
        if (this.cHidden === false) {
          this.search.direction === 'desc' ? this.search.direction = 'asc' : this.search.direction = 'desc';
          this.hideAll();
          this.cHidden = false;
        } else {
          this.hideAll();
          this.cHidden = false;
          this.search.direction = 'asc';
        }
        break;
      case 'employment':
        if (this.emHidden === false) {
          this.search.direction === 'desc' ? this.search.direction = 'asc' : this.search.direction = 'desc';
          this.hideAll();
          this.emHidden = false;
        } else {
          this.hideAll();
          this.emHidden = false;
          this.search.direction = 'asc';
        }
        break;
      case 'salary':
        if (this.sHidden === false) {
          this.search.direction === 'desc' ? this.search.direction = 'asc' : this.search.direction = 'desc';
          this.hideAll();
          this.sHidden = false;
        } else {
          this.hideAll();
          this.sHidden = false;
          this.search.direction = 'asc';
        }
        break;
      default:
        this.hideAll();
        this.search.direction = 'asc';
    }
    this.search.searchSort = sortText;
    this.startSearch();
  }

  hideAll() {
    this.posHidden = true;
    this.coHidden = true;
    this.cHidden = true;
    this.emHidden = true;
    this.sHidden = true;
  }

}*/
