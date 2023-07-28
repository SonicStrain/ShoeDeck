package com.shoedeck.project.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShoeInfoDTO implements Serializable {
    private String brandName;
    private String shoeColor;
    private String shoeType;
    private String rating;
    private String price;
    private String imageUrl;
    private String isHome;
}
