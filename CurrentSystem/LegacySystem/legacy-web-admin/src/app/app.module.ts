import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {FooterComponent} from './components/footer/footer.component';
import {PasswordRecoveryComponent} from './components/password-recovery/password-recovery.component';
import {AdminDashboardComponent} from './components/admin-dashboard/admin-dashboard.component';

const appRoutes: Routes = [
  {path: 'admin', component: AdminDashboardComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'auth/password-recovery', component: PasswordRecoveryComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    PasswordRecoveryComponent,
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
