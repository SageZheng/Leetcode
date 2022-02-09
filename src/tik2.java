import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tik2 {

    /*
     * Complete the function below.
     */
    static void superStack(String[] operations) {
        Stack<Integer> num= new Stack<>();
        for(int i=0;i<operations.length;i++){
            String fir=operations[i].substring(0,3);
            //System.out.println(operations[i].substring(2,5));
            if(fir.equals("pus"))
            {
                num.push(Integer.valueOf(operations[i].substring(5)));
                System.out.println(operations[i].substring(5));
            }
            if(fir.equals("pop"))
            {
                num.pop();
                //empty?
                if(num.empty())
                    System.out.println("EMPTY");
                else
                    System.out.println(num.peek());
            }
            int indexOf=0;
            if(fir.equals("inc")){
                for(int j=3;j<fir.length();j++){
                    if(fir.charAt(j)==' ')
                        indexOf=j;
                }
                int eachNum=Integer.valueOf(operations[i].substring(4,indexOf+1));
                int v=Integer.valueOf(operations[i].substring(indexOf+2));
                System.out.println("v"+v);
                if(num.size()<eachNum)
                    eachNum=num.size();
                int[] temp=new int[eachNum];
                for(int k=0;k<eachNum;k++){
                    temp[k]=num.pop()+v;
                }
                for(int k=eachNum-1;k>0;k--){
                    num.push(temp[k]);
                }
                System.out.println(num.peek());
            }
        }
    }
    public static void main(String[] args)  {
  String[] operations= {"push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1", "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"};


        superStack(operations);

    }
}
