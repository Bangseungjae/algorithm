package 백준._1등과2등;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int rs = 1;

        if (input.contains("21")) {
            int index = input.indexOf("21");
            if (index > 0) {
                if (input.charAt(index - 1) == '1' || input.charAt(index + 2) == '2' && input.charAt(index + 3) != '1') {
                    rs = 0;
                }
            } else if (input.length() > index + 1){
                if (input.charAt(index + 2) == '2' && input.charAt(index + 3) != '1') {
                    rs = 0;
                }
            }

        } else if (input.contains("12")) {
            int index = input.indexOf("12");
            if (index > 0) {
                if (input.charAt(index - 1) == '2' || input.charAt(index + 2) == '1' && input.charAt(index + 3) != '2') {
                    rs = 0;
                }
            } else if (input.length() > index + 1){
                if (input.charAt(index + 2) == '1' && input.charAt(index + 3) != '2') {
                    rs = 0;
                }
            }
        } else {
            rs = 0;
        }
        if (rs == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
