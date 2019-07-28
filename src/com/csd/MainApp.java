package com.csd;

public class MainApp {
	
	public static void main(String[] args) {
		
		Cal cal = new CalImpl();
		MyInvocationHandler mHandler = new MyInvocationHandler();
		Cal cal2 = (Cal)mHandler.bind(cal);
		cal2.add(2, 1);
		cal2.sub(2, 1);
		cal2.mul(2, 1);
		cal2.div(2, 1);
	}

}
