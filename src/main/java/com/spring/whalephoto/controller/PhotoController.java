package com.spring.whalephoto.controller;

import com.spring.whalephoto.controller.dto.PhotoStoragePropertiesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadPhoto(
            @RequestPart(value = "photoRequest") PhotoStoragePropertiesRequest photoStoragePropertiesRequest,
            @RequestParam(value = "photos", required = false) List<MultipartFile> photos
    ) {
        return ResponseEntity.ok("success");
    }
}
