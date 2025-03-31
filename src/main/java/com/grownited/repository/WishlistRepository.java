package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grownited.entity.WishListEntity;

@Repository
public interface WishlistRepository extends JpaRepository<WishListEntity, Integer>{

}
