/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : Orders service interface defining CRUD operations.
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
