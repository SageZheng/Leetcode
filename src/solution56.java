public class solution56 {
    public int lengthOfLastWord(String s) {
     int index=-1;
     int end=s.length();
     for(int i =0;i<s.length()-1;i++){
         if(s.charAt(i)==' '&&s.charAt(i+1)!=' ')
             index=i;
     }
     for(int i=s.length()-1;i>=0;i--){
         if(s.charAt(i)!=' '){
             end=i;
             break;
         }
     }
     return end-index;
    }
    public static void main(String[] args){
        String a = "a";
        solution56 s= new solution56();
        int b =s.lengthOfLastWord(a);
        System.out.println(b);
        System.out.println((int) '1' -48);
    }
}
