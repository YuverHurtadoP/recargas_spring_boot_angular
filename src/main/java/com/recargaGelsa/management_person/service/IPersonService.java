package com.recargaGelsa.management_person.service;

import java.util.List;

import com.recargaGelsa.management_person.dto.response.PersonResponseDto;

public interface IPersonService {
	
	List<PersonResponseDto> listPerson();

}
