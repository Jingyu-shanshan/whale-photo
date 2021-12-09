package com.spring.whalephoto.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhotoStoragePropertiesRequest {
    private String userId;
    private String fileName;
}
