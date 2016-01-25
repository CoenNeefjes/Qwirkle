package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import game.Game;

public class Server {
	
	private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers;
    public List<Game> waiting;
    public List<Game> running;
	
    private static final String USAGE
    = "usage: " + Server.class.getName() + " <port>";

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(0);
		}
		
		int port = 0;
		ServerSocket serverSocket;
		
		// parse args[1] - the port
		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println(USAGE);
    		System.out.println("ERROR: port " + args[0] + " is not an integer.");
    		System.exit(0);
		}
		
		try {
			serverSocket = new ServerSocket(port);
			Server server = new Server(serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Socket clientSocket = serverSocket.accept();
			ClientHandler clientHandler = new ClientHandler(name, clientSocket);
			Thread streamInputHandler = new Thread(clientHandler);
			streamInputHandler.start();
			clientHandler.handleTerminalInput();
			clientHandler.shutDown();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		this.clientHandlers = new ArrayList<ClientHandler>();
	}
	
	public void run() {
		
	}

}
