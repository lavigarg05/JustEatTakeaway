package com.jet.framework.utilities;

import java.util.List;
import java.util.Map;

public class Calculations {

	public double calculateCartAmount(List<Double> priceList,List<Integer> foodItemCount) {
		double total=0.0;
		for(int i=0;i<foodItemCount.size();i++) {
			total=total+(priceList.get(i)*foodItemCount.get(i));
		}
		return total;
	}
}
