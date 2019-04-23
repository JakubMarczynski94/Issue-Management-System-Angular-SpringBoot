import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from './project.component';
import { ProjectRoutingModule } from './project.routing.module';
import { ProjectService } from 'src/app/services/shared/project.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [ProjectComponent],
  imports: [
    CommonModule,
    NgxDatatableModule,
    ProjectRoutingModule,
    SharedModule
  ],
  providers: [ProjectService],
})
export class ProjectModule { }
