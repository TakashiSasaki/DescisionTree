package com.gmail.takashi316.DescisionTree;

import java.util.Comparator;

public class DividedItemsComparator implements Comparator<DividedItems> {
	@Override
	public int compare(DividedItems o1, DividedItems o2) {
		if (o1.entropyGain > o2.entropyGain)
			return +1;
		if (o1.entropyGain < o2.entropyGain)
			return -1;
		return 0;
	}
}
