import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> inputs;
    static void dfs(int idx, int cnt, StringBuilder sb){
        StringBuilder sb_sub = new StringBuilder(sb.toString());
        if(cnt == 6){
            System.out.println(sb);
            return;
        }
        if(idx >= inputs.size()){
            return;
        }
        dfs(idx+1, cnt+1, sb_sub.append(inputs.get(idx)).append(" "));
        dfs(idx+1, cnt, sb);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) return;

            inputs = new ArrayList<>();
            for(int i=0;i<n;i++){
                inputs.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(inputs);
            sb = new StringBuilder();
            dfs(0,0, sb);
            System.out.println();

        }

    }
}
