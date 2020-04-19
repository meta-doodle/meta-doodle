import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';
import { Subscription } from 'rxjs';
import { AccountService } from 'app/core/auth/account.service';
import { IMdlUser } from 'app/shared/model/mdl-user.model';
import { PostWorkFlowInstance } from 'app/shared/model/postWorkFlowInstance';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';
import { IWorkflowModel } from 'app/shared/model/workflow-model.model';

@Component({
  moduleId: module.id,
  selector: 'jhi-instantiate-model',
  templateUrl: 'instantiate-model.component.html',
  styleUrls: ['instantiate-model.component.scss']
})
export class InstantiateModelComponent implements OnInit {

  instantiateModel!: FormGroup;
  id!: number;
  sub!: Subscription;

  post!: PostWorkFlowInstance;
  // titre!:string;
  // description!:string;
  emails!: string[];
  wf!: IWorkflowModel | null;
  creatorId = -1;
  mdlUser?: IMdlUser;

  constructor(
//  private mdlUserService: MdlUserService,
private accountService: AccountService,
private service: WorkflowInstanceService,
private wfMdlService: WorkflowModelService,
private route: ActivatedRoute,
private router: Router,
private fb: FormBuilder
  ) {}

  commaSepEmail = (control: AbstractControl): { [key: string]: any } | null => {
    const emails = control.value.split(',').map((e: { trim: () => void }) => e.trim());
    const forbidden = emails.some((email: any) => Validators.email(new FormControl(email)));
    return forbidden ? { emails: { value: control.value } } : null;
  };

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.wf = {};
    this.sub = this.wfMdlService.find(this.id).subscribe(value => {
      this.wf = (value.body && value.body != null) ? value.body : null;
    });
    this.getUserId();
    this.initForm();
  }

  getUserId(): void {
    const tmpMdl = this.accountService.getMdlUser();
    this.mdlUser = tmpMdl != null ? tmpMdl : undefined;
    this.creatorId = (this.mdlUser && this.mdlUser.id != null) ? this.mdlUser.id : -1;
  }

  initForm(): void {
    this.instantiateModel = this.fb.group({
      // titre: ['', Validators.required],
      // description: ['', Validators.required],
      emails: ['', [Validators.required, this.commaSepEmail]]
    });
  }

  onSubmitForm(): void {
    const form = this.instantiateModel;
    //  this.titre = form.value['titre'];
    //  this.description = form.value['description'];
    this.emails = form.value['emails'].split(',').map((e: { trim: () => void }) => e.trim());;
    this.post =   {
      wfModelId: this.id,
      creatorId: this.creatorId,
      guests: this.emails
    };
    this.service.createWithGuests(this.post).subscribe(
      (success) => {
        this.router.navigate['/events/manage'];
      },(error) => {

      }
    );
  }
}
