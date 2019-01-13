package org.morling.sinus.course.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PostPersist;

import org.morling.sinus.course.CourseService;

@ApplicationScoped
public class MyListener {

    @Inject
    private CourseService courseService;

    @PostPersist public void onPostPersist(GolfCourseEntity gce) {
        System.out.println(gce);
        System.out.println("Course Service in Listener: " + courseService);
    }
}
