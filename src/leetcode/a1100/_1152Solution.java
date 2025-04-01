package leetcode.a1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 最多的用户访问模式
 * {hashmap}
 */
public class _1152Solution {

    class Node {
        String name;
        int timestamp;
        String website;

        Node(String name, int timestamp, String website) {
            this.name = name;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            nodes.add(new Node(username[i], timestamp[i], website[i]));
        }
        nodes.sort((a, b) -> a.timestamp - b.timestamp);
        Map<String, List<Node>> userVisits = new HashMap<>();
        for (Node node : nodes) {
            userVisits.computeIfAbsent(node.name, k -> new ArrayList<>()).add(node);
        }
        Map<List<String>, Integer> route = new HashMap<>();
        for (List<Node> visits : userVisits.values()) {
            Set<List<String>> tmp = new HashSet<>();
            for (int i = 0; i < visits.size(); i++) {
                for (int j = i + 1; j < visits.size(); j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        List<String> path = Arrays.asList(visits.get(i).website, visits.get(j).website,
                                visits.get(k).website);
                        tmp.add(path);
                    }
                }
            }
            for (List<String> path : tmp) {
                route.put(path, route.getOrDefault(path, 0) + 1);
            }
        }

        List<String> result = null;
        int max = -1;
        for (Map.Entry<List<String>, Integer> entry : route.entrySet()) {
            if (entry.getValue() > max
                    || (entry.getValue() == max && entry.getKey().toString().compareTo(result.toString()) < 0)) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
