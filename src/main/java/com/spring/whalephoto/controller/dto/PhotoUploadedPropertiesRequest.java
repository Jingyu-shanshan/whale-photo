package com.spring.whalephoto.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhotoUploadedPropertiesRequest {
    private String userId;
    private String fileName;
    private String fileType;
}
