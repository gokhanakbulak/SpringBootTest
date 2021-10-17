package com.mavidevtest.project.repository;

import com.mavidevtest.project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value="select * from address e where e.city like %:keyword% ",nativeQuery = true)
    List<Address> findByKeyword(@Param("keyword") String keyword);

}
