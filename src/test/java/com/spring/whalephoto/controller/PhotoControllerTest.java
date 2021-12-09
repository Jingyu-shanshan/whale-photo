package com.spring.whalephoto.controller;

import com.spring.whalephoto.builder.PhotoUploadedPropertiesRequestBuilder;
import com.spring.whalephoto.controller.common.ObjectToJsonStringConvertor;
import com.spring.whalephoto.controller.dto.PhotoStoragePropertiesRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PhotoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldUploadPhotoWhenCallingApi() throws Exception {
        PhotoStoragePropertiesRequest photoStoragePropertiesRequest = new PhotoUploadedPropertiesRequestBuilder().build();
        MockMultipartFile photo = new MockMultipartFile("photos", "testFile.png", "image/png", "some image".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("photoRequest", "", "application/json", ObjectToJsonStringConvertor.asJsonString(photoStoragePropertiesRequest).getBytes());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/photo/upload")
                .file(photo)
                .file(jsonFile))
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
    }
}