package com.recargaGelsa.recharge_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargaGelsa.recharge_management.dto.response.OperatorResponseDto;
import com.recargaGelsa.recharge_management.service.IOperatorService;

@RestController
@RequestMapping("/api/operator")
@CrossOrigin(origins = {"*"})
public class OperatorController {
	
	@Autowired
	private IOperatorService opt;
	
	@GetMapping("/list")
	public ResponseEntity<List<OperatorResponseDto>> getShiftList() {
		List<OperatorResponseDto> response = opt.listOperator();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
