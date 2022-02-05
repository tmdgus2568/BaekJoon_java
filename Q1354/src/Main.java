import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int p, q, x, y;
    static Map<Long, Long> dp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dp.put((long)0,(long)1);
        System.out.println(search(n));

    }
    static long search(long n){
        if(n <= 0) return 1;
        if(dp.containsKey(n)) return dp.get(n);
        dp.put(n,search(n/p-x)+search(n/q-y));
        return dp.get(n);

    }
}
