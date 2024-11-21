package com.hexaware.quitq.service;

import java.util.List;

import com.hexaware.quitq.dto.SupplierDTO;
import com.hexaware.quitq.entities.Supplier;

public interface ISupplierService {
	
	public  Supplier addSupplier(SupplierDTO supplierDTO);
	 
	public   Supplier getSupplierById(Integer id);
	    
	public  List<Supplier> getAllSuppliers();
	    
	public   Supplier updateSupplier(SupplierDTO supplierDTO);
	    
	public   String deleteSupplierById(Integer id);
	
	public Supplier getSupplierByEmail(String email);
	    

}
