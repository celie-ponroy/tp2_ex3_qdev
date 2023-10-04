import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class fct_trisTest {

    private Etudiant etu1, etu2, etu3;
    private Formation formation1;

    private Groupe groupe;

    @BeforeEach
    void setUp() throws InvalidIDexception, NoteInvalideException {

        //---------------------------------------- etudiant 1
        this.formation1= new Formation("BUT informatique");

        this.etu1=new Etudiant("001", "Jean", "Bon",formation1);

        //---------------------------------------- etudiant 2

        this.etu2=new Etudiant("002", "Alain", "Terrieur",formation1);

        //---------------------------------------- etudiant 3
        this.etu3=new Etudiant("003","Sarah","Croche",formation1);

        groupe = new Groupe(formation1);

        groupe.ajouter(etu1);
        groupe.ajouter(etu2);
        groupe.ajouter(etu3);

    }

    /**
     * test si la note entrée est dans listeNotes
     * @throws NoteInvalideException
     */
    @Test
    public void trisAlpha() throws NoteInvalideException {
    groupe.triAlpha();
        System.out.println(this.groupe);
    }

    @Test
    public void trisAntiAlpha() throws NoteInvalideException {
        groupe.triAntiAlpha();
        System.out.println(this.groupe);
    }

    @Test
    public void print() throws NoteInvalideException {
        System.out.println(this.groupe);
    }

}