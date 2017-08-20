//210. Course Schedule II

package tags.breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Solution210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
    	int [] res = new int[numCourses];
    	
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        boolean[] visited = new boolean[numCourses];
        //Form the adjacency lists
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
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
        
        //Record trace
        ls.add(0, course);
        return true;
    }    
    
    
    
    
    
    
}
