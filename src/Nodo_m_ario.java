//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Nodo_m_ario {

	private String informazione;
	private List<Nodo_m_ario> figli;
	private Albero_m_ario albero;

	public Nodo_m_ario(String informazione) {// costruttore
		this.informazione = informazione;
		this.figli = new ArrayList<>();
	}

	// -----------------------------Getter e Setter------------------------------------------------------------

	public String getInformazione() {
		return informazione;
	}

	public void setInformazione(String informazione) {
		this.informazione = informazione;
	}

	public List<Nodo_m_ario> getFigli() {
		return figli;
	}

	// -----------------------------Metodi-------------------------------------------------------------------

	public int getM(){
		return Albero_m_ario.getM();
	}



	public void aggiungiFiglio(Nodo_m_ario figlio, int i) {
		try{
			if(i<=Albero_m_ario.getM()|| figli.get(i)==null){
				figli.add(i-1,figlio);
			}
			else{
				System.out.println("Errore: impossibile aggiungere il figlio");
			}
		}
		catch(IndexOutOfBoundsException e){
			for(int k=0;k<i;k++){
				figli.add(null);
			}
			figli.add(i-1,figlio);
		}
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

	public List<String> getInformazioniFigliInterni() {// restituisce le informazioni dei figli interni
		List<String> informazioni = new ArrayList<>();// crea una lista di stringhe
		for (Nodo_m_ario figlio : figli) {// per ogni figlio
			if (!figlio.isFoglia()) {// se non è una foglia
				informazioni.add(figlio.getInformazione());// aggiunge l'informazione alla lista
			}
		}
		return informazioni;
	}

	public boolean isFoglia() {// controlla se il nodo è una foglia
		if(this!=null)
			return figli.isEmpty();// se la lista dei figli è vuota ritorna true
		return true;
	}

	

}
