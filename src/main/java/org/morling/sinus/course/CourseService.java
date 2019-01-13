package org.morling.sinus.course;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.morling.sinus.course.repository.GolfCourseRepository;

@ApplicationScoped
public class CourseService {

    private final GolfCourseRepository repository;

    @Inject
    public CourseService(GolfCourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<GolfCourse> allCourses() {
        return repository.findAll();
    }
}
