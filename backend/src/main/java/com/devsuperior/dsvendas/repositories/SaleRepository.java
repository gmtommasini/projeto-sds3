package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	//customized method
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount) ) "
			+ "FROM Sale AS obj "
			+ "GROUP BY obj.seller") //jpql
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals) ) "
			+ "FROM Sale AS obj "
			+ "GROUP BY obj.seller") //jpql
	List<SaleSuccessDTO> successGroupedBySeller();
}
