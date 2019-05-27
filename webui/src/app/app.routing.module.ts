import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppLayoutComponent } from './_layout';
import { NotfoundComponent } from './shared/notfound/notfound.component';
import { AuthGuard } from './security/auth.guard';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
    {
      path: '',    component: AppLayoutComponent, canActivate: [AuthGuard],
      children: [
        {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
        {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
        {path: 'issue', loadChildren: './pages/issue/issue.module#IssueModule'},
        {path: 'project', loadChildren: './pages/project/project.module#ProjectModule'},
      ]
    },
    {path: 'login', component: LoginComponent},
    { path: '**',    component: NotfoundComponent, }
  ];

@NgModule({

    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}


