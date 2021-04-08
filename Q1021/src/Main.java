import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 문제 :
*   1. 첫번재 원소를 뽑아냄 -> queue
*   2. 왼쪽으로 한칸 이동 -> queue
*   3. 오른쪽으로 한칸 이동 -> deqeue, stack
*   -> 따라서 deque를 쓴다 (LinkedList로 deque를 구현할 수 있음) */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> inputs = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i=0;i<M;i++) {
            inputs.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=1;i<=N;i++) {
            q.add(i);
        }

        // 뽑아내려는 원소의 위치 확인
        int idx = 0;
        for(int i=0;i<q.size();i++) {
            if(q.get(i)==inputs.get(0)) {
                idx = i;
                break;
            }
        }

        while(!inputs.isEmpty()) {
            // 1번 수행
            if(q.get(0)==inputs.get(0)) {
                inputs.remove(0);
                q.remove(0);
                // 뽑아내려는 원소 워치 갱신
                if(!inputs.isEmpty() && q.get(0)!=inputs.get(0)) {
                    for(int i=0;i<q.size();i++) {
                        if(q.get(i)==inputs.get(0)) {
                            idx = i;
                        }
                    }
                }

            }

            // 첫번째 원소가 원하는 원소가 아니면 2 or 3번 수행
            else if(!inputs.isEmpty()) {
                // idx가 뒤와 더 가까우면 3번 수행
                if(idx > q.size()-1-idx) {

                    q.add(0,q.get(q.size()-1));
                    q.remove(q.size()-1);
                    cnt++;


                }
                // idx가 앞과 더 가까우면 2번 수행
                else{
                    q.add(q.size(), q.get(0));
                    q.remove(0);
                    cnt++;

                }

            }

        }
        System.out.println(cnt);
    }
}
