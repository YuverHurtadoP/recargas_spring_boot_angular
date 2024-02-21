import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { OperatorResponseDto } from '../../dto/response/operator-response-dto';
import { RechargeService } from '../../service/recharge.service';
import { PersonService } from 'src/app/personManagement/service/person.service';
import { PersonResponseDto } from 'src/app/personManagement/dto/response/person-response-dto';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { CustomValidators } from 'src/app/common/util/custom-validators';
import { RechargeRequestDto } from '../../dto/request/recharge-request-dto';
@Component({
  selector: 'app-recharge-form',
  standalone: true,
  imports: [CommonModule, FormsModule, MatIconModule, ReactiveFormsModule, MatDialogModule],
  templateUrl: './recharge-form.component.html',
  styleUrls: ['./recharge-form.component.css']
})
export class RechargeFormComponent implements OnInit {
  msg = "El campo es requerido";
  msg2 = "Solo numero";
  private rechargeService: RechargeService;

  private personService: PersonService;

  operatorResponseDto: OperatorResponseDto[] = [];

  listPersonResponseDto: PersonResponseDto[] = [];

  formRegister: FormGroup;

  objectRequest:RechargeRequestDto = new RechargeRequestDto;

  constructor(public dialogRef: MatDialogRef<RechargeFormComponent>,rechargeService: RechargeService, personService: PersonService,  private fb: FormBuilder) {
    this.rechargeService = rechargeService;
    this.personService = personService;

    this.formRegister = this.fb.group({
      operator: ['', [ CustomValidators.spaceValidator]],
      person: ['', [ CustomValidators.spaceValidator]],
      price: ['',  [ CustomValidators.spaceValidator,Validators.pattern('^[0-9]+$')]],
      phone: ['',  [ CustomValidators.spaceValidator,Validators.pattern('^[0-9]+$')]],

    });
  }
  ngOnInit(): void {
    this.listOperator();
    this.listPerson();

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

  save(){
    this.objectRequest.operator = this.formRegister.get("operator")?.value;
    this.objectRequest.seller =  this.formRegister.get("person")?.value;
    this.objectRequest.price =  this.formRegister.get("price")?.value;
    this.objectRequest.phoneRecharge =  this.formRegister.get("phone")?.value;
    if (this.formRegister.valid){
      this.rechargeService.saveRechange(this.objectRequest).subscribe({
        next:()=>{
          this.dialogRef.close();
          Swal.fire(
            '¡Registrado!',
            'La recarga se realizó con éxito.',
            'success'
          );
        },
        error:(e)=>{

          Swal.fire({
            title: "Error",
            icon: "error",
            text: e.error.mensaje,
            confirmButtonText: "Aceptar",

            showCloseButton: true,
          });
        }
      })
    }else{
      this.markFieldsAsTouched(this.formRegister);
    }


  }

  private markFieldsAsTouched(formGroup: FormGroup) {
    Object.values(formGroup.controls).forEach(control => {
      if (control instanceof FormGroup) {
        this.markFieldsAsTouched(control);
      } else {
        control.markAsTouched();
      }
    });
  }

}
