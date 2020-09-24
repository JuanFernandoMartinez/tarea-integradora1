package comparators;

import java.util.Comparator;

import model.Order;

public class OrderComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		if (o1.getRestaurantNit().compareTo(o2.getRestaurantNit())==1) {
			return -1;
		}else if (o1.getRestaurantNit().compareTo(o2.getRestaurantNit())==-1) {
			return 1;
		}else if (o1.getRestaurantNit().compareTo(o2.getRestaurantNit())==0) {
			if (o1.getClientCode().compareTo(o2.getClientCode()) == 1) {
				return 1;
			}else if (o1.getClientCode().compareTo(o2.getClientCode()) == -1) {
				return -1;
			}else if (o1.getClientCode().compareTo(o2.getClientCode()) == 0) {
				if (o1.getDate().compareTo(o2.getDate()) == 1) {
					return -1;
				}else if (o1.getDate().compareTo(o2.getDate()) == -1) {
					return 1;
				}else if(o1.getDate().compareTo(o2.getDate()) == 0) {
					if (o1.getCode().compareTo(o2.getCode()) == 1) {
						return -1;
					}else if (o1.getCode().compareTo(o2.getCode()) == -1) {
						return 1;
					}else if (o1.getCode().compareTo(o2.getCode()) == 0) {
						return 0;
					}
				}
			}
		}
		return 0;
	}

	

}
