import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class EtudiantTest {
    
    private Etudiant etu1, etu2, etu3;
    private Formation formation1, formation2;

    @BeforeEach
    void setUp() throws InvalidIDexception, NoteInvalideException {

        //---------------------------------------- etudiant 1
        this.formation1= new Formation("BUT informatique");

        this.etu1=new Etudiant("001", "Jean", "Bon",formation1);

        this.formation1.add("Code",40);
        this.formation1.add("Mathématiques",20);
        this.formation1.add("Reseau",35);

        //---------------------------------------- etudiant 2
        this.formation2= new Formation("Medecine");

        this.etu2=new Etudiant("002", "Alain", "Terrieur",formation2);

        this.formation2.add("Chimie",20);
        this.formation2.add("Biologie",20);

        this.etu2.adjNote(12.0,"Biologie");
        this.etu2.adjNote(13.0,"Biologie");
        this.etu2.adjNote(13.5,"Chimie");

        //---------------------------------------- etudiant 3
        this.etu3=new Etudiant("003","Sarah","Croche",null);

    }

    /**
     * test si la note entrée est dans listeNotes
     * @throws NoteInvalideException
     */
    @Test
    public void ajouterNote_test1() throws NoteInvalideException {

        this.etu1.adjNote(12.4,"Code");
        assertEquals(12.4,this.etu1.getListNotes().get("Code").get(0),"La note pour Code doit être de 12.4");
    }

    /**
     * test lorsque la note entrée pour une matiere n ne se fait pas quand n n'est pas dans la formation d'étudiant
     */
    @Test
    public void ajouterNote_test2() throws NoteInvalideException {
        this.etu1.adjNote(4.1,"Philosophie");
        assertEquals(null,this.etu1.getListNotes().get("Philosophie"),"Dervait retourner null car Philosophie n'est pas dans la formation de etu1");
    }

    /**
     * test lorsque la note n'est pas dans l'intervalle [0,20]
     */
    @Test
    public void ajouterNote_test3() throws NoteInvalideException {

        Exception exception = assertThrows(NoteInvalideException.class, () -> {
            this.etu1.adjNote(1000000.0, "Code");
        });

        String exceptedMessage = "Note invalide";
        String actualMessage = exceptedMessage.toString();

        assertTrue(actualMessage.contains(exceptedMessage));
    }

    /**
     *
     */
    @Test
    public void calculMoy_test1(){
        Double res=this.etu2.calculMoy("Biologie");
        System.out.println(etu2);
        assertEquals(12.5,res,"La moyenne de etu2 en biologie devrait etre de 12.5");
    }

    @Test
    public void calculMoy_test2(){
        Double res=this.etu2.calculMoy("Inconnu");
        System.out.println(etu2);
        assertEquals(-1.0,res,"La moyenne de etu2 est inconnu");
    }
}