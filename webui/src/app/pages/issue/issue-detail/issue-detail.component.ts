import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IssueService } from 'src/app/services/shared/issue.service';
import { ProjectService } from 'src/app/services/shared/project.service';
import { UserService } from 'src/app/services/shared/user.service';

@Component({
  selector: 'app-issue-detail',
  templateUrl: './issue-detail.component.html',
  styleUrls: ['./issue-detail.component.scss']
})
export class IssueDetailComponent implements OnInit {
  id: number;
  sub: any;

  // Options parameters for dropdown input
  AssigneeOptions = [];
  projectOptions = [];
  issueDetails = [];
  issueStatusesOptions = [];

  // Datatable properties
  datatable = [];
  columns = [];
  constructor(private route: ActivatedRoute,
              private userService: UserService,
              private projectService: ProjectService,
              private issueService: IssueService) {

  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = params[ 'id' ];
      this.loadIssueDetails();
    });
    this.columns = [
      { prop: 'id', name: 'No' },
      { prop: 'description', name: 'Description' },
      // { prop: 'details', name: 'Details' },
      { prop: 'issueStatus', name: 'issue Status' },
      { prop: 'assignee.username', name: 'Username' },
      { prop: 'issue.project.projectName', name: 'Project Name' },
      { prop: 'issue.project.projectCode', name: 'Project Code' },
    ];
    this.loadProject();
    this.loadAssignees();
    // this.loadIssueStatues();
  }
  loadIssueStatues() {
    this.issueService.getAllIssueStatuses().subscribe(res => {
      this.issueStatusesOptions = res;
    });
  }
  loadProject() {
    this.projectService.getAll().subscribe(res => {
      this.projectOptions = res;
    });
  }
  loadAssignees() {
    this.userService.getAll().subscribe(res => {
      this.AssigneeOptions = res;
    });
  }
  loadIssueDetails() {
    this.issueService.getByIdWithDetails(this.id).subscribe(res => {
      this.issueDetails = res;
      this.datatable = res['issueHistories']
    }
    );
  }
}
