//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.ArrayList;
import java.util.List;

public class Nodo_m_ario {
	
	private String info; //informazione nodo
	private Nodo_m_ario Left; //sottoalbero sinistro
	private Nodo_m_ario Right; //sottoalbero destro
	
	public Nodo_m_ario(String info, Nodo_m_ario left, Nodo_m_ario right) {
		super();
		this.info = info;
		Left = left;
		Right = right;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Nodo_m_ario getLeft() {
		return Left;
	}
	public void setLeft(Nodo_m_ario left) {
		Left = left;
	}
	public Nodo_m_ario getRight() {
		return Right;
	}
	public void setRight(Nodo_m_ario right) {
		Right = right;
	}
	
	


































































































































































	private String informazione;
	private List<Nodo_m_ario> figli;

	public Nodo_m_ario(String informazione) {
		this.informazione = informazione;
		this.figli = new ArrayList<>();
	}

	public String getInformazione() {
		return informazione;
	}

	public void setInformazione(String informazione) {
		this.informazione = informazione;
	}

	public List<Nodo_m_ario> getFigli() {
		return figli;
	}

	public void aggiungiFiglio(Nodo_m_ario figlio) {
		figli.add(figlio);
	}

	public boolean rimuoviFiglio(Nodo_m_ario figlio) {
		return figli.remove(figlio);
	}

	public int getNumeroNodiInterni() {
		int count = 0;
		for (Nodo_m_ario figlio : figli) {
			if (!figlio.isFoglia()) {
				count++;
			}
		}
		return count;
	}

	public List<String> getInformazioniFigliInterni() {
		List<String> informazioni = new ArrayList<>();
		for (Nodo_m_ario figlio : figli) {
			if (!figlio.isFoglia()) {
				informazioni.add(figlio.getInformazione());
			}
		}
		return informazioni;
	}

	public boolean isFoglia() {
		return figli.isEmpty();
	}
	
}
