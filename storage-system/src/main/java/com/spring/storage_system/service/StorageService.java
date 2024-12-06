package com.spring.storage_system.service;

import com.spring.storage_system.entity.ImageData;
import com.spring.storage_system.repository.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {
    @Autowired
    private StorageRepo repo;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData img = repo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes()).build()
        );
        if (img != null){
            return "Success";
        }
        return null;
    }

}
