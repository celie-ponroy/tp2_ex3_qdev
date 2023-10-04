import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class fct_trisTest {

    //déclarations des attributs
    private Etudiant etu1, etu2, etu3;
    private Formation formation1;

    private Groupe groupe;

    /**
     * Etat initial
     * @throws InvalidIDexception
     * @throws NoteInvalideException
     */
    @BeforeEach
    void setUp() throws InvalidIDexception, NoteInvalideException {

        this.formation1= new Formation("BUT informatique");

        this.formation1.add("Code",40);
        this.formation1.add("Mathématiques",20);
        this.formation1.add("Reseau",35);

        //---------------------------------------- etudiant 1

        this.etu1=new Etudiant("001", "Jean", "Bon",formation1);
        this.etu1.adjNote(12.5,"Code");

        //---------------------------------------- etudiant 2

        this.etu2=new Etudiant("002", "Alain", "Terrieur",formation1);
        this.etu2.adjNote(19.0,"Code");

        //---------------------------------------- etudiant 3
        this.etu3=new Etudiant("003","Sarah","Croche",formation1);
        this.etu3.adjNote(13.0,"Code");

        groupe = new Groupe(formation1);
        groupe.ajouter(etu1);
        groupe.ajouter(etu2);
        groupe.ajouter(etu3);

    }

    /**
     * test si le triage par ordre alphabétique fonctionne
     * @throws NoteInvalideException
     */
    @Test
    public void trisAlpha() {
    groupe.triAlpha();
        System.out.println(this.groupe);
    }

    /**
     * test si le triage par ordre anti alphabétique fonctionne
     * @throws NoteInvalideException
     */
    @Test
    public void trisAntiAlpha() {
        groupe.triAntiAlpha();
        System.out.println(this.groupe);
    }

    /**
     * test si le triage par mérite fonctionne
     * @throws NoteInvalideException
     */
    @Test
    public void triParMerite()  {
        groupe.triParMerite();
        System.out.println(this.groupe);
    }

    /**
     * Affichage de la situation initial
     * @throws NoteInvalideException
     */
    @Test
    public void print() {
        System.out.println(this.groupe);
    }
}