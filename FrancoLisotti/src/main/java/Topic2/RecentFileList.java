package Topic2;

import java.util.ArrayList;
import java.util.List;

public class RecentFileList {

    private List<String> mylist= new ArrayList();

    public int getListQty() {
        int result=0;
        if (!mylist.isEmpty())
        {
            result=mylist.size();
        }

        return result;
    }

    public String addFile (String str) {
        for (String file: mylist)
        {
            if (file.equals(str))
            {
                mylist.remove(file);
            }
        }
        mylist.add(str);
        if (mylist.size()>15)
        {
            mylist.remove(0);
        }
        return str;
    }

    public boolean hasFile(String str) {
        boolean rtn = false;
        for (String file: mylist){
            if (file.equals(str)){
                rtn=true;
            }
        }
        return rtn;
    }

    public String getLastFile(String s){
        return mylist.get(mylist.size()-1);
    }

}