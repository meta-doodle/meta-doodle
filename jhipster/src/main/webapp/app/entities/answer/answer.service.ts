import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IAnswer } from 'app/shared/model/answer.model';
import { ISurveyView } from 'app/shared/model/survey-view';

type EntityResponseType = HttpResponse<IAnswer>;
type EntityArrayResponseType = HttpResponse<IAnswer[]>;

@Injectable({ providedIn: 'root' })
export class AnswerService {
  public resourceUrl = SERVER_API_URL + 'api/answers';
  public sendAnswerUrl = SERVER_API_URL + 'api/send-answer'

  constructor(protected http: HttpClient) { }

  create(answer: IAnswer): Observable<EntityResponseType> {
    return this.http.post<IAnswer>(this.resourceUrl, answer, { observe: 'response' });
  }

  update(answer: IAnswer): Observable<EntityResponseType> {
    return this.http.put<IAnswer>(this.resourceUrl, answer, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IAnswer>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IAnswer[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  send(answer: IAnswer): Observable<HttpResponse<ISurveyView>> {
    return this.http.post<ISurveyView>(this.sendAnswerUrl, answer, { observe: 'response' });
  }

 
}
