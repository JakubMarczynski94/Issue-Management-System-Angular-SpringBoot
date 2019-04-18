
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import {map} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  PROJECT_PATH = '/project';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private apiService: ApiService, private http: HttpClient) { }
  
  getAllPageable( page ) : Observable<any>{
    return this.apiService.get(this.PROJECT_PATH + '/pagination', page).pipe(map(
      res =>{
        console.log(res)
        if(res){
          return res;
        } else {
          return {};
        }
      }
    ));
  }

  getAll() : Observable<any>{
    return this.apiService.get(this.PROJECT_PATH).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          return {};
        }
      }
    ));
  }

  getById(id) : Observable<any>{
    return this.apiService.get(this.PROJECT_PATH,id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  createProject(project) : Observable<any>{
    return this.apiService.post(this.PROJECT_PATH,project).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
  }

  delete(id) : Observable<any>{
    return this.apiService.delete(this.PROJECT_PATH +'/'+id).pipe(map(
      res =>{
        if(res){
          return res;
        }else{
          console.log(res);
          return {};
        }
      }
    ));
}

}
