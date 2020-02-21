package com.udemy.udemyJava;

public class PaintJob {

	public static void main(String[] args) {
		//System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
		//System.out.println(getBucketCount(7.25, 4.3, 2.35));
		System.out.println(getBucketCount(6.26, 2.2));
	}
	
	public static int getBucketCount(double width,double height,double areaPerBucket,int extraBuckets){
		if(width<=0 || height<=0 || areaPerBucket<=0 || extraBuckets<0){
			return -1;
		}
		else{
			double totalArea=width*height;
			System.out.println(totalArea);
			double bucket=totalArea/areaPerBucket;
			double bucketRequired=bucket-extraBuckets;
			System.out.println(bucket+"==="+bucketRequired);
			return (int) Math.ceil(bucketRequired);
		}
	}
	
	public static int getBucketCount(double width,double height,double areaPerBucket){
		if(width<=0 || height<=0 || areaPerBucket<=0){
			return -1;
		}
		else{
			double totalArea=width*height;
			System.out.println(totalArea);
			double bucketRequired=totalArea/areaPerBucket;
			System.out.println(bucketRequired);
			return (int) Math.ceil(bucketRequired);
		}
	}
	
	public static int getBucketCount(double area,double areaPerBucket){
		if(area<=0 || areaPerBucket<=0){
			return -1;
		}
		else{
			return (int) Math.ceil(area/areaPerBucket);
		}
	}
}
