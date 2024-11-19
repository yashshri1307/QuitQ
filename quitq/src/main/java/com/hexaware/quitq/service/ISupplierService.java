package com.hexaware.quitq.service;

import java.util.List;

import com.hexaware.quitq.entities.Supplier;

public interface ISupplierService {
	
	public  Supplier addSupplier(Supplier supplier);
	 
	public   Supplier getSupplierById(Integer id);
	    
	public  List<Supplier> getAllSuppliers();
	    
	public   Supplier updateSupplier(Supplier supplier);
	    
	public   String deleteSupplierById(Integer id);
	
	public Supplier getSupplierByEmail(String email);
	    

}
