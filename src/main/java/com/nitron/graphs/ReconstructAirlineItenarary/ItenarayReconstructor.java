package com.nitron.graphs.ReconstructAirlineItenarary;

import java.util.*;

public class ItenarayReconstructor {
    public List<String> reconstructAirlineItenarary(List<List<String>> tickets) {

        Map<String, List<String>> adjMap = new HashMap<>();
        for(List<String> tkt: tickets)
        {
            updateMap(adjMap, tkt.get(0), tkt.get(1));
        }

        adjMap.forEach((k,v)-> Collections.sort(v));


        List<String> path = new ArrayList<>();
        path.add("JFK");
        String source = "JFK";
        if(backtrackAirportGraph(source, adjMap, tickets.size()+1, path))
            return path;
        return path;
    }

    private boolean backtrackAirportGraph(String source, Map<String, List<String>> adjMap,  int size, List<String> path) {
       if(path.size() == size)
           return true;

       if(!adjMap.containsKey(source))
           return false;

       List<String> destinations = adjMap.get(source);

       for(int i=0; i<destinations.size();i++) // Number of dests from source , when backtracked this iteration goes one up else stays at 0.
       {
           String dest = destinations.get(i);
           destinations.remove(dest);
           path.add(dest);
          // System.out.println(adjMap);
          // System.out.println(path);
           // Next in graph with dest as source .
           if(backtrackAirportGraph(dest, adjMap, size, path))
               return true;

           destinations.add(i, dest);
           path.remove(path.size()-1);
          // System.out.println(adjMap);
          // System.out.println(path);
       }

       return false;
    }

    private void updateMap(Map<String, List<String>> map, String currDest, String temp) {
        map.computeIfPresent(currDest, (k, v)-> {
            v.add(temp);
            return v;
        });
        map.computeIfAbsent(currDest,  (k)-> {
            List<String> destList = new ArrayList<>();
            destList.add(temp);
            return destList;
        });
    }
}
