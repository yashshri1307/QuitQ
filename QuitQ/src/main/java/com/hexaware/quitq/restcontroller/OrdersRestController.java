/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : Orders Rest Controller to handle HTTP requests.
 */

package com.hexaware.quitq.restcontroller;

import com.hexaware.quitq.dto.OrdersDTO;
import com.hexaware.quitq.entities.Orders;
import com.hexaware.quitq.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular app
@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {

    @Autowired
    private IOrdersService service;

    @PostMapping("/add")
    public OrdersDTO addOrder(@RequestBody OrdersDTO ordersDTO) {
    	System.out.print("nonono");
        Orders order = service.addOrder(ordersDTO.toEntity());
        return OrdersDTO.fromEntity(order);
    }

    @GetMapping("/getorder/{id}")
    public OrdersDTO getOrderById(@PathVariable Integer id) {
        Orders order = service.getOrderById(id);
        return OrdersDTO.fromEntity(order);
    }

    @GetMapping("/getall")
    public List<OrdersDTO> getAllOrders() {
        List<Orders> orders = service.getAllOrders();
        return orders.stream().map(OrdersDTO::fromEntity).toList();
    }

    @DeleteMapping("/deleteorder/{id}")
    public String deleteOrderById(@PathVariable Integer id) {
        return service.deleteOrderById(id);
    }

    @GetMapping("/getorderbystatus/{status}")
    public List<OrdersDTO> getOrdersByStatus(@PathVariable String status) {
        List<Orders> orders = service.getOrdersByStatus(status);
        return orders.stream().map(OrdersDTO::fromEntity).toList();
    }
}
