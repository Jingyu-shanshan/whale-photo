package com.spring.whalephoto.service;

import com.spring.whalephoto.entity.PhotoStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class PhotoService {

    private final Path photoStorageLocation;

    @Autowired
    public PhotoService(PhotoStorageProperties photoStorageProperties) {
        this.photoStorageLocation = Paths.get(photoStorageProperties.getUploadDirectory())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.photoStorageLocation);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public String storeFile(MultipartFile photo) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(photo.getOriginalFilename()));

        try {
            if(fileName.contains("..")) {
                return "error";
            }

            Path targetLocation = this.photoStorageLocation.resolve(fileName);
            Files.copy(photo.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            return "error";
        }
    }
}
