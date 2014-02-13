package com.gmail.takashi316.DescisionTree;

public class DividedItems {
	public double entropyBeforeDivision;
	public double entropyOfLargerOrEqualItems;
	public double entropyOfSmallerItems;
	public double entropyAfterDivision;
	public int attribute;
	public int threshold;
	public double entropyGain;

	public DividedItems(Items items) {
		smallerItems = items;
		largerOrEqualItems = null;
	}

	public DividedItems(Items items, int attribute, int threshold) {
		this.attribute = attribute;
		this.threshold = threshold;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).attributeValues[attribute] >= threshold) {
				largerOrEqualItems.add(items.get(i));
			} else {
				smallerItems.add(items.get(i));
			}
		}
		entropyBeforeDivision = items.getClasses().getEntropy();
		entropyOfLargerOrEqualItems = largerOrEqualItems.getClasses()
				.getEntropy();
		entropyOfSmallerItems = smallerItems.getClasses().getEntropy();
		entropyAfterDivision = (entropyOfLargerOrEqualItems
				* largerOrEqualItems.size() + entropyOfSmallerItems
				* smallerItems.size())
				/ items.size();
		entropyGain = entropyBeforeDivision - entropyAfterDivision;
	}

	public Items largerOrEqualItems = new Items();
	public Items smallerItems = new Items();

	public String toString() {
		return "attribute=" + this.attribute + " threshold=" + this.threshold
				+ " entropyGain=" + entropyGain;
	}
}
