package com.hexaware.quitq.service;
/* File: SupplierServiceImp
 * Author: Yash Shrivastava
 * Date Created: 2024-11-12
 * Description: Service Implementation for serviceInterface for supplier          
                Will Contain business logic and 
                will take Data using SupplierDTO
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.dto.SupplierDTO;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.entities.UserInfo;
import com.hexaware.quitq.exception.SupplierAlreadyExistsException;
import com.hexaware.quitq.exception.SupplierNotFoundException;
import com.hexaware.quitq.repository.ISupplierRepository;
import com.hexaware.quitq.repository.UserInfoRepository;

@Service
public class SupplierServiceImp implements ISupplierService {

	@Autowired
	ISupplierRepository repo;
	
	@Autowired
	UserInfoRepository userrepo;
	
	@Autowired
	PasswordEncoder passwordencoder;
	
	Logger logger=LoggerFactory.getLogger(SupplierServiceImp.class);
	
	@Override
	public Supplier addSupplier(SupplierDTO supplierDTO) {
		
		Supplier supplier=new Supplier();
		
		if((repo.findByEmail(supplierDTO.getEmail())).isPresent())
		{
			logger.warn("Already Exists");
			
			throw new SupplierAlreadyExistsException("Supplier with email already exists.");
		}
		
		logger.info(supplierDTO + " is Added from Add Service");
		
		supplier.setName(supplierDTO.getName());
		supplier.setEmail(supplierDTO.getEmail());
		supplier.setPassword(passwordencoder.encode(supplierDTO.getPassword()));
		supplier.setMobileNumber(supplierDTO.getMobileNumber());
		supplier.setCompanyName(supplierDTO.getCompanyName());
		supplier.setAddress(supplierDTO.getAddress());
		
		Supplier added=repo.save(supplier);
		
		UserInfo userinfo =new UserInfo();
		
		userinfo.setId(added.getSupplierId());
		userinfo.setName(added.getName());
		userinfo.setEmail(added.getEmail());
		userinfo.setPassword(added.getPassword());
		userinfo.setRoles("SUPPLIER");
		
		userrepo.save(userinfo);
		
		return added;
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
	public Supplier updateSupplier(SupplierDTO supplierDTO) {
	
		Supplier supplier=new Supplier();
		
		if(!(repo.findByEmail(supplierDTO.getEmail())).isPresent())
		{
			logger.warn("Supplier Not Found");
			
			throw new SupplierNotFoundException("Supplier with email " + supplierDTO.getEmail() + " Not Found.");
		}
		
		logger.info(supplierDTO + " is Added from Add Service");
		
		supplier.setSupplierId(supplierDTO.getSupplierId());
		supplier.setName(supplierDTO.getName());
		supplier.setEmail(supplierDTO.getEmail());
		supplier.setPassword(supplierDTO.getPassword());
		supplier.setMobileNumber(supplierDTO.getMobileNumber());
		supplier.setCompanyName(supplierDTO.getCompanyName());
		supplier.setAddress(supplierDTO.getAddress());
		
		return repo.save(supplier);
	}

	@Override
	public String deleteSupplierById(Integer id) {
		
		if(!(repo.findById(id)).isPresent())
	       {
			 logger.warn("Supplier Not Found");
			 
		     throw new SupplierNotFoundException("Supplier with ID " + id + " not found");
	       }
			repo.deleteById(id);
			
			logger.info(" is Added from Add Service");
			
			return "Record Deleted";
		}

	@Override
	public Supplier getSupplierByEmail(String email) {
	
		return repo.findByEmail(email).orElseThrow(() -> new SupplierNotFoundException("Supplier with email " + email + " not found."));
	}
	
	@Override
	public String getUserRole(String username) {		
		UserInfo user = userrepo.findByEmail(username)
	            .orElseThrow(() -> new SupplierNotFoundException("Supplier not found: " + username));
	    return user.getRoles(); 
	}
	

}
