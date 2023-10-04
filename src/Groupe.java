import java.util.*;

public class Groupe {
    private Formation formation;
    private ArrayList<Etudiant> listEtu ;//formation etudiant

    Groupe(Formation fomation){
        this.formation = fomation;
        this.listEtu = new ArrayList<>();
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

        System.out.println("-1-------------"+tempList);
        Collections.sort(tempList,Collections.reverseOrder());
        System.out.println("-2-------------"+tempList);

        listEtu.clear();
        System.out.println("-3-------------"+listEtu);
        listEtu.addAll(tempList);
        System.out.println("-4-------------"+listEtu);
    }
}
