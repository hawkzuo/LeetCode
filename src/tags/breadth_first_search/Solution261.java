//261. Graph Valid Tree

package tags.breadth_first_search;

public class Solution261 {

    public boolean validTree(int n, int[][] edges) {
        
    	//Remind: only at the end or find a circle can surely end this function.
    	
    	
    	int len = edges.length;
        if(len+1 != n){ return false;}
        int[] flags = new int[len+1];
        int marker = 1;        
        for(int i=0;i<len;i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(flags[x] == 0 && flags[y] == 0){
               flags[x] = marker;
                flags[y] = marker;
                marker++;
            }else if(flags[x] == 0 && flags[y] != 0){
                flags[x] = flags[y];
            }else if(flags[x] != 0 && flags[y] == 0){
                flags[y] = flags[x];
            }else{
                
                if(flags[x] == flags[y]){
                    //Detacted a circle
                    return false;
                }else{
                	int l = flags[x];
                    for(int j=0;j<len;j++){
                        
                        if(flags[j] == l){
                            flags[j] = flags[y];
                        }
                    }
                    
                }
            }
           
        }
        
        return true;

    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution261 s = new Solution261();  

		int[][] arr = {{0,1},{2,3},{4,5},{6,7},{1,4},{0,2},{1,7}};
		System.out.println(s.validTree(8, arr));
		
    }
    
    
    
    
}
