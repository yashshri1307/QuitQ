/* author : Yadnesh Shewale
 * date : 09/11/2024
 * 
 */

package com.hexaware.quitq.service;


import com.hexaware.quitq.entities.Orders;
import java.math.BigDecimal;
import java.util.List;

public interface IOrdersService {

    // Create a new order
    public Orders addOrder(Orders order);

    // Update an existing order
    public Orders updateOrder(Orders order);

    // Get order by ID
    public Orders getOrderById(int orderId);

    // Get all orders
    public List<Orders> getAllOrders();

    // Get orders by customer ID
    public List<Orders> getOrdersByCustomerId(int customerId);

    // Get orders by status (e.g., "pending", "shipped", etc.)
    public List<Orders> getOrdersByStatus(String status);

    // Get orders within a date range
    public List<Orders> getOrdersByDateRange(String startDate, String endDate);

    // Get total amount for an order
    public BigDecimal getOrderTotalAmount(int orderId);

    // Delete order by ID
    public String deleteOrderById(int orderId);

    // Delete orders by customer ID
    public String deleteOrdersByCustomerId(int customerId);

    // Delete orders by status
    public String deleteOrdersByStatus(String status);

    // Delete orders by date range
    public String deleteOrdersByDateRange(String startDate, String endDate);

  /*  // Update the status of an order
   public Orders updateOrderStatus(int orderId, String status);
  */
    
	List<Orders> getByTotalAmountGreaterThan(Double amount);

	List<Orders> getByCustomerId(int customerId);

	List<Orders> getByStatus(String status);
}
