import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestFormation {
    private Formation f1;

    @BeforeEach
    public void ini(){
        f1=new Formation("FPP");
    }

    @Test
    public void test_add_null(){
        f1.add(null,0.0);
        assertEquals(f1, new Formation("FPP"));
    }

}
