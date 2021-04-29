import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* sum이 1000을 넘어가는 일은 보지 않아도 되므로
*  44만큼만 돌면 된다 -> 44^3 = 85184 */

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[1001];
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=1000;i++){
            arr[i] = i*(i+1)/2;
        }

        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());
            search(num);


        }

    }
    static void search(int num){
        for(int a=1;a<=44;a++){
            for(int b=1;b<=44;b++){
                for(int c=1;c<=44;c++){
                    if(arr[a] + arr[b] + arr[c] == num){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
