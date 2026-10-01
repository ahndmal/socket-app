package com.anma.skt;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ChatAppServer {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(7072);

            Socket client1 = serverSocket.accept();

            System.out.println("[ -- ] Client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            PrintWriter writer = new PrintWriter(client1.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // Sender

            Thread sender = new Thread(() -> {
                String msg = scanner.nextLine();
                writer.println(msg);
                writer.flush();
            });
            sender.start();

            // Receiver

            Thread receiver = new Thread(() -> {
                System.out.println("> Server receiver in Thread: " + Thread.currentThread().getName());
                String msg = null;
                try {
                    msg = reader.readLine();

                    while (msg != null) {
                        System.out.println("Message from Client:: " + msg);
                        msg = reader.readLine();
                    }

                    System.out.println("> Client disconnected");
                    writer.flush();
//                    client1.close();
//                    serverSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
