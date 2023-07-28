package com.shoedeck.project.controller;

import com.shoedeck.project.dto.ShoeInfoDTO;
import com.shoedeck.project.service.ItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemDataController {

    @Autowired
    ItemDataService itemDataService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @RequestMapping(value = "/addShoeInfo", method = RequestMethod.POST)
    public ResponseEntity<?> addShoeInfoController(
            @RequestBody ShoeInfoDTO shoeInfoDTO
            ){
        try {
            itemDataService.addShoeInfo(shoeInfoDTO);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping(value = "/homeShoes", method = RequestMethod.GET)
    public ResponseEntity<?> fetchShoeData(){
        try {
            List<ShoeInfoDTO> responseData = itemDataService.fetchHomePageShoes();
            return new ResponseEntity<>(responseData,HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
