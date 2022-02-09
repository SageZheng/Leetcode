import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



    class Result {

        /*
         * Complete the 'fizzBuzz' function below.
         *
         * The function accepts INTEGER n as parameter.
         */

        public static void fizzBuzz(int n) {
            for(int i=1; i<=n;i++)
                judge(i);
        }
        public static void judge(int n){
            String res="";
            if(n%5==0){
                res="Fizz";
            }
            if(n%3==0){
                res=res+"Buzz";
            }
            if(res==""){
                res=String.valueOf(n);
            }
            System.out.println(res);
        }
    }

    public class tiktok {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            Result.fizzBuzz(n);

            bufferedReader.close();
        }
    }


