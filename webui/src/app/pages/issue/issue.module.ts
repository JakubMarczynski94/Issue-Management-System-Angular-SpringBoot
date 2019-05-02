import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import { IssueRoutingModule } from './issue.routing.module';
import { IssueService } from 'src/app/services/shared/issue.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

@NgModule({
  declarations: [IssueComponent],
  imports: [
    CommonModule,
    NgxDatatableModule,
    IssueRoutingModule,
    SharedModule
  ],
  providers: [IssueService]
})
export class IssueModule { }
