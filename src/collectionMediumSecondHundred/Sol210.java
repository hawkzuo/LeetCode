package collectionMediumSecondHundred;

import java.util.*;

/**
 * Created by Amos on 2017/8/21.
 * Course Schedule II
 */
public class Sol210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // One more step compared to I, recording the trace

        int [] res = new int[numCourses];

        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        //Form the adjacency lists
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        int[] checked = new int[numCourses];
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<numCourses; i++){
            if(!dfsFast(graph,visited,i,checked,result)){
                return new int[0];
            }
        }

        for(int i=0;i<res.length;i++){
            res[i] = result.get(i);
        }

        return res;
    }

    private boolean dfsFast(ArrayList[] graph, boolean[] visited, int course,int[] global, List<Integer> ls){
        if(global[course] == 1){	return true;}

        //Pre Visit Operations
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfsFast(graph,visited,(int)graph[course].get(i),global,ls))
                return false;
        }
        //Post Visit Operations
        visited[course] = false;
        global[course] = 1;

        //Record trace [Tp sort]
        ls.add(0, course);
        return true;
    }
}
