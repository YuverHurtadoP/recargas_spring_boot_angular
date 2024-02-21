package com.recargaGelsa.management_person.dto.response;

import java.util.List;

import com.recargaGelsa.management_person.entity.PersonEntity;
import com.recargaGelsa.recharge_management.entity.RechargeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonResponseDto {

	private int id;

	private String name;

	private String lastname;

	private String dni;

}
