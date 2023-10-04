import java.util.*;

public class Groupe {
    //déclarations des attributs
    private Formation formation;
    private ArrayList<Etudiant> listEtu ;//formation etudiant

    /**
     * Constructeur
     * @param fomation
     */
    Groupe(Formation fomation){
        this.formation = fomation;
        this.listEtu = new ArrayList<>();
    }

    /**
     * méthode ajouter : permet d'ajouter un étudiant au groupe
     * @param etudiant
     */
    public void ajouter(Etudiant etudiant){
        if(etudiant != null){
            if(etudiant.getFormation() == this.formation){
                listEtu.add(etudiant);
            }
        }
    }

    /**
     * méthode supprimer : permet de supprimer un étudiant du groupe
     * @param etudiant
     */
    public void supprimer(Etudiant etudiant){
            listEtu.remove(etudiant);
    }

    /**
     * méthode getListeEtu : permet de récuperer l'ensemble des étudiants de la formation
     * @return
     */
    public ArrayList<Etudiant> getListEtu() {
        return listEtu;
    }

    @Override
    public String toString() {
        String res="Groupe : "+this.formation+"\n";
        for(Etudiant e : listEtu)
            res+= e+"\n";

        return res;
    }

    /**
     * méthode triAlpha : tris en ordre alphabérique
     */
    public void triAlpha(){

        List<Etudiant> tempList = new ArrayList<>(listEtu);
        System.out.println("-1-------------"+tempList);
        Collections.sort(tempList);
        System.out.println("-2-------------"+tempList);

        listEtu.clear();
        listEtu.addAll(tempList);
    }

    /**
     * méthode triAntiAlpha : permet de trier dans ordre alpabérique décroissant
     */
    public void triAntiAlpha(){

        List<Etudiant> tempList = new ArrayList<>(listEtu);

        Collections.sort(tempList,Collections.reverseOrder());

        listEtu.clear();
        listEtu.addAll(tempList);
    }

    /**
     * méthode calculMoyGenerale : permet de calculer la moyenne général d'un élève
     * @return
     */
    public double calculMoyGenerale(){
        double res = 0.0;
        for (Etudiant e: listEtu) {
            res+= e.calculMoyGenerale();
        }
        return  res/listEtu.size();
    }

    /**
     * méthode calculMoy : permet de calculer la moyenne de chaque élève pour un matière donnée
     * @param matiere
     * @return
     */
    public double calculMoy(String matiere) {
        double res = 0.0;
        for (Etudiant e: listEtu) {
            res+= e.calculMoy(matiere);
        }
        return  res/listEtu.size();
    }


    /**
     * méthode triParMerite : permet de trier les élèves selon leurs notes
     */
    public void triParMerite(){
        TreeSet<Etudiant> triParMerite = new TreeSet<Etudiant>((etu1, etu2) -> Double.compare(etu2.calculMoyGenerale(), etu1.calculMoyGenerale()));
        triParMerite.addAll(this.listEtu);
        this.listEtu = new ArrayList<Etudiant>(triParMerite);
    }
}
