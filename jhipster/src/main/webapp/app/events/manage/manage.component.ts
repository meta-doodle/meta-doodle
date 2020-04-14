import { Component, OnInit } from '@angular/core';
import { WorkflowInstanceService } from 'app/entities/workflow-instance/workflow-instance.service';
import { from } from 'rxjs';
import { ISurveyView } from 'app/shared/model/survey-view';


@Component({
  selector: 'jhi-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {

  //dataUser: ISurveyView | null = null;
  data = [
    {
      status: 'accepted',
      title: "Rétablir l'équilibre dans la Force",
      desc: 'Temps il est, jeune Padawan.',
      owner: 'user'
    },
    {
      status: 'accepted',
      title: 'Question pour un Champion',
      desc: 'Ah oui oui oui !',
      owner: 'admin'
    },
    {
      status: 'invited',
      title: 'Cueillette de champignons',
      desc: "Le saviez-tu, les champignons c'est vachement bon, viendez les jeunes, on va se régaler",
      owner: 'user'
    }
  ];

  //idW= 1;
  //user= "user";



  constructor(private userWorkflowService: WorkflowInstanceService) {}

  ngOnInit(): void {
    //this.userWorkflowService.view(this.user,this.idW).subscribe((res) =>{
     // this.data = res.body;
    //  console.log(this.data);
  //});

  }
}
