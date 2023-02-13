package org.clone.videohosting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "video_id", nullable = false, length = 1000)
    private String videoId;

    @Column(name = "user_id", nullable = false, length = 1000)
    private String userId;

    @Column(name = "commenters_name", nullable = false, length = 1000)
    private String commentersName;

    @Column(name = "comment", nullable = false, length = 100000)
    private String comment;

}
