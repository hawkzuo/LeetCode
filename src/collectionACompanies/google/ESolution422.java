package collectionACompanies.google;

import java.util.List;

/**
 * Created by Amos on 2017/7/2.
 * Valid Word Square
 */
public class ESolution422 {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0){   return true;    }
        if(words.get(0) == null || words.get(0).length() == 0){ return false;}

        int dim = words.get(0).length();
        if(dim != words.size()){    return false;}

        char[][] corpus = new char[dim][];
        for(int i=0;i<dim;i++){
            corpus[i] = words.get(i).toCharArray();
        }
        //Checking
        for(int i=0;i<dim;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<dim;j++){
                if(i < corpus[j].length){
                    sb.append(corpus[j][i]);
                }
            }
            if(!sb.toString().equals(words.get(i))){
                return false;
            }
        }
        return true;
    }
}
