package collectionACompanies.facebook;

import java.util.ArrayList;
import java.util.List;

//Many cases
public class Solution057 {

	public Solution057() {
		// TODO Auto-generated constructor stub
	}
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){    return intervals;}
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0 ){
            res.add(newInterval);
            return res;
        }        
        int total = intervals.size();
        int refStart = newInterval.start;   int refEnd = newInterval.end;
        Interval bigInter = new Interval(-1,-1);

        boolean cStart = true; 
        if(refEnd < intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }else if(refStart > intervals.get(total-1).end ){
            intervals.add(newInterval);
            return intervals;
        }else{
        
            for(int i=0;i<total;i++){
                
                Interval curr = intervals.get(i);
                if(cStart){
                    if(refStart <= curr.end){
                        //Found
                        //Sp1:
                        if(refStart < curr.start){
                            bigInter.start = refStart;
                            
                            if(refEnd < curr.start){
                                intervals.add(i,newInterval);
                                return intervals;
                            }else if(refEnd <= curr.end){
                                bigInter.end = curr.end;
                                intervals.remove(i);
                                intervals.add(i,bigInter);
                                return intervals;
                            }else{
                                cStart = false;
                            }
                            
                        }else{
                            bigInter.start = curr.start;
                            if(refEnd <= curr.end){
                                bigInter.end = curr.end;
                                //intervals.remove(i);
                                //intervals.add(i,bigInter);
                                return intervals;
                            }else{
                                cStart = false;
                            }                            
                        }
                    }else{
                        res.add(curr);
                    }
                }else{
                    
                    if(refEnd < curr.start){
                        //Finished
                        bigInter.end = refEnd;
                        res.add(bigInter);
                        res.add(curr);
                        i++;
                        while(i<total){
                            res.add(intervals.get(i));
                            i++;
                        }
                        return res;
                    }else if(refEnd <= curr.end){
                        bigInter.end = curr.end;
                        res.add(bigInter);
                        i++;
                        while(i<total){
                            res.add(intervals.get(i));
                            i++;
                        }
                        return res;                        
                    }else{
                        ;
                    }
                }
  
            }
            bigInter.end = refEnd;
            res.add(bigInter);
            return res;
        }        
    }
}
