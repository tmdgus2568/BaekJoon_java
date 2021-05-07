import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isbroken = new boolean[10];

    static int possible(int num) { // num에 고장나 누를 수 없는 버튼이 있을 경우 0 반환 (불가능함을 의미)
        if (num == 0) { // 예외
            if (isbroken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int cnt = 0;
        while (num > 0) {
            // 각자리수를 확인
            if (isbroken[num%10]) {
                return 0;
            }
            cnt += 1;
            num /= 10;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n_str = br.readLine();
        int n = Integer.parseInt(n_str);

        int m = Integer.parseInt(br.readLine());
        if(m != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<m;i++){
                isbroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // + - 버튼으로 이동가능한 경우를 먼저 초기값으로 설정
        // 이후에 더 최소값이 있다면 갱신할 것임
        int ans = Math.abs(n - 100);

        
        for (int i=0;i<1000000;i++) {

            int cnt = possible(i); // cnt가 0이면 불가능

            if (cnt > 0) {
                // + - 를 포함해 몇번 누르는지 센다
                cnt += Math.abs(i - n);
                ans = Math.min(ans, cnt);

            }

        }
        System.out.println(ans);



    }
}
