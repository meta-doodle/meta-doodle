import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';
import { Subscription } from 'rxjs';
import { AccountService } from 'app/core/auth/account.service';
import { MdlUser } from 'app/shared/model/mdl-user.model';
import { MdlUserService } from 'app/entities/mdl-user/mdl-user.service';
import { PostWorkFlowInstance } from 'app/shared/model/postWorkFlowInstance';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { WorkflowModelService } from 'app/entities/workflow-model/workflow-model.service';

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
  wf!: any;
  creatorId = -12;
  private mdlUser?: MdlUser | null;

  constructor(
    private mdlUserService: MdlUserService,
    private accountService: AccountService,
    private service: WorkflowInstanceService,
    private wfMdlService: WorkflowModelService,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  commaSepEmail = (control: AbstractControl): { [key: string]: any } | null => {
    const emails = control.value.split(',').map((e: { trim: () => void }) => e.trim());
    const forbidden = emails.some((email: any) => Validators.email(new FormControl(email)));
    return forbidden ? { emails: { value: control.value } } : null;
  };

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.sub = this.wfMdlService.find(this.id).subscribe(value => {
      this.wf = value.body;
    });
    this.getUserId();
    this.initForm();
  }

  getUserId(): void {
    let login = '';
    this.accountService.identity().subscribe(value => {
      login = value ? value.login : '';
    });
    console.log(login);
    this.mdlUserService.findFromLogin(login).subscribe(value => {
      this.mdlUser = value.body;
    });
    if (this.mdlUser != null) {
      this.creatorId = this.mdlUser.id!;
    } else {
      console.log('erreur mdluser null');
    }
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
    this.emails = form.value['emails'];
    this.post.wfModelId = this.id;
    this.post.creatorId = this.creatorId;
    this.post.guests = this.emails;
    this.service.createWithGuests(this.post);
  }
}
