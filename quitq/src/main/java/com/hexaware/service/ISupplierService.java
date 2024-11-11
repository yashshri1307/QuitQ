package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Supplier;

public interface ISupplierService {
	
	 void addSupplier(Supplier supplier);
	 
	    Supplier getSupplierById(int id);
	    
	    List<Supplier> getAllSuppliers();
	    
	    void updateSupplier(Supplier supplier);
	    
	    void deleteSupplier(int id);
	    
}
