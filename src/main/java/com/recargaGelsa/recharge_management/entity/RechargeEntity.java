package com.recargaGelsa.recharge_management.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.recargaGelsa.management_person.entity.PersonEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recharge")
public class RechargeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    private OperatorEntity operator;
	
    private BigDecimal priceRecharge; 
    
    private LocalDateTime saleDate;
    
    private String phoneRecharge;
    
    @ManyToOne
    private PersonEntity seller;


}
