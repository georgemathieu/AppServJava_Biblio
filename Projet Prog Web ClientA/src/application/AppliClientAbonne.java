package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AppliClientAbonne {
	private final static int PORT = 2500;
	private final static String HOST = "localhost";
	
	public static void main (String[] args) {
		String line = "";
		int leave = 1;
		while (leave == 1) {

			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(" r - pour réserver un document \n q - pour quiter");
			try {
				line = clavier.readLine();
				line.toLowerCase();

				switch (line) {
				case "r":
					reserver(clavier);
					break;

				case "q":
					leave++;
					break;

				default:
					break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void reserver(BufferedReader clavier) {
		Socket socket = null;
		
		try {
			socket = new Socket(HOST, PORT);
			String line;
			PrintWriter sout = new PrintWriter (socket.getOutputStream(), true);
			BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println(sin.readLine());
			line = clavier.readLine();
			sout.println(line);

			System.out.println(sin.readLine());
			line = clavier.readLine();
			sout.println(line);
			
			System.out.println(sin.readLine());
		} catch (IOException e) {
			System.err.println(e);
		}
		
		try {
			if (socket != null)
				socket.close();
		} catch (Exception e) {
		}
	}
}
