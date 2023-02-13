package org.clone.videohosting.services.video;

import lombok.AllArgsConstructor;
import org.clone.videohosting.entities.Video;
import org.clone.videohosting.exceptions.VideoAlreadyExistsException;
import org.clone.videohosting.exceptions.VideoNotFoundException;
import org.clone.videohosting.repositories.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;

    @Override
    public Video getVideo(String videoTitle) {
        if(!videoRepository.existsByVideoTitle(videoTitle)) {
            throw new VideoNotFoundException();
        }

        return videoRepository.findByVideoTitle(videoTitle);

    }

    @Override
    public void saveVideo(MultipartFile file, String videoTitle, String uploaderName) throws IOException {

        if(videoRepository.existsByVideoTitle(videoTitle) && videoRepository.existsByUploaderName(uploaderName)) {
            throw new VideoAlreadyExistsException();
        }

        Video newVideo = new Video(videoTitle, "", "", uploaderName, file.getBytes());

        videoRepository.save(newVideo);

    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll().stream().collect(Collectors.toList());
    }
}
