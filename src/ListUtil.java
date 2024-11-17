import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    private List<String> list;

    public ListUtil(List<String> list) {
        this.list = list;
    }

    public boolean contains(String str){
        if (list == null){
            return false;
        }

        for (String s: list ){
            if (s.equals(str)){
                return true;
            }
        }
        return false;


        //return list.contains(str);
    }

    public int indexOf(String str){
        if(list==null){
            return -2;
        }
        if(str==null){
            return -1;
        }
        return list.indexOf(str);


    }


    public List<String> sort(){
        if (list==null){
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>(list);
        Collections.sort(result);
        return result;
    }





}
