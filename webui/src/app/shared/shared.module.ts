import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import {BsModalRef, ModalModule} from 'ngx-bootstrap';
@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [BsModalRef],
  exports: [
    TranslateModule,
    ModalModule
]
})
export class SharedModule { }
