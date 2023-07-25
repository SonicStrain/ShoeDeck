package com.shoedeck.project.repository;

import com.shoedeck.project.model.ShoeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeInfoRepository extends JpaRepository<ShoeInfo,Long> {
}
