package org.morling.sinus.course;

import java.util.Objects;
import java.util.UUID;

public class GolfCourseId {

    private final UUID uuid;

    public GolfCourseId(UUID uuid) {
        this.uuid = Objects.requireNonNull(uuid);
    }

    @Override
    public String toString() {
        return "GolfCourseId [uuid=" + uuid + "]";
    }
}
