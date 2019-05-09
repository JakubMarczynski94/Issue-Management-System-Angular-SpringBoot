import { Component, OnInit } from '@angular/core';
import { IssueService } from 'src/app/services/shared/issue.service';
import { Page } from 'src/app/common/Page';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {
  page = new Page();
  rows = [];
  projectsName = [];
  constructor(private issueService: IssueService) { }

  ngOnInit() {
    this.setPage({ offset: 0 });

  }


  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.issueService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
      // get specific data on array
      // this.projectsName =this.rows.map(t => t.project.projectName);
      // console.log(this.projectsName);
      // console.log('-------------------------------------------');
      // console.log(this.projectsName[0]);
      // console.log(this.projectsName[1]);
      // console.log('-------------------------------------------');
      // this.projectsName =this.rows.map(t => t.project);
      // console.log(this.projectsName[0].projectName);
      // console.log(this.projectsName[1].projectName);
    });
  }

}
