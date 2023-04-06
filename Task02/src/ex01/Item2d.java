package ex01;

import java.io.Serializable;

public class Item2d implements Serializable {

    private double arg1;
    private double arg2;
    private double arg3;
    private double arg4;
    private double SinAverage;
    private double OnesOut;

    public Item2d() {
        arg1 = .0;
        arg2 = .0;
        arg3 = .0;
        arg4 = .0;
        SinAverage = .0;
        OnesOut = .0;
    }

    public Item2d(double arg1, double arg2, double arg3, double arg4) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
    }

    public double getArg1() {
        return arg1;
    }

    public void setArg1(double arg1) {
        this.arg1 = arg1;
    }

    public double getArg2() {
        return arg2;
    }

    public void setArg2(double arg2) {
        this.arg2 = arg2;
    }

    public double getArg3() {
        return arg3;
    }

    public void setArg3(double arg3) {
        this.arg3 = arg3;
    }

    public double getArg4() {
        return arg4;
    }

    public void setArg4(double arg4) {
        this.arg4 = arg4;
    }

    public double setSinAverage(double SinAvr) {
        return this.SinAverage = SinAvr;
    }

    public double getSinAverage() {
        return SinAverage;
    }

    public double setOnesOut(double OneOut) {
        return this.OnesOut = OneOut;
    }

    public double getOnesOut() {
        return OnesOut;
    }

    public Item2d setArgs(double arg1, double arg2, double arg3, double arg4) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        return this;
    }

    @Override
    public String toString() {
        return "Arguments: " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item2d item2d = (Item2d) o;
        return Double.compare(item2d.arg1, arg1) == 0
                && Double.compare(item2d.arg2, arg2) == 0
                && Double.compare(item2d.arg3, arg3) == 0
                && Double.compare(item2d.arg4, arg4) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.arg1) ^ (Double.doubleToLongBits(this.arg1) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.arg2) ^ (Double.doubleToLongBits(this.arg2) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.arg3) ^ (Double.doubleToLongBits(this.arg3) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.arg4) ^ (Double.doubleToLongBits(this.arg4) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.SinAverage) ^ (Double.doubleToLongBits(this.SinAverage) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.OnesOut) ^ (Double.doubleToLongBits(this.OnesOut) >>> 32));
        return hash;
    }
}
