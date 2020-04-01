import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'mdl-user',
        loadChildren: () => import('./mdl-user/mdl-user.module').then(m => m.MdlMdlUserModule)
      },
      {
        path: 'workflow-model',
        loadChildren: () => import('./workflow-model/workflow-model.module').then(m => m.MdlWorkflowModelModule)
      },
      {
        path: 'workflow-instance',
        loadChildren: () => import('./workflow-instance/workflow-instance.module').then(m => m.MdlWorkflowInstanceModule)
      },
      {
        path: 'workflow-instance-state',
        loadChildren: () => import('./workflow-instance-state/workflow-instance-state.module').then(m => m.MdlWorkflowInstanceStateModule)
      },
      {
        path: 'current-step',
        loadChildren: () => import('./current-step/current-step.module').then(m => m.MdlCurrentStepModule)
      },
      {
        path: 'answer',
        loadChildren: () => import('./answer/answer.module').then(m => m.MdlAnswerModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class MdlEntityModule {}
