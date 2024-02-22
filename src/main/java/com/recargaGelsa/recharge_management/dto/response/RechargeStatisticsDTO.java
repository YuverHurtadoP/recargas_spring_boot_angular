package com.recargaGelsa.recharge_management.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 
public class RechargeStatisticsDTO {
	
	private String description;
    private Long totalCount;
    private BigDecimal totalSum;
    
    public RechargeStatisticsDTO(String description, Long totalCount, BigDecimal totalSum) {
        this.description = description;
        this.totalCount = totalCount;
        this.totalSum = totalSum;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
    
    

}
