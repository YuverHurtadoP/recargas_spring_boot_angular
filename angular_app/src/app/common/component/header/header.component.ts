import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatDialog } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { RechargeFormComponent } from 'src/app/rechargeManagement/component/recharge-form/recharge-form.component';
import { StatisticsComponent } from 'src/app/rechargeManagement/component/statistics/statistics.component';
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, MatToolbarModule, MatDialogModule ],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor( public dialog: MatDialog){}

  abrirModalFormulario(): void {

    this.dialog.open(RechargeFormComponent, { width: '500px',  });

}

openStatistics(): void {

  this.dialog.open(StatisticsComponent, { width: '500px',  });

}
}
