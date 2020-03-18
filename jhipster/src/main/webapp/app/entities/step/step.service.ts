import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IStep } from 'app/shared/model/step.model';

type EntityResponseType = HttpResponse<IStep>;
type EntityArrayResponseType = HttpResponse<IStep[]>;

@Injectable({ providedIn: 'root' })
export class StepService {
  public resourceUrl = SERVER_API_URL + 'api/steps';

  constructor(protected http: HttpClient) {}

  create(step: IStep): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(step);
    return this.http
      .post<IStep>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(step: IStep): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(step);
    return this.http
      .put<IStep>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IStep>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IStep[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(step: IStep): IStep {
    const copy: IStep = Object.assign({}, step, {
      deadline: step.deadline && step.deadline.isValid() ? step.deadline.format(DATE_FORMAT) : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.deadline = res.body.deadline ? moment(res.body.deadline) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((step: IStep) => {
        step.deadline = step.deadline ? moment(step.deadline) : undefined;
      });
    }
    return res;
  }
}
