import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IStepUserAnswerWfInstance } from 'app/shared/model/step-user-answer-wf-instance.model';

type EntityResponseType = HttpResponse<IStepUserAnswerWfInstance>;
type EntityArrayResponseType = HttpResponse<IStepUserAnswerWfInstance[]>;

@Injectable({ providedIn: 'root' })
export class StepUserAnswerWfInstanceService {
  public resourceUrl = SERVER_API_URL + 'api/step-user-answer-wf-instances';

  constructor(protected http: HttpClient) {}

  create(stepUserAnswerWfInstance: IStepUserAnswerWfInstance): Observable<EntityResponseType> {
    return this.http.post<IStepUserAnswerWfInstance>(this.resourceUrl, stepUserAnswerWfInstance, { observe: 'response' });
  }

  update(stepUserAnswerWfInstance: IStepUserAnswerWfInstance): Observable<EntityResponseType> {
    return this.http.put<IStepUserAnswerWfInstance>(this.resourceUrl, stepUserAnswerWfInstance, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IStepUserAnswerWfInstance>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IStepUserAnswerWfInstance[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
