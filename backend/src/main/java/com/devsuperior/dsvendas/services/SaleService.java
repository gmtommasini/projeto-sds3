package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired  
	private SaleRepository repository;
	
	/*
	 * "workaround" for preventing multiple DB searches 
	 * this issue is caused by the ManyToOne relation between Sales and Sellers
	 * This workaround just work because the number of sellers is not too big
	 * */
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) //no table lock -> only read
	public Page<SaleDTO> findAll( Pageable pageable ){
		sellerRepository.findAll(); //loading list of sellers in memory
		Page<Sale> result = repository.findAll(pageable);
		return result.map( x -> new SaleDTO(x));
	}
	//Page is a strean. No need for stream() nor collect
	

}


