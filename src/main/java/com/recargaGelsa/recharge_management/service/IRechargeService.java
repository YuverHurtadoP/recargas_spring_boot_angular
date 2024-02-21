package com.recargaGelsa.recharge_management.service;

import java.util.List;

import com.recargaGelsa.recharge_management.dto.request.RechargeRequestDto;
import com.recargaGelsa.recharge_management.dto.response.RechargeResponseDto;

public interface IRechargeService {
	
	public void saveRecharge(RechargeRequestDto dto);
	
	public List<RechargeResponseDto> listRecharge();

}
