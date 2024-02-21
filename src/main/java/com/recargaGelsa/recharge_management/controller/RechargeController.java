package com.recargaGelsa.recharge_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargaGelsa.recharge_management.dto.request.RechargeRequestDto;
import com.recargaGelsa.recharge_management.dto.response.RechargeResponseDto;
import com.recargaGelsa.recharge_management.service.IRechargeService;

import jakarta.validation.Valid;

 
@RestController
@RequestMapping("/api/recharge")
@CrossOrigin(origins = {"*"})
public class RechargeController {
	@Autowired
	private IRechargeService rechargeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<RechargeResponseDto>> getShiftList() {
		List<RechargeResponseDto> response = rechargeService.listRecharge();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createRecharge(@Valid @RequestBody RechargeRequestDto dto) {
		 rechargeService.saveRecharge(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
