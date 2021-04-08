import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 문자열들의 공통 부분을 찾는 문제 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        String result = "";
        boolean isSame = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for(int i=0;i<n;i++) {
            arr[i]=br.readLine();
        }
        for(int i=0;i<arr[0].length();i++) {
            for(int j=1;j<n;j++) {
                if(arr[0].charAt(i)==arr[j].charAt(i)) {
                    isSame = true;
                }else {
                    isSame = false;
                    break;
                }
            }
            if(isSame==false) {
                result += "?";
            }else {
                result += arr[0].charAt(i);
            }
        }
        System.out.println(result);
        br.close();
    }

}
