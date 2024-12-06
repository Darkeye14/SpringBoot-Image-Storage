package com.spring.storage_system.repository;


import com.spring.storage_system.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepo extends JpaRepository<ImageData,Long > {
   Optional<ImageData> findByName(String fileName);
}
