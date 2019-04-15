import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'issue-management-angular7';
  message1 = 'issue-management-angular7 is starting by Hacı Celal Aygar';
  message2: string ;
  id: number;

  constructor() {
    this.id = 1;
    this.id ++;
    this.message2 = 'This all project is starting by Hacı Celal Aygar id : ' + this.id;
  }
}
