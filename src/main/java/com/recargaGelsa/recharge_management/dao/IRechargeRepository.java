package com.recargaGelsa.recharge_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recargaGelsa.recharge_management.entity.RechargeEntity;

public interface IRechargeRepository extends JpaRepository<RechargeEntity, Integer>{

}
