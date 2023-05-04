//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328
import java.util.ArrayList;

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
	
	
	
	
}
