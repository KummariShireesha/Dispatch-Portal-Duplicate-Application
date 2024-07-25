package com.iocl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iocl.entity.ParcelOutEntity;

@Repository
public interface ParcelOutRepository  extends JpaRepository<ParcelOutEntity,String>{

	List<ParcelOutEntity> findAllByOrderByTrackingIdDesc();

	ParcelOutEntity findByTrackingId(String trackingId);


}
