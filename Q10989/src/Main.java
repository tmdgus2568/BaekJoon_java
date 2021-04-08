import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* java에서 제공하는 sort는 최악의 경우 O(n^2) -> 시간을 넘을 것임.
*
*  따라서 '카운팅 정렬'을 사용 -> 입력받은 숫자를 index로 하여 +1씩 한 후,
*                           출력 시 (오름차순일 시에)앞에서부터 출력
*  시간복잡도 : O(N+K) -> 데이터가 많을 수록 O(N)에 가까움  */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0;i<N;i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1;i<10001;i++){
            while(arr[i] > 0){
                sb.append(i).append('\n');
                arr[i]--;
            }
        }
        System.out.print(sb);

    }

}
