import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import { IssueRoutingModule } from './issue.routing.module';
import { IssueService } from 'src/app/services/shared/issue.service';

@NgModule({
  declarations: [IssueComponent],
  imports: [
    CommonModule,
    IssueRoutingModule
  ],
  providers: [IssueService]
})
export class IssueModule { }
