import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../interface/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = environment.apiBaseUrl;

//Injecting HttpClient in the constructor with name http
  constructor(private http: HttpClient) { }

    getUsers(): Observable<User[]>{
      return this.http.get<User[]>(`${this.apiUrl}/users`);
    }

    getUser(): Observable<User>{
      return this.http.get<User>('https://jsonplaceholder.typicode.com/users/1');
    }

   }

