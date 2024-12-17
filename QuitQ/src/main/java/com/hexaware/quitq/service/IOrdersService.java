/* File: ordersService
 * Author: Yadnesh shewale
 * Date Created: 2024-11-12
 * Description: Service Interface  for orders            
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.Orders;
import java.util.List;

public interface IOrdersService {

    Orders addOrder(Orders order);

    Orders getOrderById(int orderId);

    List<Orders> getAllOrders();

    String deleteOrderById(int orderId);

    List<Orders> getOrdersByStatus(String status);
}
