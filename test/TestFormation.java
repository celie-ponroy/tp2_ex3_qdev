import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestFormation {
    private Formation f1 ,f2,f2bis;

    @BeforeEach
    public void ini(){
        f1=new Formation("FPP");
        f2=new Formation("INFO");
        f2.add("C++",3.0);
        f2bis = new Formation("INFO");
        f2bis.add("C++",3.0);
    }

    @Test
    public void test_add_null(){
        f1.add(null,0.0);
        assertEquals(f1, new Formation("FPP"));
    }
    @Test
    public void test_add_ok(){
        f1.add("Arc-en-ciel",2.0);
        assertEquals(f1.getCoef("Arc-en-ciel"), 2.0);
    }
    @Test
    public void test_delecte_OK(){
        f2.delete("C++");
        assertEquals(f2,new Formation("INFO"));
    }
    @Test
    public void test_delecte_null(){
        f2.delete(null);
        assertEquals(f2,f2bis);
    }
    @Test
    public void test_delecte_notin(){
        f2.delete("Arc-en-ciel");
        assertEquals(f2,f2bis);
    }
    @Test
    public void test_getCoef_notin(){
        assertEquals(-1,f2.getCoef("poupipou2"));
    }
    @Test
    public void test_getCoef_in(){
        assertEquals(3.0,f2.getCoef("C++"));
    }

    @Test
    public void test_getCoef_null(){
        assertEquals(-1,f2.getCoef(null));
    }

}
