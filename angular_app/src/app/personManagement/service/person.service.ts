import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Constants } from 'src/app/common/util/constants';
import { PersonResponseDto } from '../dto/response/person-response-dto';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private URL: string = Constants.API_URL.URL;
  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }
  listPerson(): Observable<PersonResponseDto[]> {
    return this.httpClient.get<PersonResponseDto[]>(
      `${this.URL}person/list`
    );
  }
}
