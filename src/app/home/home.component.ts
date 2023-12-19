import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'
import { MapComponent } from '../map/map.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterModule, MapComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor() {
  }

  ngOnit() {

  }

  url_logo="./assets/Logo.png"

}
