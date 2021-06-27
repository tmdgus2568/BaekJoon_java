import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static int solution(String s) {
        int answer = 0;
        String str = s;
        String[] numToEng = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        int s_len = s.length();
        for(int i=0;i<10;i++){
            str = str.replaceAll(numToEng[i],String.valueOf(i));
        }
        answer = Integer.parseInt(str);

        return answer;
    }
    public static void main(String args[]){
        System.out.println(solution("one4seveneight"));
    }
}
