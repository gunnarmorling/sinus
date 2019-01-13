//package org.morling.sinus.bak;
//
//import java.util.UUID;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.transaction.UserTransaction;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.morling.sinus.course.CourseService;
//import org.morling.sinus.course.repository.GolfCourseEntity;
//
//public class CourseServiceTest extends CdiTestBase {
//
//    @Inject
//    private EntityManager entityManager;
//
//    @Inject
//    private CourseService courseService;
//
//    @Inject
//    private UserTransaction ut;
//
//    @Test
//    public void test() {
//        System.out.println(courseService.allCourses());
//    }
//
//    @Before
//    public void insertTestData() throws Exception {
////        ut.begin();
////        com.arjuna.ats.jta.UserTransaction.userTransaction().begin();
//
//        entityManager.getTransaction().begin();
//        GolfCourseEntity course = new GolfCourseEntity();
//        course.id = UUID.randomUUID();
//        course.name = "Test Course";
//        entityManager.persist(course);
//
////        ut.commit();
//        entityManager.getTransaction().commit();
//    }
//}
