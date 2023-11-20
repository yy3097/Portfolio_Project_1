// Yao Yi
// 11/19/2015
// CSE 143 AC 
// TA: LATHE,CHLOE M.  
// 
// This class can use a dictionary to find all anagram phrases that
// match a given word or phrase. 

import java.util.*;

public class Anagrams {
   private Set<String> dictionary;
   
   // pre: pass in a set of strings of a given dictionary. 
   //      if the set is null, throw IllegalArgumentException. 
   // post: initialize a new anagram solver over the dictionary. 
   public Anagrams(Set<String> dictionary) {
      if (dictionary == null) {
         throw new IllegalArgumentException(); 
      }
      this.dictionary = dictionary; 
   }
   
   // pre: pass in a string of a given phrase. 
   //      if the string is null, throw IllegalArgumentException. 
   // post: find all words from the dictionary that can be made using some or all of the 
   //       letters in the given phrase. 
   //       store them in a set in alphabetical order and return the set. 
   public Set<String> getWords(String phrase) {
      if (phrase == null) {
         throw new IllegalArgumentException(); 
      }
      LetterInventory given = new LetterInventory(phrase); 
      Set<String> chosen = new TreeSet<String>(); 
      for (String word : dictionary) {
         if (given.contains(word)){
            chosen.add(word); 
         }
      }
      return chosen;    
   }
   
   // pre: pass in a string of a given phrase. 
   //      if the string is null, throw IllegalArgumentException. 
   // post: find and print all anagrams that can be formed using all of the letters 
   //       of the given phrase. 
   public void print(String phrase) {
      if (phrase == null) {
         throw new IllegalArgumentException(); 
      }
      print(phrase, 0); 
   }
   
   // pre: pass in a string of a given phrase and an integer of maximum number of words allowed. 
   //      if the string is null or integer is less than 0, throw IllegalArgumentException. 
   // post: find and print all anagrams that can be formed using all of the letters of 
   //       the given phrase and that include at most max words. 
   //       if max is 0, print all anagrams regardless of how many words they contain. 
   public void print(String phrase, int max) {
      if (phrase == null || max < 0) {
         throw new IllegalArgumentException(); 
      }
      LetterInventory givenString = new LetterInventory(phrase); 
      Set<String> chosen = getWords(phrase);
      Stack<String> result = new Stack<String>(); 
      chooseWord(chosen, result, givenString, max);
   }
   
   // pre: pass in a set of strings of all possible anagrams words, a stack of strings used 
   //      to save the chosen anagrams, a LetterInventory object of all letters that forms 
   //      the phrase given by the user, and an integer of maximum number of words allowed. 
   // post: find and print all anagrams using words from the set that can be formed using all 
   //       of the letters in the LetterInventory, with at most max words. 
   //       if max is 0, print all anagrams regardless of how many words they contain. 
   private void chooseWord(Set<String> chosen, Stack<String> result,
                                 LetterInventory given, int max) {
      if (given.isEmpty()) {
         System.out.println(result.toString());
      } else if (result.size() < max || max == 0) {
         for (String word : chosen) {
            if (given.contains(word)) {
               result.push(word); // choose the word. 
               given.subtract(word);
               chooseWord(chosen, result, given, max); // find the remain anagrams. 
               given.add(word);
               result.pop(); // unchoose. 
            }
         }
      }   
   }
}
