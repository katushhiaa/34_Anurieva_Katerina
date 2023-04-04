package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
    private ArrayList<Item2d> items = new ArrayList<>();

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
    public int calculateOnesCount(double arg1, double arg2, double arg3, double arg4) {
        double mean = calculateMean(arg1, arg2, arg3, arg4);
        int intPart = (int) mean;
        int onesCount = Integer.bitCount(intPart);
        return onesCount;
    }

    public double calculateMean(double arg1, double arg2, double arg3, double arg4) {
        return (1000 * Math.sin(arg1) + 1000 * Math.sin(arg2) + 1000 * Math.sin(arg3) + 1000 * Math.sin(arg4)) / 4;
    }

    /**
     * Implements the viewInit method of the View interface.
     */
    @Override
    public void viewInit() {
        for (Item2d item : items) {
            item.setArg1(Math.random() * 360);
            item.setArg2(Math.random() * 360);
            item.setArg3(Math.random() * 360);
            item.setArg4(Math.random() * 360);
        }
    }

    /**
     * Implements the viewSave method of the View interface.
     */
    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(items);
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
            double arg1 = item.getArg1();
            double arg2 = item.getArg2();
            double arg3 = item.getArg3();
            double arg4 = item.getArg4();
            double mean = calculateMean(arg1, arg2, arg3, arg4);
            int intPart = (int) mean;
            String binaryString = Integer.toBinaryString(intPart);
            int count = Integer.bitCount(intPart);
            System.out.println("Середній синус: " + mean);
            System.out.println("Ціла частина середнього значення: " + intPart);
            System.out.println("Двійкове представлення цілої частини: " + binaryString);
            System.out.println("Число одиниць у двійковому представленні середнього значення: " + count);
            item.setResult(count);
        }
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
    }
}