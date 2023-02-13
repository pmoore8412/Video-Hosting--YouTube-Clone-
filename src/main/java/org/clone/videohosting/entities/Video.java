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

    @Column(name = "uploader_Id", nullable = false, length = 1000)
    private String uploaderId;

    @Column(name = "uploader_name", nullable = false, length = 1000)
    private String uploaderName;

    @Column(name = "title", length = 1000)
    private String videoTitle;

    @Column(name = "description", length = 100000)
    private String videoDescription;

    @Lob
    private byte[] data;

    public Video(String videoTitle, String videoDescription, String uploaderId, String uploaderName, byte[] data) {
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.uploaderId = uploaderId;
        this.uploaderName = uploaderName;
        this.data = data;
    }

}
