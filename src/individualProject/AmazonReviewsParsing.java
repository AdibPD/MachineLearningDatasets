package individualProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AmazonReviewsParsing {
	
	private String pathOfBookReviews;
	private int sizeOfTrainingSet;
	
	public static void main(String[] args){
		new AmazonReviewsParsing();
	}
	
	public AmazonReviewsParsing(){
		pathOfBookReviews = "C:/Users/AdibPD/Downloads/Amazon book reviews/Fillian_Flynn-Gone_Girl.csv";
		String reviewsFile = getFile(pathOfBookReviews);
		String[][] reviews = parseReviewsFile(reviewsFile);
		sizeOfTrainingSet = reviews.length;
		HashMap<String, Integer[]> wordCount = createBagOfWords(reviews);
		SentimentLexicon sl = getSentimentLexicon(wordCount);
		System.out.println(sl.positiveWords.size());
		System.out.println(sl.negativeWords.size());
		
		/*
		SentimentLexicon s2 = new SentimentLexicon();
		s2.positiveWords.add("it!!");
		s2.positiveWords.add("turns!");
		s2.positiveWords.add("blown");
		s2.positiveWords.add("good!");
		s2.positiveWords.add("wow!");
		s2.positiveWords.add("amazingly");
		s2.positiveWords.add("book!");
		s2.positiveWords.add("book!!");
		s2.positiveWords.add("next!");
		s2.positiveWords.add("read!");
		s2.positiveWords.add("movie!");
		s2.positiveWords.add("brilliantly");
		s2.positiveWords.add("masterful");
		s2.positiveWords.add("awesome");
		s2.positiveWords.add("superb!");
		s2.positiveWords.add("fabulous");
		s2.positiveWords.add("it!");
		s2.positiveWords.add("wait");
		s2.positiveWords.add("wonderfully");
		s2.positiveWords.add("highly");
		s2.positiveWords.add("turner!");
		s2.positiveWords.add("incredible");
		s2.positiveWords.add("toes");
		s2.positiveWords.add("fantastic");
		s2.positiveWords.add("bed");
		s2.positiveWords.add("masterfully");
		s2.positiveWords.add("thank");
		s2.positiveWords.add("prime");
		s2.positiveWords.add("loved");
		s2.positiveWords.add("favor");
		s2.positiveWords.add("!");
		s2.positiveWords.add("blew");
		s2.positiveWords.add("excellent");
		s2.positiveWords.add("master");
		s2.positiveWords.add("time!");
		s2.positiveWords.add("chilling");
		s2.positiveWords.add("amazing");
		s2.positiveWords.add("crafting");
		s2.positiveWords.add("end!");
		s2.positiveWords.add("roller");
		s2.positiveWords.add("story!");
		s2.positiveWords.add("seat");
		s2.positiveWords.add("loves");
		s2.positiveWords.add("edge");
		s2.positiveWords.add("gift");
		s2.positiveWords.add("twice");
		s2.positiveWords.add("beautiful");
		s2.positiveWords.add("insightful");
		s2.positiveWords.add("layers");
		s2.positiveWords.add("constantly");
		s2.positiveWords.add("wow");
		s2.positiveWords.add("keeps");
		s2.positiveWords.add("night");
		s2.positiveWords.add("coaster");
		s2.positiveWords.add("pieces");
		s2.positiveWords.add("terrific");
		s2.positiveWords.add("sleep");
		s2.positiveWords.add("genius");
		s2.positiveWords.add("predict");
		s2.positiveWords.add("unpredictable");
		s2.positiveWords.add("morning");
		s2.positiveWords.add("thrilling");
		s2.positiveWords.add("reading!");
		s2.positiveWords.add("intricate");
		s2.positiveWords.add("complex");
		s2.positiveWords.add("fascinating");
		s2.positiveWords.add("funny");
		s2.positiveWords.add("immediately");
		s2.positiveWords.add("enjoys");
		s2.positiveWords.add("woven");
		s2.positiveWords.add("late");
		s2.positiveWords.add("unfolds");
		s2.positiveWords.add("minute");
		s2.positiveWords.add("love");
		s2.positiveWords.add("beautifully");
		s2.positiveWords.add("brilliant");
		s2.positiveWords.add("surface");
		s2.positiveWords.add("perfect");
		s2.positiveWords.add("witty");
		s2.positiveWords.add("till");
		s2.positiveWords.add("fast-paced");
		s2.positiveWords.add("intense");
		
		s2.negativeWords.add("waste");
		s2.negativeWords.add("poorly");
		s2.negativeWords.add("wasted");
		s2.negativeWords.add("worst");
		s2.negativeWords.add("ridiculous");
		s2.negativeWords.add("dumb");
		s2.negativeWords.add("badly");
		s2.negativeWords.add("awful");
		s2.negativeWords.add("skipped");
		s2.negativeWords.add("horrible");
		s2.negativeWords.add("worse");
		s2.negativeWords.add("depressing");
		s2.negativeWords.add("pathetic");
		s2.negativeWords.add("terrible");
		s2.negativeWords.add("stupid");
		s2.negativeWords.add("silly");
		s2.negativeWords.add("boring");
		s2.negativeWords.add("annoying");
		s2.negativeWords.add("unrealistic");
		s2.negativeWords.add("bother");
		s2.negativeWords.add("poor");
		s2.negativeWords.add("contrived");
		s2.negativeWords.add("unbelievable");
		s2.negativeWords.add("stuck");
		s2.negativeWords.add("miserable");
		s2.negativeWords.add("profanity");
		s2.negativeWords.add("implausible");
		s2.negativeWords.add("selfish");
		s2.negativeWords.add("sorry");
		s2.negativeWords.add("mistake");
		s2.negativeWords.add("unlikeable");
		s2.negativeWords.add("unlikable");
		s2.negativeWords.add("struggled");
		s2.negativeWords.add("bothered");
		s2.negativeWords.add("mess");
		s2.negativeWords.add("quit");
		s2.negativeWords.add("hated");
		s2.negativeWords.add("death");
		s2.negativeWords.add("book?");
		s2.negativeWords.add("shallow");
		s2.negativeWords.add("negative");
		s2.negativeWords.add("disliked");
		s2.negativeWords.add("cliche");
		s2.negativeWords.add("dull");
		s2.negativeWords.add("care");
		s2.negativeWords.add("really?");
		s2.negativeWords.add("annoyed");		
		s2.negativeWords.add("susped");
		s2.negativeWords.add("pass");
		s2.negativeWords.add("sadly");
		s2.negativeWords.add("cared");
		s2.negativeWords.add("skip");
		s2.negativeWords.add("holes");
		s2.negativeWords.add("stopped");
		s2.negativeWords.add("plain");
		*/
		HashMap<IntPair, Integer> coodAndOutput = getCoodAndOutput(sl, reviews);
		writeToFile(coodAndOutput);
	}
	
	private HashMap<IntPair, Integer> getCoodAndOutput(SentimentLexicon sl, String[][] reviews){
		HashMap<IntPair, Integer> coordAndOutput = new HashMap<>();
		for(int i = 0; i < reviews.length; i ++){
			int pCount = 0;
			int nCount = 0;
			
			int output = -1;
			String[] currentReview = reviews[i];
			int rating = Integer.parseInt(currentReview[0]);
			if(rating == 4 || rating == 5){
				output = 1;
			}else if(rating == 1 || rating == 2){
				output = 0;
			}else{
				continue;
			}
			
			for(int j = 3; j < currentReview.length; j++){
				String currentWord = currentReview[j];
				if(sl.positiveWords.contains(currentWord)){
					pCount += 1;
				}else if(sl.negativeWords.contains(currentWord)){
					nCount += 1;
				}
			}
			
			coordAndOutput.put(new IntPair(pCount, nCount), output);
		}
		
		return coordAndOutput;
	}
	
	private SentimentLexicon getSentimentLexicon(HashMap<String, Integer[]> wordCount){
		SentimentLexicon sl = new SentimentLexicon();
		Set<Map.Entry<String, Integer[]>> wordsAndCounts = wordCount.entrySet();
		for (Map.Entry<String,Integer[]> currentWordCount : wordsAndCounts){
			Integer[] currentCount = currentWordCount.getValue();
			String currentWord = currentWordCount.getKey();
			/*System.out.print(currentWord);
			System.out.print(currentCount[0] + " ");
			System.out.print(currentCount[1] + " ");
			System.out.print(currentCount[2] + " ");
			System.out.print(currentCount[3] + " ");
			System.out.println(currentCount[4] + " ");
			*/
			double threshold = 0.7;
			int sum = 0;
			for(int i = 0; i < 5; i++){
				sum += currentCount[i];
			}
			
			for(int i = 0; i < 5; i++){
				double cCount = currentCount[i];
				cCount = cCount / sum;
				if(i == 0){
					if(cCount >= threshold){
						sl.negativeWords.add(currentWord);
					}
				}else if(i == 4){
					if(cCount >= threshold){
						sl.positiveWords.add(currentWord);
					}
				}
			}
			
		}
		
		return sl;
	}

	
	private String[][] parseReviewsFile(String reviewsFile){
		String[] reviews = reviewsFile.split("\n");
		String[][] seperateReviews = new String[reviews.length][2];
		for(int reviewCount = 0; reviewCount < reviews.length; reviewCount++){
			String currentReview = reviews[reviewCount];
			currentReview = currentReview.replace("\"<span class=\"\"a-size-base review-text\"\">", " ").replace("</span>\"", " ");
			currentReview = currentReview.replaceAll("[.,():;<>\\[\\]\"]", " ").trim();
			String[] currentReviewSplit = currentReview.split("\\s+");
			seperateReviews[reviewCount] = currentReviewSplit;
		}
		
		return seperateReviews;
	}
	
	private HashMap<String, Integer[]> createBagOfWords(String[][] reviews){
		HashMap<String, Integer[]> wordCount = new HashMap<>();
		for(int reviewCount = 0; reviewCount < sizeOfTrainingSet; reviewCount++){
			String[] currentReviewSplit = reviews[reviewCount];
			String rating = currentReviewSplit[0];
			int ratingVal = Integer.parseInt(rating);
			for(int i = 3; i < currentReviewSplit.length; i++){
				String currentWord = currentReviewSplit[i];
				Integer[] counts = new Integer[5];
				if(wordCount.containsKey(currentWord)){
					counts = wordCount.get(currentWord);
					counts[ratingVal-1] = counts[ratingVal-1] + 1;
				}else{
					for(int j = 0; j < 5; j ++){
						if(j == ratingVal-1){
							counts[j] = 1;
						}else{
							counts[j] = 0;
						}
					}
				}
				wordCount.put(currentWord, counts);
			}
		}
		
		return wordCount;
	}
	
	private boolean writeToFile(HashMap<IntPair, Integer> data){
		Set<Map.Entry<IntPair, Integer>> dataSet = data.entrySet();
		Iterator<Entry<IntPair,Integer>> ir = dataSet.iterator();
		PrintWriter writer = null;
		try{
		    writer = new PrintWriter("C:/Users/AdibPD/Downloads/Data.txt", "UTF-8");
		} catch (IOException e) {
		   return false;
		}
		while(ir.hasNext()){
			Map.Entry<IntPair, Integer> dataPoint = ir.next();
			int x1 = dataPoint.getKey().x1;
			int x2 = dataPoint.getKey().x2; 
			int y = dataPoint.getValue();
			writer.println(x1 + " " + x2 + " " + y);
		}
		writer.close();
		return true;
	}
	
	private String getFile(String pathOfFile){
		InputStream is;
		BufferedReader buf;
		StringBuilder sb = new StringBuilder(); 
		try {
			is = new FileInputStream(pathOfFile);
			buf = new BufferedReader(new InputStreamReader(is)); 
			String line;
			line = buf.readLine();
			while(line != null){ 
				sb.append(line).append("\n"); 
				line = buf.readLine(); 
			}
		}catch(Exception e){
			System.out.println("Error reading file");
		}
		
		return sb.toString();
	}
	
	

}
