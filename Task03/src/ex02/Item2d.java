package ex02;

import java.io.Serializable;

/**
 * The class Item2d implements serializable
 */
public class Item2d implements Serializable {

    private double arg1;
    private double arg2;
    private double arg3;
    private double arg4;

    /**
     * Item2d
     */
    public Item2d() {
    }

    public Item2d(double arg1, double arg2, double arg3, double arg4) {

        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
    }

    /**
     * Gets the arg1
     * @return the arg1
     */
    public double getArg1() {

        return arg1;
    }

    /**
     * Sets the arg1
     * @param arg1 the arg1
     */
    public void setArg1(double arg1) {

        this.arg1 = arg1;
    }

    /**
     * Gets the arg2
     * @return the arg2
     */
    public double getArg2() {

        return arg2;
    }

    /**
     * Sets the arg2
     * @param arg2 the arg2
     */
    public void setArg2(double arg2) {

        this.arg2 = arg2;
    }

    /**
     * Gets the arg3
     * @return the arg3
     */
    public double getArg3() {

        return arg3;
    }

    /**
     * Sets the arg3
     * @param arg3 the arg3
     */
    public void setArg3(double arg3) {

        this.arg3 = arg3;
    }

    /**
     * Gets the arg4
     * @return the arg4
     */
    public double getArg4() {

        return arg4;
    }

    /**
     * Sets the arg4
     * @param arg4 the arg4
     */
    public void setArg4(double arg4) {

        this.arg4 = arg4;
    }

    @Override

    /**
     * To string
     * @return String
     */
    public String toString() {

        return "Arguments: " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4;
    }

    /**
     * Calculates the number of ones in the binary representation of the integer
     * part of the average value of 1000*sin(α) for the four input arguments.
     *
     * @return The number of ones in the binary representation of the integer
     * part of the average value of 1000*sin(α).
     */
    public int calculateBinaryOnes() {
        double average = (1000 * Math.sin(arg1) + 1000 * Math.sin(arg2) + 1000 * Math.sin(arg3) + 1000 * Math.sin(arg4)) / 4.0;
        int integerPart = (int) average;
        String binaryString = Integer.toBinaryString(integerPart);
        int count = 0;
        for (char ch : binaryString.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }


void setResult(double result) {
}
}