package com.recargaGelsa.management_person.entity;

import java.util.List;

import com.recargaGelsa.recharge_management.entity.OperatorEntity;
import com.recargaGelsa.recharge_management.entity.RechargeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "person")
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String lastname;
	
	private String dni;
	
	 @OneToMany(mappedBy = "seller")
	private List<RechargeEntity>recharge;

}
