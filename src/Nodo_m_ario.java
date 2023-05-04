//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Nodo_m_ario {
	
	private String info; //informazione nodo
	private ArrayList<Nodo_m_ario> Children=new ArrayList<Nodo_m_ario>(); //figli del nodo
	
	public Nodo_m_ario(String info, ArrayList<Nodo_m_ario> children) {
		this.info = info;
		Children = children;
	}

	//Getter e Setter
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	public void setChild(Nodo_m_ario v, int i) {
		if (i < Children.size()) {
			Children.set(i, v);
		} else {
			while (Children.size() < i) {
				Children.add(null);
			}
			Children.add(v);
		}
	}
	
	

	public ArrayList<Nodo_m_ario> getChildren() {
		return Children;
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
