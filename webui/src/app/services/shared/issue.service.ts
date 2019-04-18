
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import {map} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class IssueService {
  ISSUE_PATH = '/issue';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private apiService: ApiService, private http: HttpClient) { }


}
