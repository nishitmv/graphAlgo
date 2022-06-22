package com.nitron.graphs.courseSchedule;

import java.util.*;

public class CourseScheduleOrderCalc {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(prerequisites.length==0)
        {
            int j =numCourses;
            for(int i=0;i<numCourses;i++)
                result[i] = --j;
            return result;
        }
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        Map<Integer, Integer> vertexInDegreeMap = new HashMap<>();
        Set<Integer> zeroIndegreeVertices = new HashSet<>();
        for (int[] prereq : prerequisites) {
            adjacencyList.get(prereq[1]).add(prereq[0]);
            vertexInDegreeMap.computeIfPresent(prereq[0], (k, v) -> v = v + 1);
            vertexInDegreeMap.putIfAbsent(prereq[0], 1);
        }

        for( int i =0;i<numCourses;i++)
        {
            if(!vertexInDegreeMap.containsKey(i))
                zeroIndegreeVertices.add(i);
        }
        if(zeroIndegreeVertices.isEmpty())
        {
            return new int[]{};
        }

        Deque<Integer> queue = new ArrayDeque<>(zeroIndegreeVertices);
        int k = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            result[k] = vertex;
            k++;
            adjacencyList.get(vertex).forEach(vx -> {
                if (vertexInDegreeMap.containsKey(vx)) {
                    if (vertexInDegreeMap.get(vx) > 1)
                        vertexInDegreeMap.computeIfPresent(vx, (key, val) -> val -= 1);
                    else {
                        vertexInDegreeMap.remove(vx);
                        queue.add(vx);
                    }
                }
            });

        }
        if(k==numCourses)
            return result;
        else
            return new int[]{};

    }
}
