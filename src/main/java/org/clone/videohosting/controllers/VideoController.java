package org.clone.videohosting.controllers;

import java.io.IOException;
import java.util.List;

import org.clone.videohosting.entities.Video;
import org.clone.videohosting.services.video.VideoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/video")
@AllArgsConstructor
@CrossOrigin
public class VideoController {
    
    private VideoService videoService;

    @PostMapping("/upload")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("title") String videoTitle, @RequestParam("uploader") String uploaderName) throws IOException {

        videoService.saveVideo(file, videoTitle, uploaderName);
            
        return ResponseEntity.ok("video uploaded successfully");

    }

    @GetMapping("/{title}")
    public ResponseEntity<Resource> getVideo(@PathVariable(name = "title") String videoTitle) {

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(new ByteArrayResource(videoService.getVideo(videoTitle).getData()));

    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.getAllVideos());
    }

}
