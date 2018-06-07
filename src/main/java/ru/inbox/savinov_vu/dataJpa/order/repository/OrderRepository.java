package ru.inbox.savinov_vu.dataJpa.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.dataJpa.order.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
