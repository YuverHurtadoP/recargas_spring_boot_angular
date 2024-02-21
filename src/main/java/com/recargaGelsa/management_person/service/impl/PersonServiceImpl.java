package com.recargaGelsa.management_person.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recargaGelsa.management_person.dao.IPersonRepository;
import com.recargaGelsa.management_person.dto.response.PersonResponseDto;
import com.recargaGelsa.management_person.entity.PersonEntity;
import com.recargaGelsa.management_person.service.IPersonService;
 
@Service
public class PersonServiceImpl implements IPersonService{
	@Autowired
	private IPersonRepository personRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PersonResponseDto> listPerson() {
		List<PersonEntity> personList = personRepository.findAll();
		return personList.stream().map(info -> modelMapper.map(info,PersonResponseDto.class))
	            .collect(Collectors.toList());
	}

}
