package sum25.tinth.homework.service;
import sum25.tinth.homework.pojo.Order;
import sum25.tinth.homework.pojo.OrderDetail;
import sum25.tinth.homework.pojo.Account;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Account account, List<OrderDetail> orderDetails);
    List<Order> getOrdersByAccount(Account account);
    Optional<Order> getOrderById(Long id);
    Order updateOrderStatus(Long orderId, String status);
    List<Order> getAllOrders();
    void cancelOrder(Long orderId);
    List<Order> getOrdersByStatus(String status);
}