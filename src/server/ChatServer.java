package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Servidor iniciado! Aguardando cliente ...");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Cliente conectado com sucesso: " + clientSocket);

             ClientHandler clientThread = new ClientHandler(clientSocket, clients);

             clients.add(clientThread);

             new Thread(clientThread).start();
        }
    }
}

