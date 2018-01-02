package individualProject;

import java.util.HashMap;

public class WordCountReviews {
	
	public HashMap<String, Integer[]> wordCount;
	public String[][] reviews;
	
	public WordCountReviews(HashMap<String, Integer[]> wordCount, String[][] reviews){
		this.wordCount = wordCount;
		this.reviews = reviews;
	}

}
