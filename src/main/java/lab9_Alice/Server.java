package lab9_Alice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket client = ss.accept();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

            while (true) {
                String[] userWords = br.readLine().split("\\s+|\\p{Punct}+");
                if (userWords[0].equals("close")) {
                    bw.write("Goodbye#");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write(Dictionary.getWordWithMAxWeight(userWords) +  "?");
                    bw.newLine();
                    bw.flush();
                }
            }
        }
    }
}
