package com.recargaGelsa.management_person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargaGelsa.management_person.dto.response.PersonResponseDto;
import com.recargaGelsa.management_person.service.IPersonService;
 
@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = {"*"})
public class PersonController { 
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping("/list")
	public ResponseEntity<List<PersonResponseDto>> getShiftList() {
		List<PersonResponseDto> response = personService.listPerson();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
