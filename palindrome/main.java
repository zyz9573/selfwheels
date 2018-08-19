import Manacher.Manacher;
public class main {
    public static void main(String[] args) {
    	Manacher demo = new Manacher();
    	System.out.println(demo.findLongestPalidromeWord("abcdzdcab"));
    	System.out.println(demo.findLongestPalidromeWord("abaabc"));
    }
}