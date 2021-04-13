import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* stack에 저장 후, 만약 전에 나왔던 숫자가 또 나왔을 경우 (나오는 숫자마자 D[i] = 1로 체크)
*  stack을 그 숫자가 나올 때 까지 pop -> 반복되지 않은 수열을 찾을 수 있음 !  */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());

        int A_int = Integer.parseInt(A);
        int[] D = new int[240000];
        int i = A_int;
        String i_str = "";
        int i_str_size = 0;
        int sum = 0;


        Stack<Integer> stack = new Stack<>();
        stack.push(A_int);

        while(D[i] == 0){
            i_str = Integer.toString(i);
            i_str_size = i_str.length();


            for(int j=0;j<i_str_size;j++){
                sum += Math.pow(Integer.parseInt(String.valueOf(i_str.charAt(j))),P);
            }
            D[i] = 1;
            i = sum;


            if(D[i] != 0){
                while (!stack.isEmpty() && stack.pop() != i ){

                }
                break;
            }
            stack.push(sum);
            sum = 0;

        }

        System.out.println(stack.size());

    }
}
