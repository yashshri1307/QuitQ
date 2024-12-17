/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : Implementation of Orders service interface methods.
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.Orders;
import com.hexaware.quitq.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImp implements IOrdersService {

    @Autowired
    private IOrdersRepository ordersRepo;

    @Override
    public Orders addOrder(Orders order) {
        return ordersRepo.save(order);
    }

    @Override
    public Orders getOrderById(int orderId) {
        return ordersRepo.findById(orderId).orElse(null);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public String deleteOrderById(int orderId) {
        ordersRepo.deleteById(orderId);
        return "Order deleted successfully";
    }

    @Override
    public List<Orders> getOrdersByStatus(String status) {
        return ordersRepo.findByStatus(status);
    }
}
