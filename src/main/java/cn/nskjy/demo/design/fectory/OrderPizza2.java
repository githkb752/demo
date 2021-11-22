package cn.nskjy.demo.design.fectory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OrderPizza2 {

	Pizz pizza = null;
	String orderType = "";
	// 构造器
	public OrderPizza2() {
		
		do {
			orderType = getType();
			pizza = PizzFactory.createPizz(orderType);
			String.join(" ", new ArrayList<>());

			// 输出pizza
			if (pizza != null) { // 订购成功
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println(" 订购披萨失败 ");
				break;
			}
		} while (true);
	}

	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
