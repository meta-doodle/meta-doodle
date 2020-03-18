import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'workflow-model',
        loadChildren: () => import('./workflow-model/workflow-model.module').then(m => m.MdlWorkflowModelModule)
      },
      {
        path: 'workflow-instance',
        loadChildren: () => import('./workflow-instance/workflow-instance.module').then(m => m.MdlWorkflowInstanceModule)
      },
      {
        path: 'mdl-user',
        loadChildren: () => import('./mdl-user/mdl-user.module').then(m => m.MdlMdlUserModule)
      },
      {
        path: 'step',
        loadChildren: () => import('./step/step.module').then(m => m.MdlStepModule)
      },
      {
        path: 'answer',
        loadChildren: () => import('./answer/answer.module').then(m => m.MdlAnswerModule)
      },
      {
        path: 'step-user-answer-wf-instance',
        loadChildren: () =>
          import('./step-user-answer-wf-instance/step-user-answer-wf-instance.module').then(m => m.MdlStepUserAnswerWfInstanceModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class MdlEntityModule {}
