/* author : Yadnesh Shewale
 * date : 11/11/2024
 * 
 */


package com.hexaware.quitq.repository;

import com.hexaware.quitq.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByStatus(String status);

    List<Orders> findByCustomerId(int customerId);

    List<Orders> findByTotalAmountGreaterThan(BigDecimal bigDecimal);

    Optional<Orders> findById(int orderId);

    void deleteById(int orderId);
        
    List<Orders> findByOrderDateBetween(LocalDate start, LocalDate end);
   
}
