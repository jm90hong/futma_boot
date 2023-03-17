package com.futma.futma_boot.controller;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float totalStar=4.3f;
		int reviewCnt=10;
		int oneStar =5;
		
		float r = ((totalStar*reviewCnt)+oneStar)/(reviewCnt+1);
		System.out.println(Math.round(r*10)/10.0);
	}

}
