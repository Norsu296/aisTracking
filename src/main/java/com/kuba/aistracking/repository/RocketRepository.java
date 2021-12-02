package com.kuba.aistracking.repository;

import com.kuba.aistracking.model.entity.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RocketRepository extends JpaRepository<Rocket, Long> {
}
