package ex01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import static org.junit.Assert.fail;


/*
 * The class Calc test
 */
public class MainTest {

    private static final double DELTA = 0.001;

    @Test
    /*
     * Test calculate sin average
     */
    public void testCalculateSinAverage() {
        Calc calc = new Calc();
        double result = calc.calculateSinAverage(90, 90, 90, 90);
        assertEquals(1000, result, DELTA);
    }

    @Test
    /*
     * Test calculate ones count
     */
    public void testCalculateOnesCount() {
        Calc calc = new Calc();
        int result = calc.calculateOnesCount(90, 90, 90, 90);
        assertEquals(6, result);
    }

    @Test
    /*
     * Test init
     */
    public void testInit() {
        Calc calc = new Calc();
        calc.init(90, 90, 90, 90);
        Item2d result = calc.getResult();
        assertEquals(new Item2d(90,90,90, 90), result);
    }

    @Test
    /**
     * Test save and restore
     */
    public void testSaveAndRestore() throws Exception {
        Calc calc = new Calc();
        calc.init(90, 90, 90, 90);
        try {
            calc.save();
            calc.init(90, 90, 90, 90);
            calc.restore();
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not have been thrown");
        }
        Item2d result = calc.getResult();
        assertEquals(new Item2d(90,90,90, 90), result);
    }
}