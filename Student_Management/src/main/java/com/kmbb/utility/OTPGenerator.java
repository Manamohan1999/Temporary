package com.kmbb.utility;

import java.util.Random;

public class OTPGenerator {
	public static int getOTP() {
		Random rad=new Random();
		int num=10000000+rad.nextInt(90000000);
		System.out.println(num);
		return num;
	}
}

