package com.MockSpring2.Social.media.platform.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {

    @CreationTimestamp
    private Time time;

    @ManyToOne
    @JoinColumn
    Post post;

    @ManyToOne
    @JoinColumn
    User user;
}
