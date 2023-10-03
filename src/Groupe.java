import java.util.TreeSet;

public class Groupe {
    private Formation formation;
    private TreeSet<Etudiant> listEtu ;//formation etudiant

    Groupe(Formation fomation){
        this.formation = fomation;
        this.listEtu = new TreeSet<Etudiant>();
    }
    public void ajouter(Etudiant etudiant){
        if(etudiant.getFormation() == this.formation){
            listEtu.add(etudiant);
        }
    }
    public void supprimer(Etudiant etudiant){
            listEtu.remove(etudiant);
    }

}
