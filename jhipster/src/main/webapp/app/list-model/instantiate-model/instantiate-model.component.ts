import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl, FormControl } from '@angular/forms';

@Component({
  moduleId: module.id,
  selector: 'jhi-instantiate-model',
  templateUrl: 'instantiate-model.component.html',
  styleUrls: ['instantiate-model.component.scss']
})
export class InstantiateModelComponent implements OnInit {
  instantiateModel!: FormGroup;
  id: number | undefined;
  /*
  titre!:string;
  description!:string;
  emails!:string;
*/
  titre = 'titre';
  description = 'description';
  emails = 'emails';

  constructor(private route: ActivatedRoute, private fb: FormBuilder) {}

  commaSepEmail = (control: AbstractControl): { [key: string]: any } | null => {
    const emails = control.value.split(',').map((e: { trim: () => void }) => e.trim());
    const forbidden = emails.some((email: any) => Validators.email(new FormControl(email)));
    return forbidden ? { emails: { value: control.value } } : null;
  };

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.initForm();
  }

  initForm(): void {
    this.instantiateModel = this.fb.group({
      titre: ['', Validators.required],
      description: ['', Validators.required],
      emails: ['', [Validators.required, this.commaSepEmail]]
    });
  }

  onSubmitForm(): void {
    const form = this.instantiateModel;
    this.titre = form.value['titre'];
    this.description = form.value['description'];
    this.emails = form.value['emails'];
  }
}
