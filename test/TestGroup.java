import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroup {
    private Groupe groupe;
    private Etudiant etudiant1, etu2,etu3;

    @BeforeEach
    public void ini() throws InvalidIDexception {
        Formation formation = new Formation("Info");
        this.groupe=new Groupe(formation);
        this.etudiant1 = new Etudiant("0","Arcelin ","Nino", formation);
        this.etu2 = new Etudiant("01","Ponroy","Célie",new Formation("philo"));

    }

    @Test
    public void test_ajouter_ok(){
        this.groupe.ajouter(etudiant1);
        assertEquals(true,this.groupe.getListEtu().contains(etudiant1));
    }

    @Test
    public void test_ajouter_formationdifferent(){
        this.groupe.ajouter(etu2);
        assertEquals(false,this.groupe.getListEtu().contains(etu2));
    }
    @Test
    public void test_supprimer_ok(){
        this.groupe.ajouter(etudiant1);
        assertEquals(true,this.groupe.getListEtu().contains(etudiant1));
        this.groupe.supprimer(etudiant1);
        assertEquals(false,this.groupe.getListEtu().contains(etudiant1));
    }

    @Test
    public void test_supprimer_listevide(){
        this.groupe.supprimer(etudiant1);
        assertEquals(0,this.groupe.getListEtu().size());
    }


}
