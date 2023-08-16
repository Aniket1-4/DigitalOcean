package com.digitalocean.digitalocean.service;


import com.digitalocean.digitalocean.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageStorageService {

    void saveFile(MultipartFile multipartFile) throws IOException;

    void deleteFile(Long id) throws Exception;

    List<Image> getImage();
}
