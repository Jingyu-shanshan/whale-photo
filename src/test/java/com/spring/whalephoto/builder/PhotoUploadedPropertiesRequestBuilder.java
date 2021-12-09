package com.spring.whalephoto.builder;

import com.spring.whalephoto.controller.dto.PhotoStoragePropertiesRequest;

public class PhotoUploadedPropertiesRequestBuilder {
    private String userId;
    private String fileName;

    public PhotoStoragePropertiesRequest build() {
        this.userId = "1";
        this.fileName = "test_png.png";
        return new PhotoStoragePropertiesRequest(userId, fileName);
    }

    public PhotoUploadedPropertiesRequestBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public PhotoUploadedPropertiesRequestBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
