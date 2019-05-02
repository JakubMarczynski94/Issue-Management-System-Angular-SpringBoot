import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { FooterComponent, HeaderComponent, SidebarComponent, AppLayoutComponent } from './_layout';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { ApiService } from './services/api.service';
import { ProjectService } from './services/shared/project.service';
import { IssueService } from './services/shared/issue.service';
import { UserService } from './services/shared/user.service';
import { IssueHistoryService } from './services/shared/issue.history.service';
import { NotfoundComponent } from './shared/notfound/notfound.component';

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/lang/', '.json');
}
@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent,
    NotfoundComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxDatatableModule,
    AppRoutingModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    })
  ],
  providers: [ApiService, ProjectService, IssueService, UserService, IssueHistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
