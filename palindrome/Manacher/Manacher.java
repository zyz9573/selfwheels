package Manacher;

import java.lang.StringBuilder;

public class Manacher{
	public Manacher(){}
	private String genString(String a){
		StringBuilder sb = new StringBuilder();
		for(char c : a.toCharArray()){
			sb.append('#');
			sb.append(c);
		}
		sb.append('#');
		return sb.toString();
	}
	private int findRadius(String a, int center){
		int left = center-1;
		int right = center+1;
		while(left >= 0 && right <a.length() && a.charAt(left) == a.charAt(right)){
			left--;
			right++;
		}
		return center-left-1;
	}
	public String findLongestPalidromeWord(String str){
		if(str.length()==0){return str;}
		String newStr = genString(str);
		int[] p = new int[newStr.length()];
		int cur = 0;
		int leftBoarder = 0;
		int rightBoarder = 0;
		for(int i=0;i<newStr.length();++i){
			if(2*cur - 1 >= 0 && p[2*cur-i] + i < rightBoarder){
				p[i] = p[2*cur-i];
				continue;
			}
			int r = findRadius(newStr,i);
			// System.out.print(i);
			// System.out.print(",");
			// System.out.println(r);
			cur = i;
			p[i] = r;
			leftBoarder = cur-r;
			rightBoarder = cur+r;
		}
		int max = 0;
		int c = 0;
		for(int i=0;i<p.length;++i){
			if(p[i] > max){
				max = p[i];
				c = i;
			}
		}
		// printStrAndP(newStr,p);
		return newStr.substring(c-max,c+max+1).replaceAll("#","");
	}
	private void printStrAndP(String str, int[] p){
		System.out.println(str);
		for(int num : p){
			System.out.print(num);
			System.out.print(",");
		}
		System.out.println("");
	}
}