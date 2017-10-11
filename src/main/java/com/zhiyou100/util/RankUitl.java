package com.zhiyou100.util;

public class RankUitl {
	
	private static float[] Sone = {1,0.9f,0.9f,0.9f,1,1,0.9f};
	private static float[] Stwo = {0.9f,0.8f,0.9f,0.9f,0.9f,0.9f,0.8f};
	private static float[] Sthree = {0.8f,0.7f,0.9f,0.8f,0.8f,0.7f,0.7f};
	
	private static float[] one = {0.6f,0.5f,0.7f,0.6f,0.7f,0.7f,0.6f};
	private static float[] two = {0.5f,0.4f,0.5f,0.5f,0.6f,0.6f,0.4f};
	private static float[] three = {0.4f,0.3f,0.5f,0.4f,0.5f,0.5f,0.4f};
	private static float[] four = {0.3f,0.2f,0.5f,0.2f,0.3f,0.3f,0.2f};
	

	public static int getRank(Float shape, Float color, Float purity, Float liquorColor, Float aroma, Float taste, Float leaf){
		
		
		float[] a = {shape,color,purity,liquorColor,aroma,taste,leaf};
		
		float[] ranks = Ranks(a);
		
		int big = getMax(ranks);
		
		return (big+1);
		
	}
	
	public static float Similarity(float[] a,float[]b){
		
		float up = 0;
		float down = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			float sum1 = 0;
			float sum2 = 0;
				
			sum1 = (a[i]>b[i])?b[i]:a[i];
			
			sum2 = a[i] + b[i];
			
			up+=sum1;
			down+=sum2;
		}
		
		return (2*up)/down;
	}
	
	
	public static float[] Ranks(float[] a){
		
		float a1 = Similarity(a,Sone);
		float a2 = Similarity(a,Stwo);
		float a3 = Similarity(a,Sthree);
		float a4 = Similarity(a,one);
		float a5 = Similarity(a,two);
		float a6 = Similarity(a,three);
		float a7 = Similarity(a,four);
		
		float[] ranks = {a1,a2,a3,a4,a5,a6,a7};
		
		return ranks;
	}
	
	
	public static int getMax(float[] arr){
		
		int big = 0;
		
		float max=arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			if(arr[i]>max){
				
				max=arr[i];
				
				big = i;
			}
		}
		
		return big;
	}
}




