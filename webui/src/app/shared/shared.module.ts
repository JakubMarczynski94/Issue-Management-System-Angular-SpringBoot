import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import {BsModalRef, ModalModule} from 'ngx-bootstrap';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ConfirmationComponent } from './confirmation/confirmation.component';
@NgModule({
  declarations: [ConfirmationComponent ],
  imports: [
    CommonModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  entryComponents: [ConfirmationComponent],
  providers: [BsModalRef],
  exports: [
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
    ConfirmationComponent
  ]
})
export class SharedModule { }
