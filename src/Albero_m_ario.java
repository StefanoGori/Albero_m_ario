//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Albero_m_ario {

	private int m;
	private Nodo_m_ario radice;

	public Albero_m_ario(int m) { // costruttore
		this.m = m;
		this.radice = null;
	}

	// ------------------------Getter e
	// Setter-----------------------------------------------------------------

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public String getContenutoNodo(Nodo_m_ario nodo) {
		return nodo.getInformazione();
	}

	public void setContenutoNodo(Nodo_m_ario nodo, String informazione) {
		nodo.setInformazione(informazione);
	}

	public Nodo_m_ario getRadice() {
		return radice;
	}

	public Nodo_m_ario getPadre(Nodo_m_ario nodo) {
		return cercaPadre(radice, nodo);
	}

	// -----------------------------------Metodi-------------------------------------------------------------------------

	public Nodo_m_ario inserisciRadice(String informazione) {// inserisci radice
		radice = new Nodo_m_ario(informazione);// salvo l'informazione in un nodo
		return radice;
	}

	public Nodo_m_ario inserisciNuovoNodo(Nodo_m_ario U, String informazione, int i) {// inserimento nuovo nodo
		Nodo_m_ario V = new Nodo_m_ario(informazione);// salvo l'informazione in un nodo
		List<Nodo_m_ario> figli = U.getFigli();// crea una lista di figli del nodo padre
		if (i >= 1 && i <= figli.size() + 1) {// se l'indice è compreso tra 1 e il numero di figli + 1
			figli.add(i - 1, V);// aggiunge il nuovo nodo alla lista dei figli
		}
		return V;
	}

	public Nodo_m_ario inserisciNuovaRadice(String informazione, int i) {// cambio radice
		if (radice != null) {
			Nodo_m_ario nuovaRadice = new Nodo_m_ario(informazione);// salvo l'informazione in un nodo
			nuovaRadice.aggiungiFiglio(radice, i);// aggiungo la vecchia radice come figlio della nuova
			radice = nuovaRadice;
		} // la nuova radice diventa la radice dell'albero
		return radice;
	}

	public List<String> visitaInProfondita() {// visita in profondità
		List<String> informazioni = new ArrayList<>();// salvo tutte le informazioni in una lista
		visitaInProfonditaHelper(radice, informazioni);// richiamo la funzione di supporto
		return informazioni;
	}

	public List<String> visitaPerLivelli() {// visita per livelli
		List<String> informazioni = new ArrayList<>();// salvo tutte le informazioni in una lista
		if (radice != null) {// se la radice non è vuota
			Queue<Nodo_m_ario> coda = new LinkedList<>();// creo una coda
			coda.offer(radice);// aggiungo la radice alla coda

			while (!coda.isEmpty()) {// finchè la coda non è vuota
				Nodo_m_ario nodo = coda.poll();// estraggo il primo elemento della coda
				informazioni.add(nodo.getInformazione());// aggiungo l'informazione alla lista

				for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
					coda.offer(figlio);// aggiungo il figlio alla coda
				}
			}
		}

		return informazioni;
	}

	public int getNumeroNodiInterni() {// conto numero nodi interni
		if (radice == null) {// se la radice è vuota ritorna 0
			return 0;
		}

		return getNumeroNodiInterniHelper(radice);// altrimenti richiamo la funzione di supporto
	}

	public int getNumeroFigliInterni(Nodo_m_ario nodo) {// conto numero figli interni
		int count = 0;// contatore

		for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
			if (!figlio.isFoglia()) {// se il figlio non è una foglia
				count++;// incremento il contatore
			}
		}

		return count;
	}

	public List<String> getInformazioniFigliInterni(Nodo_m_ario nodo) {// informazioni figli interni
		List<String> informazioni = new ArrayList<>();// salvo tutte le informazioni in una lista

		for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
			if (!figlio.isFoglia()) {// se il figlio non è una foglia
				informazioni.add(figlio.getInformazione());// aggiungo l'informazione alla lista
			}
		}

		return informazioni;
	}

	private Nodo_m_ario cercaPadre(Nodo_m_ario radice, Nodo_m_ario nodo) {// cerca padre
		if (radice == null || radice == nodo) {// se la radice è vuota o è il nodo stesso ritorna null
			return null;
		}

		for (Nodo_m_ario figlio : radice.getFigli()) {// per ogni figlio della radice
			if (figlio == nodo) {// se il figlio è il nodo stesso ritorna la radice
				return radice;
			} else {// altrimenti richiamo ricorsivamente la funzione
				Nodo_m_ario padre = cercaPadre(figlio, nodo);
				if (padre != null) {// se il padre non è null ritorna il padre
					return padre;
				}
			}
		}

		return null;
	}

	public int getNumeroFoglie() {// conto numero foglie
		if (radice == null) {// se la radice è vuota ritorna 0
			return 0;
		}

		return getNumeroFoglieHelper(radice);
	}

	public int getAltezza() {// altezza
		if (radice == null) {// se la radice è vuota ritorna 0
			return 0;
		}

		return getAltezzaHelper(radice);// altrimenti richiamo la funzione di supporto
	}

	public int getLivello(Nodo_m_ario nodo) {// livello
		if (nodo == null) {// se il nodo è null ritorna -1
			return -1;
		}

		return getLivelloHelper(radice, nodo, 0);// altrimenti richiamo la funzione di supporto
	}

	// ---------------------------------FUNZIONI DI
	// SUPPORTO--------------------------------------------------

	private void visitaInProfonditaHelper(Nodo_m_ario nodo, List<String> informazioni) {// supporto visita in profondità
		if (nodo != null) { // se il nodo non è vuoto
			informazioni.add(nodo.getInformazione());// aggiungo l'informazione alla lista
			for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
				visitaInProfonditaHelper(figlio, informazioni);// richiamo ricorsivamente la funzione
			}
		}
	}

	private int getNumeroNodiInterniHelper(Nodo_m_ario nodo) {// supporto numero nodi interni
		int count = 0;// contatore

		for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
			count += figlio.isFoglia() ? 0 : 1;// se il figlio è una foglia non incremento il contatore, altrimenti
												// incremento di 1
			count += getNumeroNodiInterniHelper(figlio);// richiamo ricorsivamente la funzione
		}

		return count;
	}

	private int getNumeroFoglieHelper(Nodo_m_ario nodo) {// supporto numero foglie
		if (nodo.isFoglia()) {// se il nodo è una foglia ritorna 1
			return 1;
		}

		int count = 0;// contatore

		for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
			count += getNumeroFoglieHelper(figlio);// richiamo ricorsivamente la funzione
		}

		return count;
	}

	private int getAltezzaHelper(Nodo_m_ario nodo) {// supporto altezza
		if (nodo.isFoglia()) {// se il nodo è una foglia ritorna 0
			return 0;
		}

		int altezzaMax = 0;// altezza massima
		for (Nodo_m_ario figlio : nodo.getFigli()) {// per ogni figlio del nodo
			int altezzaFiglio = getAltezzaHelper(figlio);// richiamo ricorsivamente la funzione
			if (altezzaFiglio > altezzaMax) {// se l'altezza del figlio è maggiore dell'altezza massima
				altezzaMax = altezzaFiglio;// l'altezza massima diventa l'altezza del figlio
			}
		}

		return altezzaMax + 1;
	}

	private int getLivelloHelper(Nodo_m_ario radice, Nodo_m_ario nodo, int livello) {// supporto livello
		if (radice == null) {// se la radice è null ritorna -1
			return -1;
		}

		if (radice == nodo) {// se la radice è il nodo stesso ritorna il livello
			return livello;
		}

		for (Nodo_m_ario figlio : radice.getFigli()) {// per ogni figlio della radice
			int livelloFiglio = getLivelloHelper(figlio, nodo, livello + 1);// richiamo ricorsivamente la funzione
			if (livelloFiglio != -1) {// se il livello del figlio è diverso da -1 ritorna il livello del figlio
				return livelloFiglio;
			}
		}

		return -1;
	}
}
