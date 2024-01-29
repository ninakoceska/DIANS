import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { wineryComponent } from './winery/winery.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, wineryComponent, RouterLink, RouterLinkActive, HomeComponent, RouterModule],
  styleUrls: ['./app.component.css'],
  templateUrl: './app.component.html',
 
})
export class AppComponent {
  title = 'Wineries in Macedonia';
}

