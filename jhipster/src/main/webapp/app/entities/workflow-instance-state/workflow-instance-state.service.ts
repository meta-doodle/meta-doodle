import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IWorkflowInstanceState } from 'app/shared/model/workflow-instance-state.model';

type EntityResponseType = HttpResponse<IWorkflowInstanceState>;
type EntityArrayResponseType = HttpResponse<IWorkflowInstanceState[]>;

@Injectable({ providedIn: 'root' })
export class WorkflowInstanceStateService {
  public resourceUrl = SERVER_API_URL + 'api/workflow-instance-states';

  constructor(protected http: HttpClient) {}

  create(workflowInstanceState: IWorkflowInstanceState): Observable<EntityResponseType> {
    return this.http.post<IWorkflowInstanceState>(this.resourceUrl, workflowInstanceState, { observe: 'response' });
  }

  update(workflowInstanceState: IWorkflowInstanceState): Observable<EntityResponseType> {
    return this.http.put<IWorkflowInstanceState>(this.resourceUrl, workflowInstanceState, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IWorkflowInstanceState>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IWorkflowInstanceState[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
