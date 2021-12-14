package com.spring.whalephoto.service;

import com.spring.whalephoto.builder.entity.PhotoStoragePropertiesBuilder;
import com.spring.whalephoto.entity.PhotoStorageProperties;
import com.spring.whalephoto.repository.PhotoStoragePropertiesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PhotoServiceTest {

    private PhotoService photoService;

    @Mock
    private PhotoStoragePropertiesRepository photoStoragePropertiesRepository;

    @TempDir
    private File tempDirectory;

    @PostConstruct
    public void initMock(){
        Mockito.when(photoStoragePropertiesRepository.save(any())).thenReturn(new PhotoStoragePropertiesBuilder().build());
    }

    @BeforeEach
    void setUp() {
        PhotoStorageProperties photoStorageProperties = new PhotoStoragePropertiesBuilder().withUploadDirectory(tempDirectory.getAbsolutePath()).build();
        photoService = new PhotoService(photoStorageProperties, photoStoragePropertiesRepository);
    }

    @Test
    void shouldStoreTheFileToFolderWhenInvokeMethodGivenMultipartFile() throws IOException {
        MultipartFile file = new MockMultipartFile("test.png", "test.png", null, "test".getBytes());

        String photoName = photoService.storeFile(file);

        File readFile = new File(tempDirectory, "test.png");
        Assertions.assertTrue(Files.exists(readFile.toPath()));
        Assertions.assertEquals(photoName, readFile.getName());
        verify(photoStoragePropertiesRepository, times(1)).save(any());
    }
}