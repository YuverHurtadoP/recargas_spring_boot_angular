import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RechargeService } from '../../service/recharge.service';
import Swal from 'sweetalert2';
import { StatisticsItem } from '../../dto/response/statistics-item';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-statistics',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})

export class StatisticsComponent implements OnInit{

  private rechargeService: RechargeService;
  statisticsList: StatisticsItem[] = []; // Utiliza la clase

  constructor(rechargeService: RechargeService){
    this.rechargeService = rechargeService;
  }
  ngOnInit(): void {

    this.statistics()
    console.log("yo"+this.statisticsList)

  }
  statistics() {

    this.rechargeService.getRechargeStatistics().subscribe({
      next: (data) => {
        this.statisticsList = data;
        console.log(this.statisticsList);
      },
      error: (e) => {
        Swal.fire({
          title: "Error",
          icon: "error",
          text: "Error en obtener las estadisticas",
          confirmButtonText: "Aceptar",

          showCloseButton: true,
        });
      }
    })

  }
}
