import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { IWorkflowInstance } from 'app/shared/model/workflow-instance.model';
import {IUser} from "../../core/user/user.model";

type EntityResponseType = HttpResponse<IMdlUser>;
type EntityArrayResponseType = HttpResponse<IMdlUser[]>;

@Injectable({ providedIn: 'root' })
export class MdlUserService {
  public resourceUrl = SERVER_API_URL + 'api/mdl-users';

  constructor(protected http: HttpClient) {}

  create(mdlUser: IMdlUser): Observable<EntityResponseType> {
    return this.http.post<IMdlUser>(this.resourceUrl, mdlUser, { observe: 'response' });
  }

  update(mdlUser: IMdlUser): Observable<EntityResponseType> {
    return this.http.put<IMdlUser>(this.resourceUrl, mdlUser, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IMdlUser>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IMdlUser[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  findFromLogin(login: string): Observable<EntityResponseType> {
    return this.http.get<IMdlUser>(`${this.resourceUrl}/convert/${login}`, { observe: 'response' })
  }

  createFromLogin(login: string): Observable<EntityResponseType> {
    return this.http.post<IMdlUser>(`${this.resourceUrl}/convert`, login, { observe: 'response' })
  }

  findUserWorkflows(id: number): Observable<EntityResponseType> {
    return this.http.get<IWorkflowInstance>(`${this.resourceUrl}/${id}/workflows`, { observe: 'response' })
  }

  findWorkflows(id: number): Observable<EntityArrayResponseType> {
    return this.http.get<IWorkflowInstance[]>(`${this.resourceUrl}/${id}/workflows`, { observe: 'response' })
  }

  findJUser(id: number): Observable<EntityResponseType>{
    return this.http.get<IUser>(`${this.resourceUrl}/${id}/get-user`, { observe: 'response' })
  }
}
