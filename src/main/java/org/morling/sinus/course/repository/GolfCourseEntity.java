package org.morling.sinus.course.repository;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@EntityListeners(MyListener.class)
public class GolfCourseEntity {

    @Id
    public UUID id;

    public String name;
}
