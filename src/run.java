//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.List;

public class run {

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");

		Albero_m_ario albero = new Albero_m_ario(5);

		Nodo_m_ario radice = albero.inserisciRadice("A");
		Nodo_m_ario nodoB = albero.inserisciNuovoNodo(radice, "B", 1);
		Nodo_m_ario nodoC = albero.inserisciNuovoNodo(radice, "C", 2);
		Nodo_m_ario nodoD = albero.inserisciNuovoNodo(radice, "D", 3);

		Nodo_m_ario nodoE = albero.inserisciNuovoNodo(nodoB, "E", 1);
		
		albero.inserisciNuovoNodo(nodoB, "F", 2);
		albero.inserisciNuovoNodo(nodoE, "P", 1);
		albero.inserisciNuovaRadice("X");
	
		radice = albero.getRadice();
        

		albero.inserisciNuovoNodo(albero.getRadice(), "Y", 2);
		albero.inserisciNuovoNodo(nodoD, "H", 1);


		List<String> visitaProfondita = albero.visitaInProfondita();
		System.out.println("Visita in profondit\u00E0: " + visitaProfondita);

		List<String> visitaLivelli = albero.visitaPerLivelli();
		System.out.println("Visita per livelli: " + visitaLivelli);

		int numeroNodiInterni = albero.getNumeroNodiInterni();
		System.out.println("Numero di nodi interni: " + numeroNodiInterni);

		int numeroFigliInterni = albero.getNumeroFigliInterni(radice);
		System.out.println("Numero di figli interni della radice: " + numeroFigliInterni);

		List<String> informazioniFigliInterni = albero.getInformazioniFigliInterni(radice);
		System.out.println("Informazioni dei figli interni della radice: " + informazioniFigliInterni);

		String contenutoNodo = albero.getContenutoNodo(nodoB);
		System.out.println("Contenuto del nodo B: " + contenutoNodo);

		albero.setContenutoNodo(nodoB, "K");
		System.out.println("Contenuto del nodo B dopo la modifica: " + nodoB.getInformazione());

		Nodo_m_ario radiceAlbero = albero.getRadice();
		System.out.println("Radice dell'albero: " + radiceAlbero.getInformazione());

		Nodo_m_ario padreNodoC = albero.getPadre(nodoC);
		System.out.println("Padre del nodo C: " + padreNodoC.getInformazione());

		int numeroFoglie = albero.getNumeroFoglie();
		System.out.println("Numero di foglie dell'albero: " + numeroFoglie);

		int altezzaAlbero = albero.getAltezza();
		System.out.println("Altezza dell'albero: " + altezzaAlbero);

		int livelloNodoD = albero.getLivello(nodoD);
		System.out.println("Livello del nodo D: " + livelloNodoD);
	}
}
