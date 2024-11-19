package com.hexaware.quitq.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.service.ISupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController {
	
	@Autowired
	ISupplierService service;
	
	@PostMapping("/addsupplier")
	public Supplier addSupplier(@RequestBody Supplier supplier )
	{
		return service.addSupplier(supplier);
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
	public Supplier updateproduct(@RequestBody Supplier supplier)
	{
		return service.updateSupplier(supplier);
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
