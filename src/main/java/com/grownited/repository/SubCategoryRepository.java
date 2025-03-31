package com.grownited.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.grownited.entity.SubCategoryEntity;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Integer>{
	@Query(value ="select sc.*,c.category_name from category c,sub_category sc where sc.category_id = c.category_id",nativeQuery = true)
	List<Object[]> getAll();

	@Query(value ="select sc.*,c.category_name from category c,sub_category sc where sc.category_id = c.category_id and sc.sub_category_id = :subCategoryId",nativeQuery = true)
	List<Object[]> getBySubCategoryId(Integer subCategoryId);
}
