package com.grownited.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.grownited.entity.ReviewsEntity;

@Repository
public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer> {
	@Query(value ="select r.* , p.product_name , u.first_name , u.last_name from product p , users u , reviews r where r.product_id = p.product_id and r.user_id = u.user_id",nativeQuery = true)
	List<Object[]> getAll();

	@Query(value ="select r.* ,p.product_name , u.first_name , u.last_name from product p , users u , reviews r where r.product_id = p.product_id and r.user_id = u.user_id and r.review_id=:reviewId",nativeQuery = true)
	List<Object[]> getByReviewsId(Integer reviewId);

}
