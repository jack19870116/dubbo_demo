package com.tiancaibao.utils;

import java.util.Random;

public class RandomUtil {
	/**
	 * 生成1~10000之间的随机整数
	 * 
	 * @return
	 */
	public static int getRandom10000() {
		int max = 10000;
		int min = 1;
		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}

	public static int getIndexList(int listSize) {
		Random random = new Random();
		return random.nextInt(listSize);
	}

	/**
	 * 获得随机四位整数
	 */
	public static int getRandomFourNumber() {
		Random ne = new Random();
		int x = ne.nextInt(9999 - 1000 + 1) + 1000;
		return x;
	}
	/**
	 *  获得随机五位整数
	 * @param args
	 */
	public static int getRandomFiveNumber(){
		return (int)((Math.random()*9+1)*10000);
	}
	/**
	 *  获得随机1 to 99
	 * @param args
	 */
	public static int getRandomOneTo99Number(){
		Random r = new Random();
		int i = r.nextInt(98)+1;
		return i;
	}
	public static void main(String[] args) {
		int randomFourNumber = RandomUtil.getRandomFourNumber();
		System.out.println(randomFourNumber);
	}
}
