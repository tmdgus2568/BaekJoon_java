import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* k번째 작은 수를 찾아야함
*  n이 최대 10만 이므로 완전탐색은 시간초과 (제한시간 2초)
*  -> 이분탐색 이용하여 O(nlog n) = 500,000
*
*  1  2  3  4
*  2  4  6  8
*  3  6  9  12
*  4  8  12 16
*
* i) 첫번째 줄은 1의 배수, 6/1 > n(4) -> 4
* ii) 두번째 줄은 2의 배수, 6/2 < n(4) -> 3
*
* 더하면 7 이므로 6이 답이다   */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int right = k;
        int left = 1;
        int mid;
        int ans = 0;

        // left == right 라면, == mid
        while(left <= right){
            mid = (left+right)/2;
            int sum = 0;
            // mid보다 작거나 같은 수는 몇 개인지 센다
            for(int i=1;i<=n;i++){
                sum += Math.min(mid/i, n);

            }
            if(sum < k){
                left = mid+1;
            }
            else{
                right = mid-1;
                ans = mid;

            }

        }
        System.out.println(ans);

    }
}
