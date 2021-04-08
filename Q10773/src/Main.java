import java.util.Scanner;
import java.util.Stack;

/* 0이면 pop, 0이 아니면 push 하는 문제 */

public class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int sum = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<k;i++) {
            int a = sc.nextInt();
            // 0이면 pop
            if(a == 0 && !st.isEmpty()) {
                st.pop();
            }
            else if(a != 0){
                st.push(a);
            }
        }

        // for(int i:stack) 하면 stack 탐색 가능
        for(int i:st) {
            sum += i;
        }
        System.out.println(sum);
    }
}
