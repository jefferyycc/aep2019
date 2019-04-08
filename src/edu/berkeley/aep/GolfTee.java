package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GolfTee {
    private final List<Integer> groups;

    public GolfTee(Integer[] groups) {
        this.groups = new ArrayList(Arrays.asList(groups));
    }

    public int groups() {
        int teeGroups = 0;
        while (groups.size() > 0) {
            int size = 0;
            teeGroups++;
            var iterator = groups.iterator();
            while (iterator.hasNext()) {
                var next = iterator.next();
                if (size + next < 5) {
                    size += next;
                    iterator.remove();
                }
            }
        }
        return teeGroups;
    }
}
