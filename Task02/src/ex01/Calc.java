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

    private static final String FILENAME = "Save.bin";
    private double result;
    private double arg1;
    private double arg2;
    private double arg3;
    private double arg4;

    /**
     *
     * Sets the result
     *
     * @param result the result
     */
    public void setResult(double result) {

        this.result = result;
    }

    /**
     * Gets the result
     * @return the result
     */
    public double getResult() {

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
     */
    public void init(double arg1, double arg2, double arg3, double arg4) {

        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        setResult(calculateSinAverage(arg1, arg2, arg3, arg4));
    }

    /**
     * Show
     */
    public void show() {

        int count = calculateOnesCount(arg1, arg2, arg3, arg4);
        int integerPart = (int) Math.floor(getResult());
        String binaryString = Integer.toBinaryString(integerPart);
        System.out.println("Середній синус: " + getResult());
        System.out.println("Ціла частина середнього значення: " + integerPart);
        System.out.println("Двійкове представлення цілої частини: " + binaryString);
        System.out.println("Число одиниць у двійковому представленні середнього значення: " + count);
    }

    /**
     * Save
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
    public void restore() throws IOException, ClassNotFoundException {

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME))) {
            result = (double) is.readObject();
        }
    }
}
