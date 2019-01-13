package org.morling.sinus.course.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.morling.sinus.course.GolfCourse;
import org.morling.sinus.course.GolfCourseId;

@ApplicationScoped
public class GolfCourseRepository {

    @Inject
    private EntityManager entityManager;

    private final List<GolfCourse> courses;

    public GolfCourseRepository() {
        courses = Arrays.asList(
                GolfCourse.builder(new GolfCourseId(UUID.randomUUID()))
                    .withName("Castle Course")
                    .withHole(4, 6)
                    .withHole(4, 9)
                    .withHole(3, 3)
                    .withHole(5, 2)
                    .withHole(4, 5)
                    .withHole(3, 7)
                    .withHole(5, 1)
                    .withHole(4, 4)
                    .withHole(4, 8)
                    .build()
                );
    }

    public Optional<GolfCourse> findByName(String name) {
        for (GolfCourse golfCourse : courses) {
            if (golfCourse.name().equals(name)) {
                return Optional.of(golfCourse);
            }
        }

        return Optional.empty();
    }

//    public void processCustomerUpdated1(@Observes(during=TransactionPhase.IN_PROGRESS) String ev) {
//        System.out.println("Received (in progress):" + ev);
//    }

    public void processCustomerUpdated(@Observes(during=TransactionPhase.AFTER_SUCCESS) String ev) {
        System.out.println("Received (after):#####" + ev);
    }


    public List<GolfCourse> findAll() {
        TypedQuery<GolfCourseEntity> query = entityManager.createQuery("FROM GolfCourseEntity c", GolfCourseEntity.class);

        return query.getResultList()
            .stream()
            .map(gce -> GolfCourse.builder(new GolfCourseId(gce.id)).withName(gce.name).build())
            .collect(Collectors.toList());
    }
}
