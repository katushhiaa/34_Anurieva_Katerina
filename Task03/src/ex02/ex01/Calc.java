package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The class Calc implements serializable
 */
public class Calc implements Serializable {

    static final String FILENAME = "Save.bin";
    private Item2d result;

    /**
     *
     * Sets the result
     *
     * @param result the result
     */
    public void setResult(Item2d result) {

        this.result = result;
    }

    public Calc() {
        result = new Item2d();
    }

    /**
     * Gets the result
     *
     * @return the result
     */
    public Item2d getResult() {

        return result;
    }

    /**
     * Обрахунок середнього значення 1000*sin(α)
     *
     * @param arg1 the arg1
     * @param arg2 the arg2
     * @param arg3 the arg3
     * @param arg4 the arg4
     * @return double
     */
    public double calculateSinAverage(double arg1, double arg2, double arg3, double arg4) {
        double sin1 = Math.sin(Math.toRadians(arg1));
        double sin2 = Math.sin(Math.toRadians(arg2));
        double sin3 = Math.sin(Math.toRadians(arg3));
        double sin4 = Math.sin(Math.toRadians(arg4));
        return 1000 * (sin1 + sin2 + sin3 + sin4) / 4.0;
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

    /**
     *
     * Init
     *
     * @param arg1 the arg1
     * @param arg2 the arg2
     * @param arg3 the arg3
     * @param arg4 the arg4
     * @return
     */
    public double init(double arg1, double arg2, double arg3, double arg4) {
        result.setArg1(arg1);
        result.setArg2(arg2);
        result.setArg3(arg3);
        result.setArg4(arg4);
        result.setSinAverage(calculateSinAverage(arg1, arg2, arg3, arg4));
        result.setOnesOut(calculateOnesCount(arg1, arg2, arg3, arg4));
        return result.getSinAverage();
    }

    /**
     * Show
     */
    public void show() {
        int count = (int) result.getOnesOut();
        int integerPart = (int) Math.floor(result.getSinAverage());
        String binaryString = Integer.toBinaryString(integerPart);
        System.out.println("Середній синус: " + result.getSinAverage());
        System.out.println("Ціла частина середнього значення: " + integerPart);
        System.out.println("Двійкове представлення цілої частини: " + binaryString);
        System.out.println("Число одиниць у двійковому представленні середнього значення: " + count);
    }

    /**
     * Save
     *
     * @throws IOException
     */
    public void save() throws IOException {

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            os.writeObject(result);
            os.flush();
        }
    }

    /**
     * Restore
     *
     * @param { the {
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void restore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME))) {
            result = (Item2d) is.readObject();
        }
    }
}
