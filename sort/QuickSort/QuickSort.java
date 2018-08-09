package QuickSort;

import java.lang.StringBuilder;

public class QuickSort{
	public QuickSort(){

	}
	private String toString(int[] array){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int num : array){
			sb.append(num);
			sb.append(",");
		}
		sb.setCharAt(sb.length()-1,']');
		return sb.toString();
	}
	public void printArray(int[] array){
		System.out.println(toString(array));
	}
	private void quickSort_helper(int[] array, int start, int end){
		if(start >= end){return ;}
		int pivot = array[start];
		int index_start = start;
		int index_end = end;
		while(index_start < index_end){
			if(array[index_start+1] <= pivot){
				array[index_start] = array[index_start+1];
				index_start++; 
			}
			else{
				int temp = array[index_end];
				array[index_end] = array[index_start+1];
				array[index_start+1] = temp;
				index_end--;
			}
		}
		array[index_start] = pivot;
		quickSort_helper(array,start,index_start-1);
		quickSort_helper(array,index_start+1,end);
	}
	public void quickSort(int[] array){
		quickSort_helper(array,0,array.length-1);
	}
}