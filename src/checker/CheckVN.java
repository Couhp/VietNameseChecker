package checker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CheckVN {
	
	ArrayList<String> listCons = new ArrayList<String>();
	ArrayList<String> listVowel = new ArrayList<String>();
	ArrayList<String> listDiac = new ArrayList<String>();
	
	
	
	public CheckVN() throws IOException {
		File f_dia = new File("diacritic");
		BufferedReader fin_dia = new BufferedReader(new FileReader(f_dia));

		File f_vowel = new File("vowel");
		BufferedReader fin_vowel = new BufferedReader(new FileReader(f_vowel));

		File f_con = new File("consonant");
		BufferedReader fin_con = new BufferedReader(new FileReader(f_con));
		
		String raw = "";
		while((raw = fin_dia.readLine()) != null) {
			listDiac.add(raw);
		}
		
		raw = "";
		while((raw = fin_con.readLine()) != null) {
			listCons.add(raw);
		}
		listCons.add("_");
		
		raw = "";
		while((raw = fin_vowel.readLine()) != null) {
			listVowel.add(raw);
		}
		
		fin_dia.close();
		fin_con.close();
		fin_vowel.close();
	}
	
	public boolean isVN (String word) {
		for(String i : listDiac) {
			if(word.contains(i)) return true;
		}
		
		word = "_" + word;
		for(String i : listCons) {
			if(word.contains(i)) {
				String raw = word.replaceFirst(i,"");
				if(listVowel.contains(raw)) return true;
			}
		}
		return false;
	}
	
}
