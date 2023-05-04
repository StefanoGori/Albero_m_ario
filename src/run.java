//Nome e cognome: Stefano Gori Matricola: 7113622
//Nome e cognome: Michele Coppi Matricola: 7113252
//Nome e cognome: Niccolò Saggese Matricola: 7113328
import java.util.ArrayList;
public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Albero_m_ario Albero=new Albero_m_ario(3);
		Nodo_m_ario Nodo=new Nodo_m_ario("ciao",null,null);
		
		Albero.addRoot(Nodo);
		ArrayList<Nodo_m_ario> tree = Albero.getTree();
		for (int i = 0; i < tree.size(); i++) {
			System.out.println(tree.get(i).getInfo());
		}

	}

}
