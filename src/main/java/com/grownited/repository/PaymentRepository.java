package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.PaymentEntity;


public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{

}
