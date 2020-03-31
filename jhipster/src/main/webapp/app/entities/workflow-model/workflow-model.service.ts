import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IWorkflowModel } from 'app/shared/model/workflow-model.model';

type EntityResponseType = HttpResponse<IWorkflowModel>;
type EntityArrayResponseType = HttpResponse<IWorkflowModel[]>;

@Injectable({ providedIn: 'root' })
export class WorkflowModelService {
  public resourceUrl = SERVER_API_URL + 'api/workflow-models';

  constructor(protected http: HttpClient) {}

  create(workflowModel: IWorkflowModel): Observable<EntityResponseType> {
    return this.http.post<IWorkflowModel>(this.resourceUrl, workflowModel, { observe: 'response' });
  }

  update(workflowModel: IWorkflowModel): Observable<EntityResponseType> {
    return this.http.put<IWorkflowModel>(this.resourceUrl, workflowModel, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IWorkflowModel>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IWorkflowModel[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
