package org.morling.sinus;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.morling.sinus.course.CourseService;
import org.morling.sinus.course.GolfCourse;
import org.morling.sinus.course.repository.GolfCourseRepository;
import org.morling.sinus.tournament.TournamentService;

public class TournamentTest {

    @Test
    public void canEnrollForTournament() {
        CourseService courseService = new CourseService(new GolfCourseRepository());
        TournamentService tournamentService = new TournamentService();

        List<GolfCourse> courses = courseService.allCourses();

        tournamentService.setupTournament(
                courses.iterator().next().id(),
                "President's Cup",
                LocalDateTime.of(2018, 3, 17, 9, 30)
        );
        System.out.println(courses);

    }

}
