import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<ArrayList<Character>> graph = new ArrayList<ArrayList<Character>>();
        boolean match;
        int strLen = s1.length();
        for (int i = 0; i < strLen; i++) {
            match = false;
            // Scan current graph to check matches
            for (int j = 0; j < graph.size(); j++) {
                // If j contains s1, add s2
                if (graph.get(j).contains(s1.charAt(i)) && !graph.get(j).contains(s2.charAt(i))) {
                    graph.get(j).add(s2.charAt(i));
                    match = true;
                    break;
                }
                // If j contains s2, add s1
                else if (graph.get(j).contains(s2.charAt(i)) && !graph.get(j).contains(s1.charAt(i)) ) {
                    graph.get(j).add(s1.charAt(i));
                    match = true;
                    break;
                }
                // If j contains s1 and s2
                else if (graph.get(j).contains(s2.charAt(i)) && graph.get(j).contains(s1.charAt(i))) {
                    match = true;
                    break;
                }
            }
            // No match found, add new index
            if (!match) {
                graph.add(new ArrayList<Character>(List.of(s1.charAt(i), s2.charAt(i))));
            }

        }

        // Merge arrays if they share any elements
        for (int i = 0; i < graph.size(); i++) {
            for (int j = i + 1; j < graph.size(); ) {
            boolean hasCommon = false;
            for (char c : graph.get(j)) {
                if (graph.get(i).contains(c)) {
                hasCommon = true;
                break;
                }
            }
            if (hasCommon) {
                // Add all elements from graph[j] to graph[i] if not already present
                for (char c : graph.get(j)) {
                if (!graph.get(i).contains(c)) {
                    graph.get(i).add(c);
                }
                }
                // Remove merged array
                graph.remove(j);
            } else {
                j++;
            }
            }
        }

        // Sort Lists.
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        // Evaluate baseStr
        char[] resArr = new char[baseStr.length()];
        boolean curMatch;
        for (int i = 0; i < baseStr.length(); i++) {
            curMatch = false;
            // Find a match
            for (int j = 0; j < graph.size(); j++) {
                if (graph.get(j).contains(baseStr.charAt(i))) {
                    resArr[i] = graph.get(j).get(0);
                    curMatch = true;
                    break;
                }
            }
            // No match found
            if (!curMatch){
                resArr[i] = baseStr.charAt(i);
            }
        }
        String res = new String(resArr);
        return res;
    }
}