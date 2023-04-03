
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Calc implements Serializable {

    private static final String FILENAME = "Save.bin";
    private double result;
    private double arg1;
    private double arg2;
    private double arg3;
    private double arg4;

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public double calculateSinAverage(double arg1, double arg2, double arg3, double arg4) {
        double sin1 = Math.sin(Math.toRadians(arg1));
        double sin2 = Math.sin(Math.toRadians(arg2));
        double sin3 = Math.sin(Math.toRadians(arg3));
        double sin4 = Math.sin(Math.toRadians(arg4));
        return 1000 * (sin1 + sin2 + sin3 + sin4) / 4.0;
    }

    public int calculateOnesCount(double arg1, double arg2, double arg3, double arg4) {
        double sinAverage = calculateSinAverage(arg1, arg2, arg3, arg4);
        int integerPart = (int) Math.floor(sinAverage);
        String binaryString = Integer.toBinaryString(integerPart);
        int onesCount = (int) binaryString.chars().filter(c -> c == '1').count();
        return onesCount;
    }

    public void init(double arg1, double arg2, double arg3, double arg4) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.arg4 = arg4;
        setResult(calculateSinAverage(arg1, arg2, arg3, arg4));
    }

    public void show() {
        int count = calculateOnesCount(arg1, arg2, arg3, arg4);
        int integerPart = (int) Math.floor(getResult());
        String binaryString = Integer.toBinaryString(integerPart);
        System.out.println("Середній синус: " + getResult());
        System.out.println("Ціла частина середнього значення: " + integerPart);
        System.out.println("Двійкове представлення цілої частини: " + binaryString);
        System.out.println("Число одиниць у двійковому представленні середнього значення: " + count);
    }

    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            os.writeObject(result);
            os.flush();
        }
    }

    /**
     * Restores the current result of the calculation from a saved file.
     *
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME))) {
            result = (double) is.readObject();
        }
    }
}

