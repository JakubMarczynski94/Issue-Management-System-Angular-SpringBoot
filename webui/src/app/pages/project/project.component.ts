import { Component, OnInit, TemplateRef } from '@angular/core';
import { ProjectService } from 'src/app/services/shared/project.service';
import { Page } from 'src/app/common/Page';
import { Project } from 'src/app/common/project.module';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],

})
export class ProjectComponent implements OnInit {
  page = new Page();
  rows = new Array<Project>();
  projectForm: FormGroup;
  modalRef: BsModalRef;
  projectTitle: string;
  cols = [
    { prop: 'id', name: 'No' },
    { prop: 'projectName', name: 'Project Name', sortable: false },
    { prop: 'projectCode', name: 'Project Code', sortable: false },
  ];
  constructor(private projectService: ProjectService,
              private modalService: BsModalService,
              private formBuilder: FormBuilder) {
    this.projectTitle = 'Project Details';
  }

  ngOnInit() {
    this.setPage({ offset: 0 });
    this.projectTitle = 'Project Details Extra';
    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]]
    });
  }

  get f(){
    return this.projectForm.controls;
  }
  saveProject(){
    if(!this.projectForm.valid){
      return ;
    }
    this.projectService.createProject(this.projectForm.value).subscribe(
      res=>{
        console.log(res);
      }
    );
    this.closeAndResetModal();
    this.setPage({ offset: 0 });
  }
  closeAndResetModal(){
    this.projectForm.reset();
    this.modalRef.hide();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAllPageable(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }
}
