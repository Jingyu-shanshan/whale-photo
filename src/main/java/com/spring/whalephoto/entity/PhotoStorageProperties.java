package com.spring.whalephoto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;

@ConfigurationProperties(prefix = "file")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "photo_storage_properties")
public class PhotoStorageProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer photoStorageId;

    private Integer userId;
    private String fileName;
    private String fileFormat;
    private String uploadDirectory;
}
