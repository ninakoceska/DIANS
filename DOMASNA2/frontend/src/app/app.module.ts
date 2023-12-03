

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { wineryComponent } from './winery/winery.component';
import { HomeComponent } from './home/home.component';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    wineryComponent,
    HomeComponent,

    // Add other components, directives, and pipes here\
  ],
  imports: [BrowserModule, HttpClientModule, FormsModule, wineryComponent, HomeComponent, RouterLink, RouterLinkActive, RouterOutlet],

  

  bootstrap: [AppComponent]

})


export class AppModule { }
