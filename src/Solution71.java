import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

public class Solution71 {
        public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
//    public String simplifyPath(String path) {
//    String[] names=path.split("/");
//    StringBuilder res = new StringBuilder();
//    ArrayList<Integer> lastIndex= new ArrayList<>();
//    lastIndex.add(-1);
//    for(int i=1;i<names.length;i++){
//       System.out.println(names[i]);
//        if(Objects.equals(names[i], ".") || Objects.equals(names[i], ""))
//            continue;
//        else if(Objects.equals(names[i], "..")){
//            //结果要截断
//            //lastIndex要回滚，还要判断够不够，不够就返回斜杠
//            if(lastIndex.size()>2)
//            {
//                lastIndex.remove(lastIndex.size()-1);
//                res= new StringBuilder(res.substring(0, lastIndex.get(lastIndex.size()-1)+1));
//                System.out.println(lastIndex.size());
//            }
//            else{
//                lastIndex=new ArrayList<>();
//                res=new StringBuilder();
//                lastIndex.add(-1);
//            }
//        }
//        else{
//            res.append("/");
//            res.append(names[i]);
//            lastIndex.add(lastIndex.get(lastIndex.size()-1)+names[i].length()+1);
//            //System.out.println(res);
//        }
//    }
//    if(res.toString().equals(""))
//        return "/";
//    return res.toString();
//    }
    public static void main(String[] args){
        Solution71 s = new Solution71();
        String path="/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        System.out.println(s.simplifyPath(path));
    }
}
