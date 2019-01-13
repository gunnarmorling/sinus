package org.morling.sinus.course;

import java.time.LocalDateTime;

public class Allocation {

    private final LocalDateTime start;
    private final LocalDateTime end;
    private final String description;

    public Allocation(LocalDateTime start, LocalDateTime end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return end;
    }

    public String description() {
        return description;
    }
}
