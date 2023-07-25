package com.shoedeck.project.service;

import com.shoedeck.project.dto.ShoeInfoDTO;
import com.shoedeck.project.model.ShoeInfo;
import com.shoedeck.project.repository.ShoeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDataService {
    @Autowired
    ShoeInfoRepository shoeInfoRepository;

    public void addShoeInfo(ShoeInfoDTO shoeInfoDTO){
        try {
            ShoeInfo shoeInfo = new ShoeInfo();
            shoeInfo.setBrandName(shoeInfoDTO.getBrandName());
            shoeInfo.setShoeColor(shoeInfoDTO.getShoeColor());
            shoeInfo.setShoeType(shoeInfoDTO.getShoeType());
            shoeInfo.setRating(shoeInfoDTO.getRating());
            shoeInfo.setPrice(shoeInfoDTO.getPrice());
            shoeInfo.setRating(shoeInfoDTO.getRating());
            shoeInfo.setImageUrl(shoeInfoDTO.getImageUrl());
            shoeInfoRepository.save(shoeInfo);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
