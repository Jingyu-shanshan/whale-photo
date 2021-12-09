package com.spring.whalephoto.builder;

import com.spring.whalephoto.controller.dto.PhotoUploadedPropertiesRequest;

public class PhotoUploadedPropertiesRequestBuilder {
    private String userId;
    private String fileName;
    private String fileType;

    public PhotoUploadedPropertiesRequest build() {
        this.userId = "1";
        this.fileName = "test_png.png";
        this.fileType = "image/png";
        return new PhotoUploadedPropertiesRequest(userId, fileName, fileType);
    }

    public PhotoUploadedPropertiesRequestBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public PhotoUploadedPropertiesRequestBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public PhotoUploadedPropertiesRequestBuilder withFileType(String fileType) {
        this.fileType = fileType;
        return this;
    }
}
