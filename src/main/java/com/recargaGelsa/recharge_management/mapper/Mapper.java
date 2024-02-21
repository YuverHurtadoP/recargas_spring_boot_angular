package com.recargaGelsa.recharge_management.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.recargaGelsa.recharge_management.dto.response.RechargeResponseDto;
import com.recargaGelsa.recharge_management.entity.RechargeEntity;

@Component
public class Mapper {
    
	public List<RechargeResponseDto> convertEntityToDto(List<RechargeEntity> listEntity) {
	    List<RechargeResponseDto> arrayDto = new ArrayList<>();
	    if (listEntity != null) {
	        for (RechargeEntity entity : listEntity) {
	            if (entity.getSeller() != null) {
	                RechargeResponseDto dto = new RechargeResponseDto();
	                dto.setSeller(entity.getSeller().getId());
	                dto.setName(entity.getSeller().getName() + " " + entity.getSeller().getLastname());
	                dto.setOperatorId(entity.getOperator().getId());
	                dto.setDescriptionOperator(entity.getOperator().getDescription());
	                dto.setSaleDate(entity.getSaleDate());
	                dto.setSaleDate(entity.getSaleDate());
	                dto.setPriceRecharge(entity.getPriceRecharge());
	                arrayDto.add(dto);
	            }  
	        }
	        return arrayDto;
	    } else {
	        return null;
	    }
	}

}
