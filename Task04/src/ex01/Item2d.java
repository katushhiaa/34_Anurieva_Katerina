package ex01;

import java.io.Serializable;


 /**
 * The class Item2d implements serializable
 */ 
public class Item2d implements Serializable {

    private double arg1;
    private double arg2;
    private double arg3;
    private double arg4;
    private double SinAverage;
    private double OnesOut;


/** 
 *
 * Item2d
 *
 * @return public
 */
    public Item2d() { 

        arg1 = .0;
        arg2 = .0;
        arg3 = .0;
        arg4 = .0;
        SinAverage = .0;
        OnesOut = .0;
    }


/** 
 *
 * Item2d
 *
 * @param arg1  the arg1. 
 * @param arg2  the arg2. 
 * @param arg3  the arg3. 
 * @param arg4  the arg4. 
 * @return public
 */
    public Item2d(double arg1, double arg2, double arg3, double arg4) { 

        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
    }


/** 
 *
 * Gets the arg1
 *
 * @return the arg1
 */
    public double getArg1() { 

        return arg1;
    }


/** 
 *
 * Sets the arg1
 *
 * @param arg1  the arg1. 
 */
    public void setArg1(double arg1) { 

        this.arg1 = arg1;
    }


/** 
 *
 * Gets the arg2
 *
 * @return the arg2
 */
    public double getArg2() { 

        return arg2;
    }


/** 
 *
 * Sets the arg2
 *
 * @param arg2  the arg2. 
 */
    public void setArg2(double arg2) { 

        this.arg2 = arg2;
    }


/** 
 *
 * Gets the arg3
 *
 * @return the arg3
 */
    public double getArg3() { 

        return arg3;
    }


/** 
 *
 * Sets the arg3
 *
 * @param arg3  the arg3. 
 */
    public void setArg3(double arg3) { 

        this.arg3 = arg3;
    }


/** 
 *
 * Gets the arg4
 *
 * @return the arg4
 */
    public double getArg4() { 

        return arg4;
    }


/** 
 *
 * Sets the arg4
 *
 * @param arg4  the arg4. 
 */
    public void setArg4(double arg4) { 

        this.arg4 = arg4;
    }


/** 
 *
 * Sets the sin average
 *
 * @param SinAvr  the sin avr. 
 * @return double
 */
    public double setSinAverage(double SinAvr) { 

        return this.SinAverage = SinAvr;
    }


/** 
 *
 * Gets the sin average
 *
 * @return the sin average
 */
    public double getSinAverage() { 

        return SinAverage;
    }


/** 
 *
 * Sets the ones output
 *
 * @param OneOut  the one output. 
 * @return double
 */
    public double setOnesOut(double OneOut) { 

        return this.OnesOut = OneOut;
    }


/** 
 *
 * Gets the ones output
 *
 * @return the ones output
 */
    public double getOnesOut() { 

        return OnesOut;
    }


/** 
 *
 * Sets the args
 *
 * @param arg1  the arg1. 
 * @param arg2  the arg2. 
 * @param arg3  the arg3. 
 * @param arg4  the arg4. 
 * @return Item2d
 */
    public Item2d setArgs(double arg1, double arg2, double arg3, double arg4) { 

        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        return this;
    }

    @Override

/** 
 *
 * To string
 *
 * @return String
 */
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

/** 
 *
 * Hash code
 *
 * @return int
 */
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
