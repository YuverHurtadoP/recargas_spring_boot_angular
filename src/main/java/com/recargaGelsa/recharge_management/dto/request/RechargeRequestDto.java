package com.recargaGelsa.recharge_management.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RechargeRequestDto {
	
	@NotNull(message = "El operator no puede estar en blanco")
	private int operator;

	@NotNull(message = "EL valor de la recarga no puede estar en blanco")
	private BigDecimal price;
	
	@NotNull(message = "El seller no puede estar en blanco")
	private int seller;
	
	@NotNull(message = "El celular no puede estar en blanco")
	private String phoneRecharge;

}
