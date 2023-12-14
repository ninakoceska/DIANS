import { Component, OnInit, Injectable } from '@angular/core';
import { CommonModule } from '@angular/common' 
import { WineryService } from '../winery.service';

@Component({
  selector: 'app-winery',
  standalone: true,
  styleUrls: ['./winery.component.css'],
  templateUrl: './winery.component.html',
  imports: [CommonModule],
 
})

@Injectable()
export class wineryComponent  {


  wineries: any;
  constructor(private service: WineryService) { }


  ngOnInit(): void {
    this.wineries = this.service.getAllWineries().subscribe(data => this.wineries = data);
  }


  
}
  

