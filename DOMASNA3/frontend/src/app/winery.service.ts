import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WineryService {

  constructor(private http: HttpClient) {
  }

  getAllWineries() {

    return this.http.get("http://localhost:8080/api/all");
  }


  getWinery(id: number) {
    const url = `http://localhost:8080/api/${id}`;
    return this.http.get(url);
  }






}
