package com.recargaGelsa.recharge_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.recargaGelsa.recharge_management.dto.response.RechargeStatisticsDTO;
import com.recargaGelsa.recharge_management.entity.RechargeEntity;

public interface IRechargeRepository extends JpaRepository<RechargeEntity, Integer>{
	@Query("SELECT r FROM RechargeEntity r WHERE " +
		       "(:operator = -1 OR r.operator.id = :operator) AND " +
		       "(:seller = -1 OR r.seller.id = :seller)")
		List<RechargeEntity> listRecharge(
		        @Param("operator") int operator,
		        @Param("seller") int seller
		);
	
	@Query("SELECT new com.recargaGelsa.recharge_management.dto.response.RechargeStatisticsDTO(o.description, COUNT(r), SUM(r.priceRecharge)) " +
		       "FROM RechargeEntity r " +
		       "JOIN r.operator o " +
		       "GROUP BY o.id, o.description")
		List<RechargeStatisticsDTO> countAndSumByOperator();

}
