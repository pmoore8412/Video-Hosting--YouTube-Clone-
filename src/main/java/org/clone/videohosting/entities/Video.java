package org.clone.videohosting.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "video_title")
    private String title;

    @Column(name = "video_description")
    private String description;

    @Column(name = "uploader_id")
    private String userId;

    @Column(name = "video_url")
    private String url;

    @Column(name = "video_status")
    private VideoStatus videoStatus;

    @Column(name = "thumbnail")
    private String thumbnailUrl;


}
