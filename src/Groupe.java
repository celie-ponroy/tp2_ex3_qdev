import java.util.TreeSet;

public class Groupe {
    private Formation formation;
    private TreeSet<Etudiant> listEtu ;//formation etudiant

    Groupe(Formation fomation){
        this.formation = fomation;
        this.listEtu = new TreeSet<Etudiant>();
    }
    public void ajouter(Etudiant etudiant){
        if(etudiant != null){
            if(etudiant.getFormation() == this.formation){
                listEtu.add(etudiant);
            }
        }
    }
    public void supprimer(Etudiant etudiant){
            listEtu.remove(etudiant);
    }

    public Formation getFormation() {
        return formation;
    }

    public TreeSet<Etudiant> getListEtu() {
        return listEtu;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "formation=" + formation +
                ", listEtu=" + listEtu +
                '}';
    }
    public double calculMoyGenerale(){
        double res = 0.0;
        for (Etudiant e: listEtu) {
            res+= e.calculMoyGenerale();
        }
        return  res/listEtu.size();
    }
    public double calculMoy(String matiere) {
        double res = 0.0;
        for (Etudiant e: listEtu) {
            res+= e.calculMoy(matiere);
        }
        return  res/listEtu.size();
    }
}
