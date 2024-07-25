package com.iocl.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iocl.entity.ParcelInEntity;
@Repository
public interface ParcelInRepository extends JpaRepository<ParcelInEntity ,Long>{

	ParcelInEntity findByInEntryId(Long inEntryId);

	



}
