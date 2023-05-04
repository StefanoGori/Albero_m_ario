//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328

import java.util.ArrayList;

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
	
}
