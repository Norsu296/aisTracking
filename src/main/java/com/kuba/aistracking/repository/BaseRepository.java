package com.kuba.aistracking.repository;

import com.kuba.aistracking.model.entity.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
}
