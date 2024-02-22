import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { RechargeService } from '../../service/recharge.service';
import { OperatorResponseDto } from '../../dto/response/operator-response-dto';
import Swal from 'sweetalert2';
import { RechargeResponseDto } from '../../dto/response/recharge-response-dto';
import { MatTableDataSource } from '@angular/material/table';
import { PersonService } from 'src/app/personManagement/service/person.service';
import { PersonResponseDto } from 'src/app/personManagement/dto/response/person-response-dto';
import { CustomValidators } from 'src/app/common/util/custom-validators';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-recharge-list',
  standalone: true,
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './recharge-list.component.html',
  styleUrls: ['./recharge-list.component.css']
})
export class RechargeListComponent  implements OnInit{
  msg = "El campo es obligatorio";
  private rechargeService: RechargeService;
  listRechargeResponseDto: RechargeResponseDto[]=[];

  operator = -1;
  seller = -1;

  private personService: PersonService;

  operatorResponseDto: OperatorResponseDto[] = [];

  listPersonResponseDto: PersonResponseDto[] = [];

  queryFilter: FormGroup;


  constructor(rechargeService: RechargeService,personService: PersonService,private fb: FormBuilder ){
    this.rechargeService = rechargeService;
    this.personService = personService;
    this.queryFilter = this.fb.group({
      operator: ['', [ CustomValidators.spaceValidator]],
      person: ['', [ CustomValidators.spaceValidator]],


    });
  }
  ngOnInit(): void {
    this.listRecharge(this.operator,this.seller);
    this.actualizacionAutomatica();
    this.listPerson();
    this.listOperator();
  }

  listRecharge(operator: number, seller: number) {

    this.rechargeService.listRecharge(operator,seller).subscribe({
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
      this.listRecharge(this.operator,this.seller);

    });
  }


  listPerson() {

    this.personService.listPerson().subscribe({
      next: (data) => {
        this.listPersonResponseDto = data;
        console.log(this.listPersonResponseDto);
      },
      error: (e) => {
        Swal.fire({
          title: "Error",
          icon: "error",
          text: "Error en obtener el listado de operdadores",
          confirmButtonText: "Aceptar",

          showCloseButton: true,
        });
      }
    })

  }

  listOperator() {

    this.rechargeService.listOperator().subscribe({
      next: (data) => {
        this.operatorResponseDto = data;
        console.log(this.operatorResponseDto);
      },
      error: (e) => {
        Swal.fire({
          title: "Error",
          icon: "error",
          text: "Error en obtener el listado de operdadores",
          confirmButtonText: "Aceptar",

          showCloseButton: true,
        });
      }
    })

  }

filter(){
  this.operator = this.queryFilter.get("operator")?.value;
  this.seller = this.queryFilter.get("person")?.value;
  this.listRecharge(this.operator,this.seller);
}
}
