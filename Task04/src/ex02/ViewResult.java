package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ex01.Item2d;

/**
 * ViewResult class that implements the View interface and manages the
 * collection of Item2d objects.
 */
public class ViewResult implements View {

    /**
     * Default number of values to compute.
     */
    private static final int DEFAULT_NUM = 10;

    /**
     * File name used for serialization.
     */
    private static final String FILE_NAME = "Save.bin";

    /**
     * Collection of argument and result items.
     */
    public ArrayList<Item2d> items = new ArrayList<>();

    /**
     * Constructor that creates the items collection with the default number of
     * items.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Constructor that creates the items collection with the given number of
     * items.
     *
     * @param n The number of items to create.
     */
    public ViewResult(int n) {
        for (int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /**
     * Returns the items collection.
     *
     * @return The items collection.
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    /**
     * Implements the viewBody method of the View interface.
     *
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @return
     */
    public double calculateSinAverage(double arg1, double arg2, double arg3, double arg4) {
        double sin1 = Math.sin(Math.toRadians(arg1));
        double sin2 = Math.sin(Math.toRadians(arg2));
        double sin3 = Math.sin(Math.toRadians(arg3));
        double sin4 = Math.sin(Math.toRadians(arg4));
        return Math.round(1000 * (sin1 + sin2 + sin3 + sin4) / 4.0);
    }

    /**
     * Обрахунок кількості одиниць
     *
     * @param arg1 the arg1
     * @param arg2 the arg2
     * @param arg3 the arg3
     * @param arg4 the arg4
     * @return int
     */
    public int calculateOnesCount(double arg1, double arg2, double arg3, double arg4) {
        double sinAverage = calculateSinAverage(arg1, arg2, arg3, arg4);
        int integerPart = (int) Math.floor(sinAverage);
        String binaryString = Integer.toBinaryString(integerPart);
        int onesCount = (int) binaryString.chars().filter(c -> c == '1').count();
        return onesCount;
    }
    
    public void init() {
        for (Item2d item : items) {
            item.setArg1(Math.round(Math.random() * 360));
            item.setArg2(Math.round(Math.random() * 360));
            item.setArg3(Math.round(Math.random() * 360));
            item.setArg4(Math.round(Math.random() * 360));
            item.setSinAverage(calculateSinAverage(item.getArg1(), item.getArg2(), item.getArg3(), item.getArg4()));
            item.setOnesOut(calculateOnesCount(item.getArg1(), item.getArg2(), item.getArg3(), item.getArg4()));
        }
    }

    /**
     * Implements the viewInit method of the View interface.
     */
    @Override
    public void viewInit() {
        init();
    }

    /**
     * Implements the viewSave method of the View interface.
     */
    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            os.writeObject(items);
            os.flush();
        }
    }

    /**
     * Implements the viewRestore method of the View interface.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            items = (ArrayList<Item2d>) ois.readObject();
        }
    }

    /**
     * Implements the viewHeader method of the View interface.
     */
    @Override
    public void viewHeader() {
        System.out.println("View Header");
    }

    /**
     * Implementation of the {@linkplain View#viewBody()}<br> method
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for (Item2d item : items) {
            System.out.printf("[%.0f; %.0f; %.0f; %.0f; %.2f; %.0f]\n", item.getArg1(), item.getArg2(), item.getArg3(), item.getArg4(), item.getSinAverage(), item.getOnesOut());
        }
        System.out.println();
    }

    /**
     * Implements the viewFooter method of the View interface.
     */
    @Override
    public void viewFooter() {
        System.out.println("View Footer");
    }

    /**
     * Implements the viewShow method of the View interface.
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
        System.out.println();
    }
}
