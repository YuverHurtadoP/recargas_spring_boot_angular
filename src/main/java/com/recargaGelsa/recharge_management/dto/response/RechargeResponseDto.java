package com.recargaGelsa.recharge_management.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RechargeResponseDto {
	
	private int operatorId;

	private BigDecimal priceRecharge;

	private int seller;
	
	 private LocalDateTime saleDate;
	
	private String name;
	
	private String descriptionOperator;
	
	private String phoneRecharge;

}
