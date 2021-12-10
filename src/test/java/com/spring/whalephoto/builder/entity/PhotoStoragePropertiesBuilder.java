package com.spring.whalephoto.builder.entity;

import com.spring.whalephoto.entity.PhotoStorageProperties;

public class PhotoStoragePropertiesBuilder {
    private Integer photoStorageId = null;
    private Integer userId = 1;
    private String fileName = "test.png";
    private String fileFormat = "image/png";
    private String uploadDirectory = "/uploads";

    public PhotoStorageProperties build() {
        return new PhotoStorageProperties(photoStorageId, userId, fileName, fileFormat, uploadDirectory);
    }

    public PhotoStoragePropertiesBuilder withPhotoStorageId(Integer photoStorageId) {
        this.photoStorageId = photoStorageId;
        return this;
    }

    public PhotoStoragePropertiesBuilder withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public PhotoStoragePropertiesBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public PhotoStoragePropertiesBuilder withFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    public PhotoStoragePropertiesBuilder withUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
        return this;
    }
}
