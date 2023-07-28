package com.shoedeck.project.repository;

import com.shoedeck.project.model.ShoeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoeInfoRepository extends JpaRepository<ShoeInfo,Long> {
    @Query(value = "select * from shoeinfo s where is_for_home = 'Y'",nativeQuery = true)
    List<ShoeInfo> getHomeShoeInfo();
}
