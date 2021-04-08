import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 이중배열 sort : Comparator 이용
*  N은 최대 100,000이므로
*  java에서 제공하는 sort의 시간복잡도는 O(nlog n) = 500,000 (1초 미만) */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = "";
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                }
                else {
                    return arg0[1] - arg1[1];
                }

            }

        });

        for(int i=0;i<N;i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.print(sb);


    }
}
