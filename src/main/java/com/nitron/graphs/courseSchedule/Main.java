package com.nitron.graphs.courseSchedule;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] prerequisites ={{0,1},{0,2},{1,3}, {3,0}};
        int numCourses = 4;

        Arrays.stream(new CourseScheduleOrderCalc().findOrder(numCourses, prerequisites)).forEach(System.out::println);

    }

}
