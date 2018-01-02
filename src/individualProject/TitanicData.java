package individualProject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TitanicData {
	
	public static void main(String[] args){
		new TitanicData();
	}
	
	public TitanicData(){
		String pathOfFile = "C:/Users/AdibPD/Downloads/Titanic Data/train.csv";
		String info = getFile(pathOfFile);
		String[][] reviews = parseFile(info);
		
		for(int i = 0; i < reviews.length; i++){
			String[] current = reviews[i];
			for(int j = 0; j < current.length; j++){
				System.out.print(current[j] + " ");
			}
			System.out.println();
		}
		int[][] importantInfo= getNecessaryInfo(reviews);
		writeToFile(importantInfo);
		
		
	}
	
	private boolean writeToFile(int[][] data){
		PrintWriter writer = null;
		try{
		    writer = new PrintWriter("C:/Users/AdibPD/Downloads/TitanicTrainingData.csv", "UTF-8");
		} catch (IOException e) {
		   return false;
		}
		for(int i = 0; i < data.length; i++){
			int[] current = data[i];
			for(int j = 0; j < current.length; j++){
				writer.print(current[j]);
				if(j != current.length - 1){
					writer.print(",");
				}
			}
			writer.println();
		}
		writer.close();
		return true;
	}
	
	private int[][] getNecessaryInfo(String[][] parsedFile){
		int[][] changedParsedFile = new int[parsedFile.length - 1][];
		for(int i = 1; i < parsedFile.length; i++){
			String[] currentPass = parsedFile[i];
			int[] newCurrentPass = new int[4];
			
			for(int j = 0; j < 3; j++){
				String currentInfo = currentPass[j];
				if(j == 2){
					if(currentInfo.equals("male")){
						newCurrentPass[j] = 0;
					}else if(currentInfo.equals("female")){
						newCurrentPass[j] = 1;
					}
				}else if(j == 3){
					int age = (int) Double.parseDouble(currentInfo);
					newCurrentPass[j] = age;
				}else{
					newCurrentPass[j] = Integer.parseInt(currentInfo);
				}
			}
			changedParsedFile[i-1] = newCurrentPass; 	
		}	
		return changedParsedFile;
	}
	
	private String[][] parseFile(String file){
		String[] reviews = file.split("\n");
		String[][] seperateReviews = new String[reviews.length][2];
		for(int reviewCount = 0; reviewCount < reviews.length; reviewCount++){
			String currentReview = reviews[reviewCount];
			currentReview = currentReview.replace(",", " ").trim();
			currentReview = currentReview.replaceAll("([\"]).+?[\"]", "");
			currentReview = currentReview.replaceAll("\"", "");
			String[] currentReviewSplit = currentReview.split("\\s+");
			seperateReviews[reviewCount] = currentReviewSplit;
		}
		
		return seperateReviews;
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
