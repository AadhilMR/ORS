package com.kanishka.ors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanishka.ors.entity.FoodItem;
import com.kanishka.ors.repo.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodItem getFoodItem(long id) {
        Optional<FoodItem> foodItemById = foodRepository.findById(id);

        if(foodItemById.isPresent()) {
            return foodItemById.get();
        } else {
            return null;
        }
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }
}
