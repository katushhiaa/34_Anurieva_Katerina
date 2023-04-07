package ex05;

import java.util.concurrent.TimeUnit;
import ex02.ViewResult;
import ex04.Command;

/**
 * The task used by the thread handler; worker thread pattern
 *
 * @seeCommand
 * @seeCommandQueue
 */
public class MaxCommand implements Command /* , Runnable */ {
	/** Stores the result of processing the collection*/
	private int result = -1;
	/** Result ready flag */
	private int progress = 0;
	/** Serves a collection of objects {@linkplain ex01.Item2d} */
	private ViewResult viewResult;

	/**
	 * Returns a field {@linkplain MaxCommand#viewResult}
	 * 
	 * @return value {@linkplain MaxCommand#viewResult}
	 */
	public ViewResult getViewResult() {
		return viewResult;
	}

        /**
        * Sets the field {@linkplain MaxCommand#viewResult}
        *
        * @param viewResult value for {@linkplain MaxCommand#viewResult}
        * @return new value {@linkplain MaxCommand#viewResult}
        */
	public ViewResult setViewResult(ViewResult viewResult) {
		return this.viewResult = viewResult;
	}

        /**
        * Initializes the field {@linkplain MaxCommand#viewResult}
        *
        * @param viewResult class object {@linkplain ViewResult}
        */
	public MaxCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}

        /**
        * Returns the result
        *
        * @return field {@linkplain MaxCommand#result}
        */

	public int getResult() {
		return result;
	}

        /**
        * Checks the readiness of the result
        *
        * @return false - if the result is found, otherwise - true
        * @see MaxCommand#result
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
		System.out.println("Max executed...");
		int size = viewResult.getItems().size();
		result = 0;
		for (int idx = 1; idx < size; idx++) {
			if (viewResult.getItems().get(result).getArg1() < viewResult.getItems().get(idx).getArg1()) {
				result = idx;
			}
			progress = idx * 100 / size;
			if (idx % (size / 3) == 0) {
				System.out.println("Max " + progress + "%");
			}
			try {
				TimeUnit.MILLISECONDS.sleep(3000 / size);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		System.out.println("Max done. Item #" + result + " found: " + viewResult.getItems().get(result));
		progress = 100;
	}
}