package com.coderising.array;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class ArrayUtil {
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return leon1900
	 */
	public void reverseArray(int[] origin){
		for (int i = 0; i < origin.length/2; i++) {
			int temp =  origin[origin.length-1-i];
			origin[origin.length-1-i] = origin[i];
			origin[i] = temp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return leon1900
	 */
	public int[] removeZero(int[] oldArray){
		int size = 0;
		for (int i = 0; i < oldArray.length; i++) {
			if(oldArray[i] !=0 ){
				size++;
			}
		}
		int [] newArray = new int [size]; 
		for (int i = 0,j = 0; i < oldArray.length; i++) {
			if(oldArray[i]!=0){
				newArray[j++] = oldArray[i];
			}
		}
		return newArray;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return leon1900
	 */
	
	public int[] merge(int[] array1, int[] array2){
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < array1.length; i++) {
			ts.add(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			ts.add(array2[i]);
		}
		int size = ts.size();
		int[] newArr = new int[size];
		int i = 0;
		for (Integer integer : ts) {
			newArr[i++] = integer;
		}
		return newArr;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return leon1900
	 */
	public int[] grow(int [] oldArray,  int size){
		int newsize = oldArray.length+size;
		int [] newArr = new int[newsize];
		for (int i = 0; i < oldArray.length; i++) {
			newArr[i] = oldArray[i];
		}
		return newArr;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return leon1900
	 */
	public int[] fibonacci(int max){
		int size = 1;
		while(fun(size)<max){
			size++;
		}
		int [] arr = new int [size-1];
		for (int j=0,i = 1; i < max; i++) {
			if(fun(i)<max){
				arr[j++] = fun(i);
			}else {
				return arr;
			}
		}
		return null;
	}
	
	/**
	 * 求给定数的斐波拉契数
	 * @param max
	 * @return leon1900
	 */
	private int fun(int n) {
		if(n==1||n==2){
			return 1;
		}else {
			return fun(n-1)+fun(n-2);
		}
	}

	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return leon1900
	 */
	public int[] getPrimes(int max){
		int size = 0;
		for (int i = 1; i < max; i++) {
			if(primeNumber(i)){
				size++;
			}
		}
		int []arr = new int[size];
		for (int j=0,i = 1; i < max; i++) {
			if(primeNumber(i)){
				arr[j++]=i;
			}
		}
		return arr;
	}
	
	/**
	 * 判断是否为素数
	 * @param num
	 * @return leon1900
	 */
	public boolean primeNumber(int num){
		boolean flag = true;
		if(num==1) flag = false;
			for (int j = 2; j <= num/2; j++) {
				if(num % j == 0){
					flag = false;
					break;
				}
		}
		return flag;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		int size=0;
		for (int i = 1; i < max; i++) {
			if(perfectNumber(i)){
				size++;
			}
		}
		int[] arr = new int[size];
		for (int j=0,i = 1; i < max; i++) {
			if(perfectNumber(i)){
				arr[j++] = i;
			}
		}
		return arr;
	}
	
	public boolean perfectNumber(int num){
		boolean flag = false;
		int sum = 0;
		//完数 除了1 跟本身的因子
		for (int i = 1; i <= num/2; i++) {
			if(num%i==0){
				sum+=i;
			}
		}
		if(sum==num)
			flag =true;
		return flag;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return leon1900
	 */
	public String join(int[] array, String seperator){
		StringBuilder sBuilder =new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if(i==array.length-1){
				sBuilder.append(array[i]);
			}else{
				sBuilder.append(array[i]+seperator);
			}
		}
		return sBuilder.toString();
	}
	

}
