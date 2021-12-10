package com.spring.whalephoto.builder.request;

import com.spring.whalephoto.controller.dto.PhotoStoragePropertiesRequest;

public class PhotoUploadedPropertiesRequestBuilder {
    private String userId = "1";
    private String fileName = "test_png.png";

    public PhotoStoragePropertiesRequest build() {
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
