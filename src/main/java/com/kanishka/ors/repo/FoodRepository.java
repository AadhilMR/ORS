package com.kanishka.ors.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishka.ors.entity.FoodItem;

public interface FoodRepository extends JpaRepository<FoodItem, Long> {
}
