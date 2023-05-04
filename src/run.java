//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328
import java.util.ArrayList;
public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Albero_m_ario Albero=new Albero_m_ario(3);
		Nodo_m_ario Nodo=new Nodo_m_ario("ciao",new ArrayList<Nodo_m_ario>() {{
            add(new Nodo_m_ario("bella", null));
            add(new Nodo_m_ario("buongiorno", null));
        }});	
		Nodo_m_ario Nodo2=new Nodo_m_ario("ciao2",null);
		Nodo_m_ario Nodo3=new Nodo_m_ario("ciao3",null);
		
		Albero.addRoot(Nodo);
		ArrayList<Nodo_m_ario> tree = Albero.getTree();
		Albero.newRoot(Nodo2, 2);
		Albero.newRoot(Nodo3,1);
		Albero.preorder();
		System.out.println(tree.size());
		for (int i = 0; i < tree.size(); i++) {
			System.out.println(tree.get(i).getInfo());
		}
		
	}

}
