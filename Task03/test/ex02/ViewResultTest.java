package ex02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The class View result test
 */
public class ViewResultTest {

    ViewResult viewResult;

    @Before

    /**
     * Sets the up
     */
    public void setUp() {

        viewResult = new ViewResult(2);
        viewResult.viewInit();
    }

    /**
     * Test calculate ones count
     */
    @Test
    public void testCalculateOnesCount() {

        int expected1 = Integer.bitCount((int) viewResult.calculateMean(viewResult.getItems().get(0).getArg1(), viewResult.getItems().get(0).getArg2(), viewResult.getItems().get(0).getArg3(), viewResult.getItems().get(0).getArg4()));
        int expected2 = Integer.bitCount((int) viewResult.calculateMean(viewResult.getItems().get(1).getArg1(), viewResult.getItems().get(1).getArg2(), viewResult.getItems().get(1).getArg3(), viewResult.getItems().get(1).getArg4()));
        assertEquals(expected1, viewResult.calculateOnesCount(viewResult.getItems().get(0).getArg1(), viewResult.getItems().get(0).getArg2(), viewResult.getItems().get(0).getArg3(), viewResult.getItems().get(0).getArg4()));
        assertEquals(expected2, viewResult.calculateOnesCount(viewResult.getItems().get(1).getArg1(), viewResult.getItems().get(1).getArg2(), viewResult.getItems().get(1).getArg3(), viewResult.getItems().get(1).getArg4()));
    }

    @Test

    /**
     *
     * Test view save
     *
     */
    public void testRestore() {

        try {
            viewResult.viewSave();
        } catch (IOException e) {
        }
        ArrayList<Item2d> items = viewResult.getItems();
        ViewResult viewResult1 = new ViewResult(items.size());
        try {
            viewResult1.viewRestore();
        } catch (Exception e) {
        }
        ArrayList<Item2d> items1 = viewResult1.getItems();
        assertEquals(items.size(), items1.size());
        for (int i = 0; i < items.size(); i++) {
            assertEquals(items.get(i).getArg1(), items1.get(i).getArg1(), 0.1);
            assertEquals(items.get(i).getArg2(), items1.get(i).getArg2(), 0.1);
            assertEquals(items.get(i).getArg3(), items1.get(i).getArg3(), 0.1);
            assertEquals(items.get(i).getArg4(), items
                    .get(i).getArg4(), 0.1);
        }
    }
}
