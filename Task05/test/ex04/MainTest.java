package ex04;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex02.ViewResult;

public class MainTest {

    /** Checking the {@linkplain ChangeItemCommand#execute()} method */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        Item2d item = new Item2d();
        double arg1 = 2.0;
        double arg2 = 3.0;
        double arg3 = 4.0;
        double arg4 = 5.0;
        double offset = 2.0;

        item.setArgs(arg1, arg2, arg3, arg4);
        cmd.setItem(item);
        cmd.setOffset(offset);
        cmd.execute();

        double expectedArg1 = arg1 * offset;
        double expectedArg2 = arg2 * offset;
        double expectedArg3 = arg3 * offset;
        double expectedArg4 = arg4 * offset;

        assertEquals(expectedArg1, item.getArg1(), .1e-10);
        assertEquals(expectedArg2, item.getArg2(), .1e-10);
        assertEquals(expectedArg3, item.getArg3(), .1e-10);
        assertEquals(expectedArg4, item.getArg4(), .1e-10);
    }


    /**
     * Class check {@linkplain ChangeConsoleCommand}
     */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }

}
