package ex03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import ex01.Item2d;
import org.junit.Assert;


 /**
 * The class View table test
 */ 
public class ViewTableTest {

    @Test

/** 
 *
 * Test calc
 *
 */
    public void testCalc() { 

        ViewTable tbl = new ViewTable(10, 5);
        assertEquals(10, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());
        tbl.init(40, 90.0);
        Item2d item = new Item2d();
        // set the value arg1 of the first element in the list
        item.setArg1(tbl.getItem(0).getArg1()); 
        // set the value arg2 of the first element in the list
        item.setArg2(tbl.getItem(0).getArg2()); 
        // set the value arg3 of the first element in the list
        item.setArg3(tbl.getItem(0).getArg3()); 
        // set the value arg4 of the first element in the list
        item.setArg4(tbl.getItem(0).getArg4());
        // set the value SinAverage of the first element in the list
        item.setSinAverage(tbl.getItem(0).getSinAverage()); 
        // set the value OnesOut of the first element in the list
        item.setOnesOut(tbl.getItem(0).getOnesOut()); 
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(0) + ">",
                tbl.getItems().get(0).equals(item));
    }

    @Test

/** 
 *
 * Test restore
 *
 */
    public void testRestore() { 

        ViewTable tbl1 = new ViewTable(10, 1000);
        ViewTable tbl2 = new ViewTable();
        // Calculate the value of the function with a random increment of the argument
        tbl1.init(30, Math.random() * 100.0);
        // Save the collection tbl1.items
        try {
            tbl1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }       
        // Load the tbl2.items collection
        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        // Must load as many elements as saved
        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());     
        // And these elements must be equal.
        // To do this, you need to define the equals method
        assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
    }
}
