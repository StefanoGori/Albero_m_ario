//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

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
	
	
	
}
