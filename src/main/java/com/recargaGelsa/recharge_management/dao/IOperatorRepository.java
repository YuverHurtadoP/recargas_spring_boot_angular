package com.recargaGelsa.recharge_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recargaGelsa.recharge_management.entity.OperatorEntity;

public interface IOperatorRepository  extends JpaRepository<OperatorEntity, Integer>{

}
