package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer> {
	@Query(value ="select a.*,c.city_name from city c,area a where a.city_id = c.city_id",nativeQuery = true)
	List<Object[]> getAll();
	
	@Query(value ="select a.*,c.city_name from city c,area a where a.city_id = c.city_id and a.area_id = :areaId",nativeQuery = true)
	List<Object[]> getByAreaId(Integer areaId);
}
