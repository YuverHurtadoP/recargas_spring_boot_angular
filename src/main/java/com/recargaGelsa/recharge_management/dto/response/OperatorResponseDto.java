package com.recargaGelsa.recharge_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatorResponseDto {
	private int id;
	 
	private String description;
}
