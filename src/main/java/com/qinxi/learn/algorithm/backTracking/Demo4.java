package com.qinxi.learn.algorithm.backTracking;

import org.junit.Test;

import java.util.*;

public class Demo4 {

    private LinkedList<String> result = new LinkedList<>();


    @Test
    public void test() {
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "ATL")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("ATL", "SFO")));
        System.out.println(findItinerary(tickets));
    }




    public List<String> findItinerary(List<List<String>> tickets) {
        //from  to:ticket
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> toMap = map.get(from);
            toMap.put(to, toMap.getOrDefault(to, 0) + 1);
        }
        result.add("JFK");
        backTrack(tickets, map, 0);
        return result;
    }


    public boolean backTrack(List<List<String>> tickets, Map<String, TreeMap<String, Integer>> map, int usedTitckCnt) {
        if(usedTitckCnt == tickets.size()) {
            return true;
        }
        String from = result.get(result.size() - 1);
        TreeMap<String, Integer> toMap = map.get(from);
        if(toMap == null || toMap.isEmpty()) {
            return false;
        }
        for(String to : toMap.keySet()) {
            if(toMap.get(to) == 0) {
                continue;
            }
            result.add(to);
            toMap.put(to, toMap.get(to) - 1);
            if(backTrack(tickets, map, usedTitckCnt + 1)) {
                return true;
            }
            toMap.put(to, toMap.get(to) + 1);
            result.remove(result.size() - 1);
        }
        return false;
    }
}
