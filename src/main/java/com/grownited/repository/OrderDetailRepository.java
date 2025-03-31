package com.grownited.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.grownited.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{
	@Query(value ="select od.* , p.product_name  from product p  , order_detail od where od.product_id = p.product_id",nativeQuery = true)
	List<Object[]> getAll();

	@Query(value ="select od.* , p.product_name  from product p  , order_detail od where od.product_id = p.product_id and od.order_detail_id=:orderDetailId",nativeQuery = true)
	List<Object[]> getByOrderDetailId(Integer orderDetailId);
}
