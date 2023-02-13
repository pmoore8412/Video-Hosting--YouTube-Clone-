package org.clone.videohosting.services.video;

import org.clone.videohosting.entities.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {

    Video getVideo(String videoTitle);

    void saveVideo(MultipartFile file, String videoTitle, String uploaderName) throws IOException;

    List<Video> getAllVideos();

}
