import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WineryService {

  constructor(private http: HttpClient) {
  }

  getWineries() {

    return this.http.get("http://localhost:8080/api/all");

  }
}
