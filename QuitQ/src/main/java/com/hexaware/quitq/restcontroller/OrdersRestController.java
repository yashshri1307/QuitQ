/* author : Yadnesh Shewale
 * date : 13/11/2024
 * 
 */
package com.hexaware.quitq.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.dto.OrdersDTO;
import com.hexaware.quitq.entities.Orders;
import com.hexaware.quitq.exception.OrderNotFoundException;
import com.hexaware.quitq.service.IOrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {

    @Autowired
    IOrdersService service;

    Logger logger = LoggerFactory.getLogger(OrdersRestController.class);

    @PostMapping("/addorder")
    public Orders addOrder(@RequestBody Orders ordersDTO) {
        logger.info("Orders Rest Controller executed");

        // Call service to add the order
        return service.addOrder(ordersDTO);
    }

    @GetMapping("/getorder/{id}")
    public Orders getOrderById(@PathVariable Integer id) {
        logger.info("Fetching order with id: " + id);

        Orders order = service.getOrderById(id);
        /*if (order == null) {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
        */
        return order;
    }

   /* @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handleException(OrderNotFoundException ex) {
        return ex.getMessage();
    }
*/
    @GetMapping("/getall")
    public List<Orders> getAllOrders() {
        logger.info("Fetching all orders");
        return service.getAllOrders();
    }

   /* @PutMapping("/updateorder")
    public Orders updateOrder(@RequestBody OrdersDTO ordersDTO) {
        logger.info("Updating order");

        // Call service to update the order
        return service.updateOrder(ordersDTO);
    }
   */ 
    
    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrderById(@PathVariable Integer id) {
        logger.warn("Deleting order with id: " + id);

        // Call service to delete the order by ID
        return service.deleteOrderById(id);
    }

    @GetMapping("/getorderbystatus/{status}")
    public List<Orders> getOrdersByStatus(@PathVariable String status) {
        logger.info("Fetching orders with status: " + status);
        return service.getByStatus(status);
    }

    @GetMapping("/getorderbycustomer/{customerId}")
    public List<Orders> getOrdersByCustomerId(@PathVariable Integer customerId) {
        logger.info("Fetching orders for customer with ID: " + customerId);
        return service.getByCustomerId(customerId);
    }

    @GetMapping("/getorderbyamount/{amount}")
    public List<Orders> getOrdersByTotalAmountGreaterThan(@PathVariable Double amount) {
        logger.info("Fetching orders where total amount is greater than: " + amount);
        return service.getByTotalAmountGreaterThan(amount);
    }

    @GetMapping("/getorderbydaterange/{startDate}/{endDate}")
    public List<Orders> getOrdersByDateRange(@PathVariable String startDate, @PathVariable String endDate) {
        logger.info("Fetching orders from " + startDate + " to " + endDate);
        return service.getOrdersByDateRange(startDate, endDate);
    }

  /*  @PutMapping("/updateorderstatus/{id}/{status}")
    public Orders updateOrderStatus(@PathVariable Integer id, @PathVariable String status) {
        logger.info("Updating order status for order with id: " + id + " to status: " + status);
        return service.updateOrderStatus(id, status);
    }
    */
}
