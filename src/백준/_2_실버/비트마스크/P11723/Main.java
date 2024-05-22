package 백준._2_실버.비트마스크.P11723;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            Integer number = null;
            if (st.hasMoreTokens()) {
                number = Integer.parseInt(st.nextToken());
            }
            switch (s) {
                case "add":
                    if (!list.contains(number)) {
                        list.add(number);
                    }
                    break;
                case "remove":
                    list.remove(number);
                    break;
                case "check":
                    if (list.contains(number)) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    if (list.contains(number)) {
                        list.remove(number);
                    } else {
                        list.add(number);
                    }
                    break;
                case "all":
                    list.clear();
                    for (int j = 1; j < 21; j++) {
                        list.add(j);
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
