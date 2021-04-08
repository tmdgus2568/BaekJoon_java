import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/* 첫번째 우선순위 : 나이
*  두번째 우선순위 : index (가입한 순)
*
*  N은 최대 100,000이므로 sort 이용 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][3];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);

            // 나이
            arr[i][0] = st.nextToken();
            // 가입 순서
            arr[i][1] = Integer.toString(i);
            // 이름
            arr[i][2] = st.nextToken();
        }

        // Arrays.sort : Dual-Pivot Quick Sort -> O(nlog n), 최악의 경우는 O(n^2)
        // arg0 - arg1 : 오름차순 (return값이 음수면 arg0값을 맨 앞으로 배치 ?)
        // arg1 - arg0 : 내림차순 (return값이 음수면 arg1값을 맨 앞으로 배치 ?)
        Arrays.sort(arr, new Comparator<String[]>() {

            @Override
            public int compare(String[] arg0, String[] arg1) {
                if(Integer.parseInt(arg0[0]) == Integer.parseInt(arg1[0])) {
                    return Integer.parseInt(arg0[1]) - Integer.parseInt(arg1[1]);
                }
                else {
                    return Integer.parseInt(arg0[0]) - Integer.parseInt(arg1[0]);
                }
            }

        });

        for(int i=0;i<N;i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][2]).append("\n");
        }
        System.out.print(sb);
    }
}
