package org.morling.sinus.injectiontest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestService {

    private final List<String> names = new ArrayList<>();

    public List<String> getTestEntityNames() {
        return names;
    }

    public void addTestEntityName(String name) {
        names.add(name);
    }
}
