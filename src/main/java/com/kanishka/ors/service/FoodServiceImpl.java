package com.kanishka.ors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanishka.ors.dto.FoodDTO;
import com.kanishka.ors.entity.FoodItem;
import com.kanishka.ors.entity.FoodStatus;
import com.kanishka.ors.entity.Image;
import com.kanishka.ors.repo.FoodRepository;
import com.kanishka.ors.repo.ImageRepository;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private final FoodRepository foodRepository;
    @Autowired
    private final ImageRepository imageRepository;

    public FoodServiceImpl(FoodRepository foodRepository, ImageRepository imageRepository) {
        this.foodRepository = foodRepository;
        this.imageRepository = imageRepository;
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

    @Override
    public boolean addFoodItem(FoodDTO foodDTO) {
        try {
            FoodStatus status = FoodStatus.valueOf(foodDTO.getAvailability());
            Image image = addFoodItemImage(foodDTO.getImagePath());

            FoodItem foodItem = new FoodItem();
            foodItem.setName(foodDTO.getName());
            foodItem.setPrice(foodDTO.getPrice());
            foodItem.setImage(image);
            foodItem.setStatus(status);

            return foodRepository.save(foodItem) != null;
        } catch (IllegalArgumentException ignored) {

        }
        return false;
    }

    private Image addFoodItemImage(String path) {
        Image image = new Image();
        image.setPath(path);

        return imageRepository.save(image);
    }
}
