package ex04;

import ex01.Item2d;

/**
 * Team Change item; command pattern
 *
 */
public class ChangeItemCommand implements Command {
        /** Processed object; command pattern */
	private Item2d item;
	/** Command parameter; command pattern */
	private double offset;
	
        /**
        * Set field {@linkplain ChangeItemCommand#item}
        *
        * @param item value for {@linkplain ChangeItemCommand#item}
        * @return new value {@linkplain ChangeItemCommand#item}
        */
	public Item2d setItem(Item2d item) {
		return this.item = item;
	}

        /**
        * Returns the field {@linkplain ChangeItemCommand#item}
        *
        * @return value {@linkplain ChangeItemCommand#item}
        */
	public Item2d getItem() {
		return item;
	}

        /**
        * Set field {@linkplain ChangeItemCommand#offset}
        *
        * @param offset value for {@linkplain ChangeItemCommand#offset}
        * @return new value {@linkplain ChangeItemCommand#offset}
        */
	public double setOffset(double offset) {
		return this.offset = offset;
	}

        /**
        * Returns the field {@linkplain ChangeItemCommand#offset}
        *
        * @return value {@linkplain ChangeItemCommand#offset}
        */
	public double getOffset() {
		return offset;
	}

	@Override
	public void execute() {
		item.setArg1(item.getArg1()* offset);
		item.setArg2(item.getArg2()* offset);
		item.setArg3(item.getArg3()* offset);
		item.setArg4(item.getArg4()* offset);
                item.setSinAverage(item.getSinAverage()* offset);
                item.setOnesOut(item.getOnesOut()* offset);
	}
}