import java.util.HashMap;
import java.util.Objects;

/**
 * Classe formation : représente une formation (idFormation : identifiant de la formation, listeMatiere : HashMap<matiere -> coeff> )
 */
public class Formation {
    /**
     * déclarations des attributs
     */
    private String idFormation;
    private HashMap <String, Double> listeMatiere;

    /**
     * Constructeur Vide
     */
    Formation(String id){
        this.idFormation =id;
        this.listeMatiere =new HashMap <String, Double>();
    }

    /**
     * méthode equals : compare l'élement courant à celui en paramètre et vérifie si ce sont les mêmes
     * @param o object to be compared for equality with this map
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Formation formation = (Formation) o;
        return Objects.equals(idFormation, formation.idFormation) && Objects.equals(listeMatiere, formation.listeMatiere);
    }

    /**
     * méthode hashCode : indexe les key
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idFormation, listeMatiere);
    }

    /**
     * méthode add : ajoute une matiere -> coefficient
     * @param matiere
     * @param coeff
     */
    public void add(String matiere, double coeff){
        if(matiere!=null && coeff >0)
            this.listeMatiere.put(matiere,coeff);
    }

    /**
     * méthode delete : permet de supprimer une maitere -> coefficient à la formation
     * @param matiere
     */
    public void delete(String matiere){
        if(this.listeMatiere !=null && this.listeMatiere.containsKey(matiere))
            this.listeMatiere.remove(matiere);
    }

    /**
     * méthode get : return le coefficient de la matière en paramètre
     * @param matiere
     * @return
     */

    public double getCoef(String matiere){
        double res = -1;
        if(matiere!=null && this.listeMatiere.containsKey(matiere))
            res= (double)this.listeMatiere.get(matiere);
        return res;
    }

    /**
     * méthode getListeMatiere : renvoie la liste des matiere
     * @return
     */
    public HashMap getListeMatiere(){
        return this.listeMatiere;
    }

    @Override
    public String toString() {
        return "Formation : "+this.idFormation;
    }
}
