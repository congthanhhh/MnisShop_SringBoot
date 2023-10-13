package com.thanh.mnisShop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadImageService {

    public void saveImage(MultipartFile img, String uploadPath) {
        try {
            if (img != null && !img.isEmpty()) {
                File uploadDirectory = new File(uploadPath);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                File saveFile = new File(uploadDirectory, img.getOriginalFilename());
                Path filePath = Paths.get(saveFile.getAbsolutePath());
                Files.copy(img.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}