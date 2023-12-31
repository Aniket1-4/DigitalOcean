package com.digitalocean.digitalocean.controller;


import java.io.IOException;
import java.util.List;

import com.digitalocean.digitalocean.entity.Image;
import com.digitalocean.digitalocean.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class ImageStorageController {

    @Autowired
    ImageStorageService service;

    @GetMapping("/get/images")
    public List<Image> getImages() {
        return service.getImage();
    }

    @PutMapping("/save/image")
    public void saveImage(@RequestParam(value = "image", required = true) MultipartFile image) throws IOException {
        service.saveFile(image);
    }

    @DeleteMapping("/delete/image/{fileId}")
    public void deleteById(@PathVariable("fileId") Long fileId) throws Exception {
        service.deleteFile(fileId);
    }

}

