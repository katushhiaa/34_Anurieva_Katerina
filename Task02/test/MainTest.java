import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import ex01.Calc;
import static org.junit.Assert.fail;


 /**
 * The class Main test
 */ 
public class MainTest {

    private static final double DELTA = 0.001;

    @Test

/** 
 * Test calculate sin average
 */
    public void testCalculateSinAverage() { 

        Calc calc = new Calc();
        double result = calc.calculateSinAverage(90, 90, 90, 90);
        assertEquals(1000, result, DELTA);
    }

    @Test

/** 
 * Test calculate ones count
 */
    public void testCalculateOnesCount() { 

        Calc calc = new Calc();
        int result = calc.calculateOnesCount(90, 90, 90, 90);
        assertEquals(6, result);
    }

    @Test

/** 
 * Test init
 */
    public void testInit() { 

        Calc calc = new Calc();
        calc.init(90, 90, 90, 90);
        double result = calc.getResult();
        assertEquals(1000, result, DELTA);
    }

    @Test

/** 
 * Test save and restore
 */
    public void testSaveAndRestore() { 

        Calc calc = new Calc();
        calc.init(90, 90, 90, 90);
        try {
            calc.save();
            calc.init(91, 91, 91, 91);
            calc.restore();
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not have been thrown");
        }
        double result = calc.getResult();
        assertEquals(1000, result, DELTA);
    }
}
