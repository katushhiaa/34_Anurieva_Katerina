package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;

/**
 * The task used by the thread handler; worker thread pattern
 *
 * @seeCommand
 * @seeCommandQueue
 */
public class MinMaxCommand implements Command /* , Runnable */ {

    /**
     * Stores the result of processing the collection
     */
    private int resultMin = -1;
    /**
     * Stores the result of processing the collection
     */
    private int resultMax = -1;
    /**
     *Result ready flag
     */
    private int progress = 0;
    /**
     * Serves a collection of objects {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Return field {@linkplain MinMaxCommand#viewResult}
     *
     * @return value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Set field {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult value for {@linkplain MinMaxCommand#viewResult}
     * @return new value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Initializes the field {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Return result 
     *
     * @return field {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Return result
     *
     * @return field {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * Checks the readiness of the result
     *
     * @return false - if the result is found, otherwise - true
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Used by the thread handler {@linkplain CommandQueue}; worker template
     *Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getArg1() < 0) {
                if ((resultMax == -1) || (viewResult.getItems().get(resultMax).getArg1() < item.getArg1())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) || (viewResult.getItems().get(resultMin).getArg1() > item.getArg1())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: "
                    + String.format("%.2f.", viewResult.getItems().get(resultMin).getArg1()));
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: "
                    + String.format("%.2f.", viewResult.getItems().get(resultMax).getArg1()));
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }
}
