package com.hexaware.quitq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.quitq.entities.Supplier;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,Integer> {

	public Optional<Supplier> findByEmail(String email);
}
