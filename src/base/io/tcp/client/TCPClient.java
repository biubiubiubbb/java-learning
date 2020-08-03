package base.io.tcp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPClient {
    public static void main(String[] args) throws IOException {

        ExecutorService threadPoor = Executors.newFixedThreadPool(5);
        List<Socket> clients = new ArrayList<>();
        clients.add(new Socket("127.0.0.1", 8090));
        clients.add(new Socket("127.0.0.1", 8090));
        clients.add(new Socket("127.0.0.1", 8090));


        for (var client : clients) {
            threadPoor.submit(() -> {
                try {
                    OutputStream outputStream = client.getOutputStream();
                    System.out.println("客户端:" + client.getLocalPort() + "正在输入：");
                    Scanner scanner = new Scanner(System.in);
                    int exitCode = scanner.nextInt();
                    outputStream.write(exitCode);
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoor.shutdown();
    }
}
