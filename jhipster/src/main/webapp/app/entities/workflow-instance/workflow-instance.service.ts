import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import { ISurveyView } from 'app/shared/model/survey-view';
import { PostWorkFlowInstance } from 'app/shared/model/postWorkFlowInstance';

type EntityResponseType = HttpResponse<IWorkflowInstance>;
type EntityArrayResponseType = HttpResponse<IWorkflowInstance[]>;

@Injectable({ providedIn: 'root' })
export class WorkflowInstanceService {
  public resourceUrl = SERVER_API_URL + 'api/workflow-instances';

  constructor(protected http: HttpClient) { }

  create(workflowInstance: IWorkflowInstance): Observable<EntityResponseType> {
    return this.http.post<IWorkflowInstance>(this.resourceUrl, workflowInstance, { observe: 'response' });
  }

  update(workflowInstance: IWorkflowInstance): Observable<EntityResponseType> {
    return this.http.put<IWorkflowInstance>(this.resourceUrl, workflowInstance, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IWorkflowInstance>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IWorkflowInstance[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  view(login: string, idWFI: number): Observable<HttpResponse<ISurveyView>> {
    return this.http.get<ISurveyView>(`${this.resourceUrl}-view/${login}/${idWFI}`, { observe: 'response' });
  }

  createWithGuests(postWorkflowInstance: PostWorkFlowInstance): Observable<EntityResponseType> {
    return this.http.post<IWorkflowInstance>(this.resourceUrl + '/create', postWorkflowInstance, { observe: 'response' })
  }

  findAll(): Observable<EntityResponseType>{
    return this.http.get(`${this.resourceUrl}`, {observe: 'response'});
  }
}
