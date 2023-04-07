package com.MockSpring2.Social.media.platform.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {
    private String content;

    @CreationTimestamp
    private Time time;

    private int like;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Notification> notifications = new ArrayList<>();
}
