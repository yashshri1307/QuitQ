package com.hexaware.quitq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.exception.SupplierAlreadyExistsException;
import com.hexaware.quitq.exception.SupplierNotFoundException;
import com.hexaware.quitq.repository.ISupplierRepository;

@Service
public class SupplierServiceImp implements ISupplierService {

	@Autowired
	ISupplierRepository repo;
	
	@Override
	public Supplier addSupplier(Supplier supplier) {
		
		if((repo.findByEmail(supplier.getEmail())).isPresent())
		{
			throw new SupplierAlreadyExistsException("Supplier with email " + supplier.getEmail() + " already exists.");
		}
			return repo.save(supplier);
	}
	@Override
	public Supplier getSupplierById(Integer id) {
	
		return repo.findById(id).orElseThrow(() -> new SupplierNotFoundException("Supplier with ID " + id + " not found"));
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		
		return repo.findAll();
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
	
		return repo.save(supplier);
	}

	@Override
	public String deleteSupplierById(Integer id) {
		
		if(!(repo.findById(id)).isPresent())
	       {
		     throw new SupplierNotFoundException("Supplier with ID " + id + " not found");
	       }
			repo.deleteById(id);
			
			return "Record Deleted";
		}

	@Override
	public Supplier getSupplierByEmail(String email) {
	
		return repo.findByEmail(email).orElseThrow(() -> new SupplierNotFoundException("Supplier with email " + email + " not found."));
	}
	

}
