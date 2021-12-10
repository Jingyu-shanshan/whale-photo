package com.spring.whalephoto.service;

import com.spring.whalephoto.builder.entity.PhotoStoragePropertiesBuilder;
import com.spring.whalephoto.entity.PhotoStorageProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class PhotoServiceTest {

    private PhotoService photoService;

    @TempDir
    private File tempDirectory;

    @BeforeEach
    void setUp() {
        PhotoStorageProperties photoStorageProperties = new PhotoStoragePropertiesBuilder().withUploadDirectory(tempDirectory.getAbsolutePath()).build();
        photoService = new PhotoService(photoStorageProperties);
    }

    @Test
    void shouldStoreTheFileToFolderWhenInvokeMethodGivenMultipartFile() throws IOException {
        MultipartFile file = new MockMultipartFile("test.png", "test.png", null, "test".getBytes());

        String photoName = photoService.storeFile(file);

        File readFile = new File(tempDirectory, "test.png");
        Assertions.assertTrue(Files.exists(readFile.toPath()));
        Assertions.assertEquals(photoName, readFile.getName());
    }
}