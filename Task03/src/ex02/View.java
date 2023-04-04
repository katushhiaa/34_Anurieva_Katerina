package ex02;

import java.io.IOException;

/**
 * Product (Factory Method Design Pattern)<br>
 * Interface of "fabricated" objects<br>
 * Declares object rendering methods
 *
 */
public interface View {

    /**
     * Displays title
     */
    public void viewHeader();

    /**
     * Displays the main part
     */
    public void viewBody();

    /**
     * Отображает окончание
     */
    public void viewFooter();

    /**
     * Displays ending
     */
    public void viewShow();

    /**
     * Performs initialization
     */
    public void viewInit();

    /**
     * Saves data for later recovery
     *
     * @throws java.io.IOException
     * @throwsjava.io.IOException
     */
    public void viewSave() throws IOException;

    /**
     * Restores previously saved data
     * @throws java.lang.Exception
     * @throwsjava.lang.Exception
     */
    public void viewRestore() throws Exception;
}
