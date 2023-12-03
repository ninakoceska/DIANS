import { Routes } from '@angular/router';
import { wineryComponent } from './winery/winery.component';
import { HomeComponent } from './home/home.component';


const routerConfig: Routes = [

  { path: '', component: HomeComponent, title: "Home Page" },
  { path: 'wineries', component: wineryComponent, title: "WineriesTable" }
]

export default routerConfig;
