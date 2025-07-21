package sum25.tinth.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.tinth.homework.pojo.Account;
import sum25.tinth.homework.pojo.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByAccountOrderByOrderDateDesc(Account account);
    List<Order> findByOrderStatusOrderByOrderDateDesc(String status);
}
