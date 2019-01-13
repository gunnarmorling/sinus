package org.morling.sinus.course;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GolfCourse {

    private final GolfCourseId id;
    private final String name;
    private final List<Hole> holes;
    private final List<Allocation> allocations;

    public static class Builder {

        private final GolfCourseId id;
        private String name;
        private final List<Hole> holes;

        public Builder(GolfCourseId id) {
            this.id = id;
            this.holes = new ArrayList<Hole>();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withHole(int par, int difficultyOrder) {
            holes.add(new Hole(par, difficultyOrder));
            return this;
        }

        public GolfCourse build() {
            return new GolfCourse(id, name, holes);
        }
    }

    public GolfCourse(GolfCourseId id, String name, List<Hole> holes) {
        this.id = id;
        this.name = name;
        this.holes = holes;
        this.allocations = new ArrayList<>();
    }

    public static Builder builder(GolfCourseId id) {
        return new Builder(id);
    }

    public GolfCourseId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Allocation allocate(LocalDateTime start, LocalDateTime end, String description) {
        for (Allocation allocation : allocations) {
            if (allocation.start().isBefore(start) && allocation.end().isAfter(start) ||
                    allocation.start().isBefore(end) && allocation.end().isAfter(end)) {
                return null;
            }
        }

        Allocation allocation = new Allocation(start, end, description);
        allocations.add(allocation);

        return allocation;
    }

    @Override
    public String toString() {
        return "GolfCourse [id=" + id + ", name=" + name + ", holes=" + holes + "]";
    }
}
