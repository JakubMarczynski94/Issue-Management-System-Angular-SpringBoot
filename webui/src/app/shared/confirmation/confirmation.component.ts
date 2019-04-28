import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.scss']
})
export class ConfirmationComponent implements OnInit {

  private body: string;
  private header: string;
  onClose: Subject<boolean>;
  private active: boolean;

  constructor(private bsModalRef: BsModalRef) { }

  ngOnInit() {
    this.onClose = new Subject();
  }

  showConfirmation(header: string, body: string) {
    this.body = body;
    this.header = header;
    this.active = true;

  }
  onConfirm() {
    this.active = false;
    this.onClose.next(true);
    this.bsModalRef.hide();
  }

  onCancel() {
    this.active = false;
    this.onClose.next(false);
    this.bsModalRef.hide();
  
  }


}
