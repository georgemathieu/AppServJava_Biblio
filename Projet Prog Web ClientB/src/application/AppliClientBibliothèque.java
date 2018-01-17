package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AppliClientBibliothèque {
	private final static int PORT_EMPRUNT = 2600;
	private final static int PORT_RETOUR = 2700;

	private final static String HOST = "localhost";

	public static void main(String[] args) {
		String line = "";
		int leave = 1;
		while (leave == 1) {

			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(" e - pour emprunter \n r - pour retrourner \n q - pour quiter");
			try {
				line = clavier.readLine();
				line.toLowerCase();

				switch (line) {
				case "e":
					emprunter(clavier);
					break;

				case "r":
					retourner(clavier);
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

	private static void retourner(BufferedReader clavier) {
		Socket retour = null;
		try {
			retour = new Socket(HOST, PORT_RETOUR);
			PrintWriter out = new PrintWriter(retour.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(retour.getInputStream()));

			String line = "";

			System.out.println(in.readLine());//numéro doc
			line = clavier.readLine();
			out.println(line);
			System.out.println(in.readLine());//etat physique du livre
			line = clavier.readLine();
			out.println(line);
			System.out.println(in.readLine());//livre rendu
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (retour != null)
				retour.close();
		} catch (Exception e) {
		}
	}

	private static void emprunter(BufferedReader clavier) {
		Socket emprunt = null;
		try {
			emprunt = new Socket(HOST, PORT_EMPRUNT);
			String line;
			PrintWriter out = new PrintWriter(emprunt.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(emprunt.getInputStream()));


			System.out.println(in.readLine());
			line = clavier.readLine();
			out.println(line);

			System.out.println(in.readLine());
			line = clavier.readLine();
			out.println(line);

			System.out.println(in.readLine());
			
		} catch (IOException e) {
			System.err.println(e);
		}
		
		try {
			if (emprunt != null)
				emprunt.close();
		} catch (Exception e) {
		}
	}
}
