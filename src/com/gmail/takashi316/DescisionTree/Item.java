package com.gmail.takashi316.DescisionTree;

public class Item {
	public int[] attributeValues;
	public int classId;

	public Item(int[] attribute_values, int class_id) {
		this.attributeValues = attribute_values;
		this.classId = class_id;
	}

	public Item(int[] attribute_values_and_class_id) {
		attributeValues = new int[attribute_values_and_class_id.length - 1];
		for (int i = 0; i < attributeValues.length; ++i) {
			attributeValues[i] = attribute_values_and_class_id[i];
		}
		classId = attribute_values_and_class_id[attribute_values_and_class_id.length - 1];
	}
}
