import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICurrentStep } from 'app/shared/model/current-step.model';

type EntityResponseType = HttpResponse<ICurrentStep>;
type EntityArrayResponseType = HttpResponse<ICurrentStep[]>;

@Injectable({ providedIn: 'root' })
export class CurrentStepService {
  public resourceUrl = SERVER_API_URL + 'api/current-steps';

  constructor(protected http: HttpClient) {}

  create(currentStep: ICurrentStep): Observable<EntityResponseType> {
    return this.http.post<ICurrentStep>(this.resourceUrl, currentStep, { observe: 'response' });
  }

  update(currentStep: ICurrentStep): Observable<EntityResponseType> {
    return this.http.put<ICurrentStep>(this.resourceUrl, currentStep, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICurrentStep>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICurrentStep[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
