import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 1
*  3
*  1
*
* 인 경우 (정렬된 집합의 첫번째 원소보다 n이 작은 경우)를
* 고려해야 한다. */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputs = new int[L+1];
        inputs[0] = 0;
        for(int i=1;i<=L;i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        int sum = 0;
        Arrays.sort(inputs);

        int i = 0;
        while (inputs[i] < n) i++;
        if(i>=1){
            start = inputs[i-1];
            end = inputs[i];
        }

        System.out.println(search(start, end, n));

    }

    static int search(int start, int end, int n){
        int start2 = start + 1;
        int end2 = end - 1;
        int sum = 0;
        if(start2 >= end2 || n > end2){
            return 0;
        }
        while(start2 < n){
            sum += end2-n+1;
            start2++;
        }
        sum += end2-n;
        return sum;
    }

}

