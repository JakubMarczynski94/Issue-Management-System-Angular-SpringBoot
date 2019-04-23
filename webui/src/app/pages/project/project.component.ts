import { Component, OnInit, TemplateRef } from '@angular/core';
import { ProjectService } from 'src/app/services/shared/project.service';
import { Page } from 'src/app/common/Page';
import { Project } from 'src/app/common/project.module';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  page = new Page();
  rows = new Array<Project>();
  modalRef: BsModalRef;
  projectTitle: string;
  cols = [
    { prop: 'id', name: 'No' },
    { prop: 'projectName', name: 'Project Name', sortable: false },
    { prop: 'projectCode', name: 'Project Code', sortable: false },
  ];
  constructor(private projectService: ProjectService, private modalService: BsModalService) {
    this.projectTitle = 'Project Details';
  }

  ngOnInit() {
    this.setPage({ offset: 0 });
    this.projectTitle = 'Project Details Extra';
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
