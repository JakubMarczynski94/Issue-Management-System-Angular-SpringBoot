
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { map } from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class IssueService {
  getByIdWıthDetails(id: number) {
    throw new Error('Method not implemented.');
  }
  ISSUE_PATH = '/issue';
  private ISSUE_GET_BY_ID_DETAILS = this.ISSUE_PATH + '/detail/' ;
  private ISSUE_GET_STATUSES = this.ISSUE_PATH + '/statuses';
  private httpOptions = { headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private apiService: ApiService, private http: HttpClient) { }
  
  getAll(page): Observable<any> {
    return this.apiService.get(this.ISSUE_PATH + '/pagination', page).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  getById(id): Observable<any> {
    return this.apiService.get(this.ISSUE_PATH, id).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  createIssue(issue): Observable<any> {
    return this.apiService.post(this.ISSUE_PATH, issue).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  updateIssue(issue): Observable<any> {
    return this.apiService.put(this.ISSUE_PATH + '/' + issue.id, issue).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  delete(id): Observable<any> {
    return this.apiService.delete(this.ISSUE_PATH, id).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  getAllIssueStatuses() {
    return this.apiService.get(this.ISSUE_GET_STATUSES).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  getByIdWithDetails(id: number) {
    return this.apiService.get(this.ISSUE_GET_BY_ID_DETAILS + id).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }

}
