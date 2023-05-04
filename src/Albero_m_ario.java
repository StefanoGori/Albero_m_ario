//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Albero_m_ario {
	private int m;
	private Nodo_m_ario node;
	private ArrayList<Nodo_m_ario> Tree=new ArrayList<Nodo_m_ario>();

	public Albero_m_ario(int m) {
		this.m = m;
	}
	
	//Getter e Setter
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Nodo_m_ario getNode() {
		return node;
	}

	public void setNode(Nodo_m_ario node) {
		this.node = node;
	}

	public ArrayList<Nodo_m_ario> getTree() {
		return Tree;
	}

	public void setTree(ArrayList<Nodo_m_ario> tree) {
		Tree = tree;
	}

	//Metodi
	public void addRoot(Nodo_m_ario root) { //inserisce la radice dell'albero
		Tree.add(root);
		
	}
	
	public void newRoot(Nodo_m_ario root,int i) { //sostituisce la radice dell'albero e imposta la vecchia radice come figlia i-esima della nuova radice
		if(Tree.size()>0){
		Nodo_m_ario t=Tree.get(0);
		Tree.set(0, root);
		root.setChild(t, i);
		Tree.add(t);
		}
		else{
			System.out.println("l albero è vuoto");
		}
	}

	public void preorder(){
		Nodo_m_ario root=Tree.get(0);
		if(root!=null){
			System.out.println(root.getInfo());
			for(Nodo_m_ario n:root.getChildren()){
				preorder();
			}
		}
	}





















































































































































	private int arieta;
	private Nodo_m_ario radice;

	public Albero_m_ario(int arieta) {
		this.arieta = arieta;
		this.radice = null;
	}

	public Nodo_m_ario inserisciRadice(String informazione) {
		radice = new Nodo_m_ario(informazione);
		return radice;
	}

	public Nodo_m_ario inserisciNuovoNodo(Nodo_m_ario padre, String informazione, int indice) {
		Nodo_m_ario nuovoNodo = new Nodo_m_ario(informazione);
		List<Nodo_m_ario> figli = padre.getFigli();
		if (indice >= 1 && indice <= figli.size() + 1) {
			figli.add(indice - 1, nuovoNodo);
		}
		return nuovoNodo;
	}

	public Nodo_m_ario inserisciNuovaRadice(String informazione) {
		Nodo_m_ario nuovaRadice = new Nodo_m_ario(informazione);
		nuovaRadice.aggiungiFiglio(radice);
		radice = nuovaRadice;
		return radice;
	}

	public List<String> visitaInProfondita() {
		List<String> informazioni = new ArrayList<>();
		visitaInProfonditaHelper(radice, informazioni);
		return informazioni;
	}

	private void visitaInProfonditaHelper(Nodo_m_ario nodo, List<String> informazioni) {
		if (nodo != null) {
			informazioni.add(nodo.getInformazione());
			for (Nodo_m_ario figlio : nodo.getFigli()) {
				visitaInProfonditaHelper(figlio, informazioni);
			}
		}
	}

	public List<String> visitaPerLivelli() {
		List<String> informazioni = new ArrayList<>();
		if (radice != null) {
			Queue<Nodo_m_ario> coda = new LinkedList<>();
			coda.offer(radice);

			while (!coda.isEmpty()) {
				Nodo_m_ario nodo = coda.poll();
				informazioni.add(nodo.getInformazione());

				for (Nodo_m_ario figlio : nodo.getFigli()) {
					coda.offer(figlio);
				}
			}
		}

		return informazioni;
	}

	public int getNumeroNodiInterni() {
		if (radice == null) {
			return 0;
		}

		return getNumeroNodiInterniHelper(radice);
	}

	private int getNumeroNodiInterniHelper(Nodo_m_ario nodo) {
		int count = 0;

		for (Nodo_m_ario figlio : nodo.getFigli()) {
			count += figlio.isFoglia() ? 0 : 1;
			count += getNumeroNodiInterniHelper(figlio);
		}

		return count;
	}

	public int getNumeroFigliInterni(Nodo_m_ario nodo) {
		int count = 0;

		for (Nodo_m_ario figlio : nodo.getFigli()) {
			if (!figlio.isFoglia()) {
				count++;
			}
		}

		return count;
	}

	public List<String> getInformazioniFigliInterni(Nodo_m_ario nodo) {
		List<String> informazioni = new ArrayList<>();

		for (Nodo_m_ario figlio : nodo.getFigli()) {
			if (!figlio.isFoglia()) {
				informazioni.add(figlio.getInformazione());
			}
		}

		return informazioni;
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

	private Nodo_m_ario cercaPadre(Nodo_m_ario radice, Nodo_m_ario nodo) {
		if (radice == null || radice == nodo) {
			return null;
		}

		for (Nodo_m_ario figlio : radice.getFigli()) {
			if (figlio == nodo) {
				return radice;
			} else {
				Nodo_m_ario padre = cercaPadre(figlio, nodo);
				if (padre != null) {
					return padre;
				}
			}
		}

		return null;
	}

	public int getNumeroFoglie() {
		if (radice == null) {
			return 0;
		}

		return getNumeroFoglieHelper(radice);
	}

	private int getNumeroFoglieHelper(Nodo_m_ario nodo) {
		if (nodo.isFoglia()) {
			return 1;
		}

		int count = 0;

		for (Nodo_m_ario figlio : nodo.getFigli()) {
			count += getNumeroFoglieHelper(figlio);
		}

		return count;
	}

	public int getAltezza() {
		if (radice == null) {
			return 0;
		}

		return getAltezzaHelper(radice);
	}

	private int getAltezzaHelper(Nodo_m_ario nodo) {
		if (nodo.isFoglia()) {
			return 0;
		}

		int altezzaMax = 0;
		for (Nodo_m_ario figlio : nodo.getFigli()) {
			int altezzaFiglio = getAltezzaHelper(figlio);
			if (altezzaFiglio > altezzaMax) {
				altezzaMax = altezzaFiglio;
			}
		}

		return altezzaMax + 1;
	}

	public int getLivello(Nodo_m_ario nodo) {
		if (nodo == null) {
			return -1;
		}

		return getLivelloHelper(radice, nodo, 0);
	}

	private int getLivelloHelper(Nodo_m_ario radice, Nodo_m_ario nodo, int livello) {
		if (radice == null) {
			return -1;
		}

		if (radice == nodo) {
			return livello;
		}

		for (Nodo_m_ario figlio : radice.getFigli()) {
			int livelloFiglio = getLivelloHelper(figlio, nodo, livello + 1);
			if (livelloFiglio != -1) {
				return livelloFiglio;
			}
		}

		return -1;
	}

	// Metodi di utilitĂ  per la stampa
	public void stampaInformazioni() {
		System.out.println("Informazioni dell'albero:");
		stampaNodo(radice, 0);
	}

	private void stampaNodo(Nodo_m_ario nodo, int livello) {
		if (nodo == null) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < livello; i++) {
			sb.append("\t");
		}
		sb.append(nodo.getInformazione());
		System.out.println(sb.toString());

		for (Nodo_m_ario figlio : nodo.getFigli()) {
			stampaNodo(figlio, livello + 1);
		}
	}
	
}
