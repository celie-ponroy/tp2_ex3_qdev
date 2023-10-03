import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Etudiant implements Comparable {

    private Identite identite ;
    private Formation formation;
    private HashMap <String, ArrayList<Double>> listNotes ;//matière notes

    Etudiant(String nip , String nom , String prenom , Formation formation) throws InvalidIDexception {
        this.listNotes = new HashMap <String, ArrayList<Double>>();
        this.identite = new Identite(nip, nom, prenom);
        this.formation = formation;
    }

    /*ajouter une note à un étudiant dans une matière donnée (la note doit être entre 0 et
    20), que faire si la note n’est pas dans le bon intervalle ou/et si la matière n’est
    pas dans la formation de l’étudiant ?*/

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

    public HashMap<String, ArrayList<Double>> getListNotes() {
        return listNotes;
    }


    @Override
    public String toString() {
        return "Etudiant{" +
                "identite=" + identite +
                ", formation=" + formation +
                ", listNotes=" + listNotes +
                '}';
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


}
