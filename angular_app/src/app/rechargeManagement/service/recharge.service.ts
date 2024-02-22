import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, tap } from 'rxjs';
import { Constants } from 'src/app/common/util/constants';
import { OperatorResponseDto } from '../dto/response/operator-response-dto';
import { RechargeRequestDto } from '../dto/request/recharge-request-dto';
import { RechargeResponseDto } from '../dto/response/recharge-response-dto';
import { StatisticsItem } from '../dto/response/statistics-item';

@Injectable({
  providedIn: 'root'
})
export class RechargeService {
  private URL: string = Constants.API_URL.URL;
  private httpClient: HttpClient;

  public saveSubject = new Subject<boolean>();

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }
  listOperator(): Observable<OperatorResponseDto[]> {
    return this.httpClient.get<OperatorResponseDto[]>(
      `${this.URL}operator/list`
    );
  }

  saveRechange( dto:RechargeRequestDto): Observable<any> {
    return this.httpClient.post<any>(
      `${this.URL}recharge`,dto
    ).pipe(  tap(() => this.saveSubject.next(true)));
  }

  listRecharge(operator: number, seller: number): Observable<RechargeResponseDto[]> {
    return this.httpClient.get<RechargeResponseDto[]>(
      `${this.URL}recharge/list?operator=${operator}&seller=${seller}`
    );
  }

 getStateSave(): Observable<boolean> {
    return this.saveSubject.asObservable();
  }

  getRechargeStatistics(): Observable<StatisticsItem[]> {
    return this.httpClient.get<StatisticsItem[]>(
      `${this.URL}recharge/statistics`
      );
  }
}
