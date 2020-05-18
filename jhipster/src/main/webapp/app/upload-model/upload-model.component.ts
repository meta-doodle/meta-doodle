import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AccountService } from 'app/core/auth/account.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';
import {WorkflowModel} from 'app/shared/model/workflow-model.model';

@Component({
  selector: 'jhi-upload-model',
  templateUrl: './upload-model.component.html',
  styleUrls: ['./upload-model.component.scss']
})
export class UploadModelComponent implements OnInit {

  uploadModel!: FormGroup;
  post!: WorkflowModel;

  titre!:string;
  description!:string;
  body!:string;

  creatorId = -1;
  mdlUser?: IMdlUser;

  constructor(
private accountService: AccountService,
private wfMdlService: WorkflowModelService,
private route: ActivatedRoute,
private router: Router,
private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getUserId();
    this.initForm();
  }

  getUserId(): void {
    const tmpMdl = this.accountService.getMdlUser();
    this.mdlUser = tmpMdl != null ? tmpMdl : undefined;
    this.creatorId = (this.mdlUser && this.mdlUser.id != null) ? this.mdlUser.id : -1;
  }

  initForm(): void {
    this.uploadModel = this.fb.group({
      titre: ['', Validators.required],
      description: ['', Validators.required],
      body: ['', Validators.required]
    });
  }

  onSubmitForm(): void {
    const form = this.uploadModel;
    this.titre = form.value['titre'];
    this.description = form.value['description'];
    this.body = form.get(['body'])!.value;

    this.post =   {
      title: this.titre,
      description: this.description,
      body: this.body,
      creatorId: this.creatorId
    };

    this.wfMdlService.create(this.post).subscribe(
      (success) => {
        this.router.navigate(['/list-model']);
      },(error) => {
        this.router.navigate(['/404']);
      });
  }


}
