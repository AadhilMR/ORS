package com.kanishka.ors.service;

import java.util.List;

import com.kanishka.ors.dto.FoodDTO;
import com.kanishka.ors.entity.FoodItem;

public interface FoodService {
    List<FoodItem> getAllFoodItems();
    FoodItem getFoodItem(long id);
    boolean addFoodItem(FoodDTO foodDTO);
}
