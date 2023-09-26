import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {

    private Identite identite ;
    private HashMap <String, ArrayList<Double>> listNotes ;//matière notes

    Etudiant(String nip , String nom , String prenom ) throws InvalidIDexception {
        this.listNotes = new HashMap <String, ArrayList<Double>>();
        this.identite = new Identite(nip, nom, prenom);
    }

    /*ajouter une note à un étudiant dans une matière donnée (la note doit être entre 0 et
    20), que faire si la note n’est pas dans le bon intervalle ou/et si la matière n’est
    pas dans la formation de l’étudiant ?*/

    public void adjNote (Double note, String matiere) throws NoteInvalideException {
        if(note<0 || note>20){
            throw new NoteInvalideException();
        }
        else{
            listNotes.get(matiere).add(note);
        }

    }

    /*calculer sa moyenne pour une matière, que faire si la matière n’est pas dans la
    formation de l’étudiant ?*/
    public double calculMoy(String matiere){
        if(listNotes.containsKey(matiere)){
            Double moy = 0.0;
            for (Double note:listNotes.get(matiere)) {
                moy += note;
            }
            return moy/listNotes.get(matiere).size();
        }else {
            return -1.0;
        }

    }


}
