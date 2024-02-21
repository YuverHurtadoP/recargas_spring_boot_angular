import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { RechargeService } from '../../service/recharge.service';
import { OperatorResponseDto } from '../../dto/response/operator-response-dto';
import Swal from 'sweetalert2';
import { RechargeResponseDto } from '../../dto/response/recharge-response-dto';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-recharge-list',
  standalone: true,
  imports: [CommonModule,],
  templateUrl: './recharge-list.component.html',
  styleUrls: ['./recharge-list.component.css']
})
export class RechargeListComponent  implements OnInit{
  private rechargeService: RechargeService;
  listRechargeResponseDto: RechargeResponseDto[]=[];


  constructor(rechargeService: RechargeService,){
    this.rechargeService = rechargeService;
  }
  ngOnInit(): void {
    this.listRecharge();
    this.actualizacionAutomatica();
  }

  listRecharge() {

    this.rechargeService.listRecharge().subscribe({
      next: (data) => {
        this.listRechargeResponseDto = data;
        console.log(this.listRechargeResponseDto);
      },
      error: (e) => {
        Swal.fire({
          title: "Error",
          icon: "error",
          text: "Error en obtener el listado de recargas",
          confirmButtonText: "Aceptar",

          showCloseButton: true,
        });
      }
    })

  }

  actualizacionAutomatica(){
    this.rechargeService.getStateSave().subscribe((estado) => {
      this.listRecharge();

    });
  }



}
