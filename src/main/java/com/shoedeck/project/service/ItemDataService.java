package com.shoedeck.project.service;

import com.shoedeck.project.dto.ShoeInfoDTO;
import com.shoedeck.project.model.ShoeInfo;
import com.shoedeck.project.repository.ShoeInfoRepository;
import com.shoedeck.project.util.JPAUtilDetach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemDataService {
    @Autowired
    ShoeInfoRepository shoeInfoRepository;
    @Autowired
    JPAUtilDetach jpaUtilDetach;

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
            shoeInfo.setForHome(shoeInfoDTO.getIsHome());
            shoeInfoRepository.save(shoeInfo);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ShoeInfoDTO> fetchHomePageShoes() throws Exception {
        try {
            List<ShoeInfo> shoeInfoList = shoeInfoRepository.getHomeShoeInfo();

            for(ShoeInfo shoe: shoeInfoList){
                jpaUtilDetach.detachEntity(shoe);
            }

            List<ShoeInfoDTO> shoeInfoDTOList = new ArrayList<>();

            for(ShoeInfo shoe: shoeInfoList){
                ShoeInfoDTO shoeInfoDTO = new ShoeInfoDTO();
                shoeInfoDTO.setBrandName(shoe.getBrandName());
                shoeInfoDTO.setShoeColor(shoe.getShoeColor());
                shoeInfoDTO.setShoeType(shoe.getShoeType());
                shoeInfoDTO.setPrice(shoe.getPrice());
                shoeInfoDTO.setRating(shoe.getRating());
                shoeInfoDTO.setImageUrl(shoe.getImageUrl());
                shoeInfoDTO.setIsHome(shoe.getForHome());
                shoeInfoDTOList.add(shoeInfoDTO);
            }

            return shoeInfoDTOList;
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}
