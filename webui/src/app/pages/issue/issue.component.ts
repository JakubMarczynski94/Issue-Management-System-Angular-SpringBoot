import { Component, OnInit, TemplateRef } from '@angular/core';
import { IssueService } from 'src/app/services/shared/issue.service';
import { Page } from 'src/app/common/Page';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { ProjectService } from 'src/app/services/shared/project.service';

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {
  // new ıssue parameters
  IssueForm: FormGroup;
  modalRef: BsModalRef;
  projectOptions = [];

  // issue listing parameters
  page = new Page();
  rows = [];
  projectsName = [];
  constructor(private issueService: IssueService,
              private formBuilder: FormBuilder,
              private projectService: ProjectService, 
              private modalService: BsModalService) {

  }

  ngOnInit() {
    this.loadProject();
    this.setPage({ offset: 0 });
    this.IssueForm = this.formBuilder.group({
      'description': [null, [Validators.required]],
      'projectId': [null, [Validators.required]]
    });
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

  saveIssue(){
    if (!this.IssueForm.valid) {
      return;
    }
    this.issueService.createIssue(this.IssueForm.value).subscribe(res=>{
      this.setPage({ offset: 0 });
      this.IssueForm.reset();
      this.closeAndResetModal();
      console.log("-------------------------------2");
    });
  }
  get f() { return this.IssueForm.controls; }
  loadProject() {
    this.projectService.getAll().subscribe(res => {
      this.projectOptions = res;
    });
  }
  closeAndResetModal() {
    this.modalRef.hide();
    console.log("--------------------------------1");
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
}
