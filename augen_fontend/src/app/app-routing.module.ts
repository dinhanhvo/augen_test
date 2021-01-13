import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BuyConfirmComponent } from './pages/buy-confirm/buy-confirm.component';
import { HomeComponent } from './pages/home/home.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  // { path: 'buy', component: BuyConfirmComponent },
  { path: 'confirm/:id', component: BuyConfirmComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
