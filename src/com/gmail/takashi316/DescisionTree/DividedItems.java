package com.gmail.takashi316.DescisionTree;

public class DividedItems {
	public DividedItems(Items items, int attribute, int threshold) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).attributeValues[attribute] >= threshold) {
				largerOrEqualItem.add(items.get(i));
			} else {
				smallerItem.add(items.get(i));
			}
		}
	}

	public Items largerOrEqualItem = new Items();
	public Items smallerItem = new Items();
}
