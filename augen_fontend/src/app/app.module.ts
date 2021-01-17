import { AppRoutingModule } from './app-routing.module';

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng-lts/dropdown';
import { SelectButtonModule } from 'primeng-lts/selectbutton';
import { RadioButtonModule } from 'primeng-lts/radiobutton';
import { ScrollPanelModule } from 'primeng-lts/scrollpanel';
import { ProgressSpinnerModule } from 'primeng-lts/progressspinner';


import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { BuyConfirmComponent } from './pages/buy-confirm/buy-confirm.component';
import { BookCardComponent } from './components/book-card/book-card.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        BuyConfirmComponent,
        BookCardComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        FormsModule,
        HttpClientModule,
        InputTextModule,
        DialogModule,
        ButtonModule,
        DropdownModule,
        SelectButtonModule,
        RadioButtonModule,
        ScrollPanelModule,
        ProgressSpinnerModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
