package com.grownited.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.grownited.entity.OrdersEntity;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer>{
	@Query(value ="select o.* ,u.first_name , u.last_name from users u , orders o where o.user_id = u.user_id",nativeQuery = true)
	List<Object[]> getAll();

	@Query(value ="select o.* ,u.first_name , u.last_name from users u , orders o where o.user_id = u.user_id and o.order_id = :orderId",nativeQuery = true)
	List<Object[]> getByOrdersId(Integer orderId);

}
