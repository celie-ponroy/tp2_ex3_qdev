import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class EtudiantTest {
    private Etudiant etu1, etu2, etu3;

    @BeforeEach
    void setUp() throws InvalidIDexception {

        

        this.etu1=new Etudiant("001", "Jean", "Bon");
        this.etu2=new Etudiant("002", "Alain", "Terrieur");
        this.etu3=new Etudiant("003","Sarah","Croche");

    }

    @Test
    public void ajouterNote_test1() throws NoteInvalideException {
        this.etu1.adjNote(12.4,"NSI");
        assertEquals(this.etu1.getListNotes().get("NSI").get(0),12.4,"La note pour NSI doit être de 12.4");
    }

    public void ajouterNote_test2

}