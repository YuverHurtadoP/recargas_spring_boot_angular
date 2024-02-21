package com.recargaGelsa.recharge_management.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recargaGelsa.common.NotFoundException;
import com.recargaGelsa.management_person.dao.IPersonRepository;
import com.recargaGelsa.management_person.entity.PersonEntity;
import com.recargaGelsa.recharge_management.dao.IOperatorRepository;
import com.recargaGelsa.recharge_management.dao.IRechargeRepository;
import com.recargaGelsa.recharge_management.dto.request.RechargeRequestDto;
import com.recargaGelsa.recharge_management.dto.response.RechargeResponseDto;
import com.recargaGelsa.recharge_management.entity.OperatorEntity;
import com.recargaGelsa.recharge_management.entity.RechargeEntity;
import com.recargaGelsa.recharge_management.mapper.Mapper;
import com.recargaGelsa.recharge_management.service.IRechargeService;
 
@Service
public class RechargeServiceImpl implements IRechargeService{
	@Autowired
	private IPersonRepository personRepository;
	
	@Autowired
	private IOperatorRepository operatorRepository; 
	
	@Autowired
	private IRechargeRepository rechargeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Mapper mapper;

	@Override
	public  void saveRecharge(RechargeRequestDto dto) {
		Optional<PersonEntity> personEntityResponse = personRepository.findById(dto.getSeller());
		Optional<OperatorEntity> operatorEntityResponse =  operatorRepository.findById(dto.getOperator());
		
		
		if (personEntityResponse.isPresent()) {
			if(operatorEntityResponse.isPresent()){
				RechargeEntity objectRecharge =  new RechargeEntity();
				OperatorEntity objectOperator = new OperatorEntity();
				objectOperator.setId(dto.getOperator());
				
				PersonEntity objectPerson = new PersonEntity();
				objectPerson.setId(dto.getSeller());
				objectRecharge.setSeller(objectPerson);
				objectRecharge.setOperator(objectOperator);
				objectRecharge.setSaleDate(LocalDateTime.now());
				objectRecharge.setPriceRecharge(dto.getPrice());
				objectRecharge.setPhoneRecharge(dto.getPhoneRecharge());
				
				RechargeEntity objectRechargeResponse = rechargeRepository.save(objectRecharge);
				
		 	 
			}else {
				throw new  NotFoundException("El operador no existe.");
			}
		
		}else {
			throw new  NotFoundException("El vendedor no se encuentra en la base de datos.");
		}
		
	}
 

	@Override
	public List<RechargeResponseDto> listRecharge() {
		List<RechargeEntity> listRecharge = rechargeRepository.findAll();
		List<RechargeResponseDto> list = mapper.convertEntityToDto(listRecharge);
	 
		return list;
	}

}
