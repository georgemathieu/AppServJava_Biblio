package serveur;

import java.io.IOException;
import java.net.ServerSocket;


public class Serveur implements Runnable {
	private IBaseDeDonnées bdd;
	private ServerSocket serv;
	
	
	
	public Serveur(IBaseDeDonnées b, int port) throws IOException {
		this.serv = new ServerSocket(port);
		bdd = b;
	}

	@Override
	public void run() {
		try {
			while(true){
				
				switch (serv.getLocalPort()){
				case 2500:
					new Thread(new ServiceReservation(bdd, serv.accept())).start();
					break;
				case 2600:
					new Thread(new ServiceEmprunt(bdd, serv.accept())).start();
					break;
				case 2700:
					new Thread(new ServiceRetour(bdd, serv.accept())).start();
					break;
				default :
					break;
				}
				
			}
		} catch (IOException e){
			System.err.println("probleme sur Serveur");
		}
	}

	protected void finalize() throws Throwable {
		try { serv.close();} catch (IOException e1) {}
	}
}
