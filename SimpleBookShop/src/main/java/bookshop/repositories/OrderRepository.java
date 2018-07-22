package bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.enteties.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
