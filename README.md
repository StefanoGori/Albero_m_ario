# Albero_m_ario

Ecco un'implementazione in Java delle classi "NodoM-ario" e "AlberoM-ario" che soddisfano i requisiti richiesti:

java
Copy code
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodoM_ario {
    private String informazione;
    private List<NodoM_ario> figli;

    public NodoM_ario(String informazione) {
        this.informazione = informazione;
        this.figli = new ArrayList<>();
    }

    public String getInformazione() {
        return informazione;
    }

    public void setInformazione(String informazione) {
        this.informazione = informazione;
    }

    public List<NodoM_ario> getFigli() {
        return figli;
    }

    public void aggiungiFiglio(NodoM_ario figlio) {
        figli.add(figlio);
    }

    public boolean rimuoviFiglio(NodoM_ario figlio) {
        return figli.remove(figlio);
    }

    public int getNumeroNodiInterni() {
        int count = 0;
        for (NodoM_ario figlio : figli) {
            if (!figlio.isFoglia()) {
                count++;
            }
        }
        return count;
    }

    public List<String> getInformazioniFigliInterni() {
        List<String> informazioni = new ArrayList<>();
        for (NodoM_ario figlio : figli) {
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

class AlberoM_ario {
    private int arietà;
    private NodoM_ario radice;

    public AlberoM_ario(int arietà) {
        this.arietà = arietà;
        this.radice = null;
    }

    public NodoM_ario inserisciRadice(String informazione) {
        radice = new NodoM_ario(informazione);
        return radice;
    }

    public NodoM_ario inserisciNuovoNodo(NodoM_ario padre, String informazione, int indice) {
        NodoM_ario nuovoNodo = new NodoM_ario(informazione);
        List<NodoM_ario> figli = padre.getFigli();
        if (indice >= 1 && indice <= figli.size() + 1) {
            figli.add(indice - 1, nuovoNodo);
        }
        return nuovoNodo;
    }

    public NodoM_ario inserisciNuovaRadice(String informazione) {
        NodoM_ario nuovaRadice = new NodoM_ario(informazione);
        nuovaRadice.aggiungiFiglio(radice);
        radice = nuovaRadice;
        return radice;
    }

    public List<String> visitaInProfondita() {
        List<String> informazioni = new ArrayList<>();
        visitaInProfonditaHelper(radice, informazioni);
        return informazioni;
    }

    private void visitaInProfonditaHelper(NodoM_ario nodo, List<String> informazioni) {
        if (nodo != null) {
            informazioni.add(nodo.getInformazione());
            for (NodoM_ario figlio : nodo.getFigli()) {
                visitaInProfonditaHelper(figlio, informazioni);
            }
        }
    }

    public List<String> visitaPerLivelli() {
        List<String> informazioni = new ArrayList




User
puoi riscrivere tutta la classe Albero_m_ario?
ChatGPT
Certamente! Ecco la classe AlberoM_ario riscritta:

java
Copy code
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NodoM_ario {
    private String informazione;
    private List<NodoM_ario> figli;

    public NodoM_ario(String informazione) {
        this.informazione = informazione;
        this.figli = new ArrayList<>();
    }

    public String getInformazione() {
        return informazione;
    }

    public void setInformazione(String informazione) {
        this.informazione = informazione;
    }

    public List<NodoM_ario> getFigli() {
        return figli;
    }

    public void aggiungiFiglio(NodoM_ario figlio) {
        figli.add(figlio);
    }

    public boolean rimuoviFiglio(NodoM_ario figlio) {
        return figli.remove(figlio);
    }

    public int getNumeroNodiInterni() {
        int count = 0;
        for (NodoM_ario figlio : figli) {
            if (!figlio.isFoglia()) {
                count++;
            }
        }
        return count;
    }

    public List<String> getInformazioniFigliInterni() {
        List<String> informazioni = new ArrayList<>();
        for (NodoM_ario figlio : figli) {
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

class AlberoM_ario {
    private int arietà;
    private NodoM_ario radice;

    public AlberoM_ario(int arietà) {
        this.arietà = arietà;
        this.radice = null;
    }

    public NodoM_ario inserisciRadice(String informazione) {
        radice = new NodoM_ario(informazione);
        return radice;
    }

    public NodoM_ario inserisciNuovoNodo(NodoM_ario padre, String informazione, int indice) {
        NodoM_ario nuovoNodo = new NodoM_ario(informazione);
        List<NodoM_ario> figli = padre.getFigli();
        if (indice >= 1 && indice <= figli.size() + 1) {
            figli.add(indice - 1, nuovoNodo);
        }
        return nuovoNodo;
    }

    public NodoM_ario inserisciNuovaRadice(String informazione) {
        NodoM_ario nuovaRadice = new NodoM_ario(informazione);
        nuovaRadice.aggiungiFiglio(radice);
        radice = nuovaRadice;
        return radice;
    }

    public List<String> visitaInProfondita() {
        List<String> informazioni = new ArrayList<>();
        visitaInProfonditaHelper(radice, informazioni);
        return informazioni;
    }

    private void visitaInProfonditaHelper(NodoM_ario nodo, List<String> informazioni) {
        if (nodo != null) {
            informazioni.add(nodo.getInformazione());
            for (NodoM_ario figlio : nodo.getFigli()) {
                visitaInProfonditaHelper(figlio, informazioni);
            }
        }
    }

    public List<String> visitaPerLivelli() {
        List<String> informazioni = new ArrayList<>();
        if (radice != null) {
            Queue<NodoM_ario> c




User
puoi continuare a scrivere dopo il metodo visitaInProfonditaHelper?
ChatGPT
Certamente! Ecco il resto della classe AlberoM_ario:

java
Copy code
            Queue<NodoM_ario> coda = new LinkedList<>();
            coda.offer(radice);

            while (!coda.isEmpty()) {
                NodoM_ario nodo = coda.poll();
                informazioni.add(nodo.getInformazione());

                for (NodoM_ario figlio : nodo.getFigli()) {
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

    private int getNumeroNodiInterniHelper(NodoM_ario nodo) {
        int count = 0;

        for (NodoM_ario figlio : nodo.getFigli()) {
            count += figlio.isFoglia() ? 0 : 1;
            count += getNumeroNodiInterniHelper(figlio);
        }

        return count;
    }

    public int getNumeroFigliInterni(NodoM_ario nodo) {
        int count = 0;

        for (NodoM_ario figlio : nodo.getFigli()) {
            if (!figlio.isFoglia()) {
                count++;
            }
        }

        return count;
    }

    public List<String> getInformazioniFigliInterni(NodoM_ario nodo) {
        List<String> informazioni = new ArrayList<>();

        for (NodoM_ario figlio : nodo.getFigli()) {
            if (!figlio.isFoglia()) {
                informazioni.add(figlio.getInformazione());
            }
        }

        return informazioni;
    }

    public String getContenutoNodo(NodoM_ario nodo) {
        return nodo.getInformazione();
    }

    public void setContenutoNodo(NodoM_ario nodo, String informazione) {
        nodo.setInformazione(informazione);
    }

    public NodoM_ario getRadice() {
        return radice;
    }

    public NodoM_ario getPadre(NodoM_ario nodo) {
        return cercaPadre(radice, nodo);
    }

    private NodoM_ario cercaPadre(NodoM_ario radice, NodoM_ario nodo) {
        if (radice == null || radice == nodo) {
            return null;
        }

        for (NodoM_ario figlio : radice.getFigli()) {
            if (figlio == nodo) {
                return radice;
            } else {
                NodoM_ario padre = cercaPadre(figlio, nodo);
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

    private int getNumeroFoglieHelper(NodoM_ario nodo) {
        if (nodo.isFoglia()) {
            return 1;
        }

        int count = 0;

        for (NodoM_ario figlio : nodo.getFigli()) {
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

    private int getAltezzaHelper(NodoM_ario nodo)




User
puoi continuare dal metodo getAltezzaHelper?
ChatGPT
Certamente! Ecco la continuazione del metodo getAltezzaHelper:

java
Copy code
    private int getAltezzaHelper(NodoM_ario nodo) {
        if (nodo.isFoglia()) {
            return 0;
        }

        int altezzaMax = 0;
        for (NodoM_ario figlio : nodo.getFigli()) {
            int altezzaFiglio = getAltezzaHelper(figlio);
            if (altezzaFiglio > altezzaMax) {
                altezzaMax = altezzaFiglio;
            }
        }

        return altezzaMax + 1;
    }

    public int getLivello(NodoM_ario nodo) {
        if (nodo == null) {
            return -1;
        }

        return getLivelloHelper(radice, nodo, 0);
    }

    private int getLivelloHelper(NodoM_ario radice, NodoM_ario nodo, int livello) {
        if (radice == null) {
            return -1;
        }

        if (radice == nodo) {
            return livello;
        }

        for (NodoM_ario figlio : radice.getFigli()) {
            int livelloFiglio = getLivelloHelper(figlio, nodo, livello + 1);
            if (livelloFiglio != -1) {
                return livelloFiglio;
            }
        }

        return -1;
    }

    // Metodi di utilità per la stampa
    public void stampaInformazioni() {
        System.out.println("Informazioni dell'albero:");
        stampaNodo(radice, 0);
    }

    private void stampaNodo(NodoM_ario nodo, int livello) {
        if (nodo == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < livello; i++) {
            sb.append("\t");
        }
        sb.append(nodo.getInformazione());
        System.out.println(sb.toString());

        for (NodoM_ario figlio : nodo.getFigli()) {
            stampaNodo(figlio, livello + 1);
        }
    }
}
Questa implementazione fornisce tutti i metodi richiesti nella descrizione. Puoi utilizzare il metodo main per testare l'albero m-ario:

java
Copy code
public class Main {
    public static void main(String[] args) {
        AlberoM_ario albero = new AlberoM_ario(3);

        NodoM_ario radice = albero.inserisciRadice("A");
        NodoM_ario nodoB = albero.inserisciNuovoNodo(radice, "B", 1);
        NodoM_ario nodoC = albero.inserisciNuovoNodo(radice, "C", 2);
        NodoM_ario nodoD = albero.inserisciNuovoNodo(radice, "D", 3);

        albero.inserisciNuovoNodo(nodoB, "E", 1);
        albero.inserisciNuovoNodo(nodoB, "F", 2);

        albero.inserisciNuovaRadice("X");
        albero.inserisciNuovoNodo(albero.getRadice(), "Y", 2);

        List<String> visitaProfondita = albero.visitaInProfondita();
        System.out.println("Visita in profondità: " + visitaProfondita);

        List<String> visitaLivelli = albero.visitaPerLivelli();
       




User
Puoi scrivere la classe run cioè main?
ChatGPT
Certamente! Ecco la classe Run con il metodo main che esegue un test completo dell'albero m-ario:

java
Copy code
public class Run {
    public static void main(String[] args) {
        AlberoM_ario albero = new AlberoM_ario(3);

        NodoM_ario radice = albero.inserisciRadice("A");
        NodoM_ario nodoB = albero.inserisciNuovoNodo(radice, "B", 1);
        NodoM_ario nodoC = albero.inserisciNuovoNodo(radice, "C", 2);
        NodoM_ario nodoD = albero.inserisciNuovoNodo(radice, "D", 3);

        albero.inserisciNuovoNodo(nodoB, "E", 1);
        albero.inserisciNuovoNodo(nodoB, "F", 2);

        albero.inserisciNuovaRadice("X");
        albero.inserisciNuovoNodo(albero.getRadice(), "Y", 2);

        System.out.println("Informazioni dell'albero:");
        albero.stampaInformazioni();

        List<String> visitaProfondita = albero.visitaInProfondita();
        System.out.println("Visita in profondità: " + visitaProfondita);

        List<String> visitaLivelli = albero.visitaPerLivelli();
        System.out.println("Visita per livelli: " + visitaLivelli);

        int numeroNodiInterni = albero.getNumeroNodiInterni();
        System.out.println("Numero di nodi interni: " + numeroNodiInterni);

        int numeroFigliInterni = albero.getNumeroFigliInterni(radice);
        System.out.println("Numero di figli interni della radice: " + numeroFigliInterni);

        List<String> informazioniFigliInterni = albero.getInformazioniFigliInterni(radice);
        System.out.println("Informazioni dei figli interni della radice: " + informazioniFigliInterni);

        String contenutoNodo = albero.getContenutoNodo(nodoB);
        System.out.println("Contenuto del nodo B: " + contenutoNodo);

        albero.setContenutoNodo(nodoB, "B-modificato");
        System.out.println("Contenuto del nodo B dopo la modifica: " + nodoB.getInformazione());

        NodoM_ario radiceAlbero = albero.getRadice();
        System.out.println("Radice dell'albero: " + radiceAlbero.getInformazione());

        NodoM_ario padreNodoC = albero.getPadre(nodoC);
        System.out.println("Padre del nodo C: " + padreNodoC.getInformazione());

        int numeroFoglie = albero.getNumeroFoglie();
        System.out.println("Numero di foglie dell'albero: " + numeroFoglie);

        int altezzaAlbero = albero.getAltezza();
        System.out.println("Altezza dell'albero: " + altezzaAlbero);

        int livelloNodoD = albero.getLivello(nodoD);
        System.out.println("Livello del nodo D: " + livelloNodoD);
    }
}
Eseguendo il metodo main della classe Run, verranno effettuati i test dei vari metodi implementati nella classe AlberoM_ario.
