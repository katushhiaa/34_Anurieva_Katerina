/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import static org.junit.Assert.fail;

public class MainTest {

    private static final double DELTA = 0.001;

    @Test
    public void testCalculateSinAverage() {
        Calc calc = new Calc();
        double result = calc.calculateSinAverage(0, 90, 180, 270);
        assertEquals(1000, result, DELTA);
    }

    @Test
    public void testCalculateOnesCount() {
        Calc calc = new Calc();
        int result = calc.calculateOnesCount(0, 90, 180, 270);
        assertEquals(5, result);
    }

    @Test
    public void testInit() {
        Calc calc = new Calc();
        calc.init(0, 90, 180, 270);
        double result = calc.getResult();
        assertEquals(1000, result, DELTA);
    }

    @Test
    public void testSaveAndRestore() {
        Calc calc = new Calc();
        calc.init(0, 90, 180, 270);
        try {
            calc.save();
            calc.init(1, 91, 181, 271);
            calc.restore();
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not have been thrown");
        }
        double result = calc.getResult();
        assertEquals(1000, result, DELTA);
    }
}