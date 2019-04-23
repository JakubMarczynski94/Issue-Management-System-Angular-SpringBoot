import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import {BsModalRef, ModalModule} from 'ngx-bootstrap';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers: [BsModalRef],
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
  ]
})
export class SharedModule { }
