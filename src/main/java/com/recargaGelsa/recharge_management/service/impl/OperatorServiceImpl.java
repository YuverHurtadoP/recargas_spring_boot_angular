package com.recargaGelsa.recharge_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recargaGelsa.recharge_management.dao.IOperatorRepository;
import com.recargaGelsa.recharge_management.dto.response.OperatorResponseDto;
import com.recargaGelsa.recharge_management.entity.OperatorEntity;
import com.recargaGelsa.recharge_management.service.IOperatorService;

@Service
public class OperatorServiceImpl implements IOperatorService  {
	@Autowired
	private IOperatorRepository operatorRepository;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<OperatorResponseDto> listOperator() {
		List<OperatorEntity> listOperator =  operatorRepository.findAll();
		return listOperator.stream().map(info -> modelMapper.map(info,OperatorResponseDto.class))
	            .collect(Collectors.toList());
	} 

}
