package com.spring.whalephoto.repository;

import com.spring.whalephoto.entity.PhotoStorageProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoStoragePropertiesRepository extends CrudRepository<PhotoStorageProperties, Integer> {
}
