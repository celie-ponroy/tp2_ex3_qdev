import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Etudiant implements Comparable {

    //déclarations des attributs
    private Identite identite ;
    private Formation formation;
    private HashMap <String, ArrayList<Double>> listNotes ;//matière notes

    /**
     * Constructor
     * @param nip numero de l'étudiant
     * @param nom nom de l'étudiant
     * @param prenom prénom de l'étudiant
     * @param formation formation de l'étudiant
     * @throws InvalidIDexception
     */
    Etudiant(String nip , String nom , String prenom , Formation formation) throws InvalidIDexception {
        this.listNotes = new HashMap <String, ArrayList<Double>>();
        this.identite = new Identite(nip, nom, prenom);
        this.formation = formation;
    }

    /**
     * méthode adjNote : permet d'ajouter des notes suivant une matière
     * @param note note de l'étudiant
     * @param matiere matière dans laquelle la note est encadrée
     * @throws NoteInvalideException
     */

    public void adjNote (Double note, String matiere) throws NoteInvalideException {
        if(this.formation.getListeMatiere().containsKey(matiere)) {
            if (note < 0 || note > 20) {
                throw new NoteInvalideException();
            } else {
                if (!listNotes.containsKey(matiere))
                    this.listNotes.put(matiere, new ArrayList<Double>());
                listNotes.get(matiere).add(note);
            }
        }

    }

    /**
     * méthode getListNotes : permet de renvoyer la liste des notes de l'élève
     * @return listNotes
     */
    public HashMap<String, ArrayList<Double>> getListNotes() {
        return listNotes;
    }

    /*calculer sa moyenne pour une matière, que faire si la matière n’est pas dans la
        formation de l’étudiant ?*/

    /**
     * méthode calculMoy : permet de calculer la moyenne de l'élève suivant une matière en paramètre
     * @param matiere
     * @return la moyenne de l'élève
     */
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

    /**
     * Methode qui calcule la moyenne générale de l'étudiant
     * @return sa moyenne générale
     */
    public double calculMoyGenerale(){
        Double moy = 0.0;
        for (Object matiere :formation.getListeMatiere().keySet()) {
            double coef = (double) formation.getListeMatiere().get(matiere);
            moy += this.calculMoy((String) matiere)*coef;

        }
        return moy/formation.getListeMatiere().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(identite, etudiant.identite) && Objects.equals(formation, etudiant.formation) && Objects.equals(listNotes, etudiant.listNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identite, formation, listNotes);
    }

    public Formation getFormation() {
        return formation;
    }

    @Override
    public int compareTo(Object o) {
        Etudiant etu = (Etudiant) o;
        if(this.identite.getNom() != etu.identite.getNom()){
            return (this.identite.getNom().compareTo(etu.identite.getNom()));
        }else{
            return (this.identite.getPrenom().compareTo(etu.identite.getPrenom()));
        }
    }

    @Override
    public String toString() {
        String res= "Etudiant : "+ identite +"\n"+
                 formation +
                "\nlistNotes : "+listNotes;


        return res+"\n";
    }
}
