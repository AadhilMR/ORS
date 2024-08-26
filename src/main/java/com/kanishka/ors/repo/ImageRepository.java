package com.kanishka.ors.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishka.ors.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
