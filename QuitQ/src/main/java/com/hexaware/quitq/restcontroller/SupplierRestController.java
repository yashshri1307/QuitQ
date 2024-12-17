package com.hexaware.quitq.restcontroller;
/* File: SupplierRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-11-14
 * Description: Supplier Controller will have api mapping for supplier functionality        
                will take Data using SupplierDTO
                and will transfer to service layer
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.dto.SupplierDTO;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.service.ISupplierService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController {
	
	@Autowired
	ISupplierService service;
	
	Logger logger=LoggerFactory.getLogger(SupplierRestController.class);
	
	@PostMapping("/add")
	public Supplier addSupplier(@RequestBody SupplierDTO supplierDTO )
	{
		logger.info("Supplier Rest controller executed");
		
		return service.addSupplier(supplierDTO);
	}
	
	@GetMapping("/supplier/{id}")
	public Supplier getSupplierById(@PathVariable Integer id)
	{
		return service.getSupplierById(id);
	}
	
	@GetMapping("/getall")
	public List<Supplier> getall()
	{
		return service.getAllSuppliers();
	}
	
	@PutMapping("/updatesupplier")
	public Supplier updateproduct(@RequestBody SupplierDTO supplierDTO)
	{
		return service.updateSupplier(supplierDTO);
	}
	
	@DeleteMapping("/deletesupplier/{id}")
	public String deleteSupplierById(@PathVariable Integer id)
	{
		return service.deleteSupplierById(id);
	}
	
	@GetMapping("/getsupplierByEmail/{email}")
	public Supplier getsupplierbyEmail(@PathVariable String email)
	{
		return service.getSupplierByEmail(email);
	}

}
