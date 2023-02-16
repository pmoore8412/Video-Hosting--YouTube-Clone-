package org.clone.videohosting.repositories;

import org.clone.videohosting.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository extends JpaRepository<Video, String> {

    Video findByVideoTitle(String videoTitle);

    boolean existsByVideoTitle(String videoTitle);

    boolean existsByUploaderName(String uploaderName);

}
