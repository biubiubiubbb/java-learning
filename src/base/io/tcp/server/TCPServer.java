package base.io.tcp.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        var threadPool = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(8090);

        List<Socket> clients = new ArrayList<>();
        do {
            clients.add(serverSocket.accept());
            var client = clients.get(clients.size() - 1);
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println("客户端:" + client.getPort() + "已连接");
                while (true) {
                    try {
                        InputStream inputStream = client.getInputStream();
                        int exitCode = 0;
                        if (client.isClosed()) {
                            System.out.println("客户端:" + client.getPort() + "异常退出");
                            break;
                        }
                        exitCode = inputStream.read();
                        if (exitCode != -1) {
                            System.out.println("接收到" + client.getPort() + "的退出编码：" + exitCode);
                            if (exitCode == 87) {
                                System.out.println("客户端:" + client.getPort() + "正常退出");
                                client.close();
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } while (clients.size() < 8);

        threadPool.shutdown();
    }
}
