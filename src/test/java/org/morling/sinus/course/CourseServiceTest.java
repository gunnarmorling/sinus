package org.morling.sinus.course;

import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.morling.sinus.course.CourseService;
import org.morling.sinus.course.repository.GolfCourseEntity;
import org.morling.sinus.testsupport.AbstractCdiTest;

public class CourseServiceTest extends AbstractCdiTest {

    @Inject
    private EntityManager entityManager;

    @Inject
    private CourseService courseService;

    @Test
    public void test() {
        System.out.println(courseService.allCourses());
    }

    @Before
    public void insertTestData() throws Exception {
        entityManager.getTransaction().begin();
        GolfCourseEntity course = new GolfCourseEntity();
        course.id = UUID.randomUUID();
        course.name = "Test Course";
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }
}
