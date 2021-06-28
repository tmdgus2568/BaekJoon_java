import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    // 꼭 dp는 배열을 써야하는 것은 아니다 !!
    // dp는 재귀를 사용하지 않는 것은 아니다 !!
    // n이 너무 크므로 map을 쓰는 것이 더 효율적일 것이다.
    static Map<Long,Long> dp = new HashMap<>();
    static int p;
    static int q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        dp.put((long)0,(long)1);
        System.out.println(search(n));

    }

    // 이미 계산했던 숫자는 한번만 계산하도록 map에 저장하여
    // 만약 그 숫자가 저장되어 있다면
    // 불러서 그냥 갖다 쓴다 
    static long search(long n){
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        dp.put(n, search(n/p)+search(n/q));
        return dp.get(n);
    }
}
