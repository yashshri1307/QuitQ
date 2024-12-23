/* author : Yadnesh Shewale
 * date : 11/11/2024
 * 
 */

package com.hexaware.quitq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hexaware.quitq.entities.Admin;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findByRole(String role);  // Find admins by their role

    Optional<Admin> findByEmail(String email);  // Find admin by email
    
        void deleteByEmail(String email);    

    
    
    // Delete admin by email
}




/* author : Yadnesh Shewale
 * date : 09/11/2024
 */

//package com.hexaware.quitq.repository;
//
//import com.hexaware.quitq.entities.Admin;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface IAdminRepository extends JpaRepository<Admin, Integer> {
//
//    Optional<Admin> findByEmail(String email);
//
//    @Query("DELETE FROM Admin a WHERE a.email = ?1")
//    int deleteByEmail(String email);
//
//    List<Admin> findByRole(String role);
//
//}
