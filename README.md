# Portfolio Project: Anagrams
This repository is part of the portfolio uses for SFU MDM application only. 

This project is a homework from the computer programming course I took during my undergraduate study. All codes are completed in Java. 



## Project Description
This program uses recursive backtracking to find all anagrams of a certain word, where an anagram is a word or phrase made by rearranging the letters of another word or phrase. The Anagrams class employs a dictionary to identify all anagram phrases that match a given word or phrase, and it interfaces with the client program AnagramMain (provided by the instructor), which collects user input phrases for processing.



## Work Done
I completed Anagrams.java file. The other files were provided by course instructor. 



## File Description
**AnagramsMain:** an interactive client program that allows user to input phrases for generating anagrams. 

**Anagrams:** a class that uses a dictionary to identify anagram phrases that match a given word or phrase through AnagramsMain. 

**dict1~3:** the dictionary files read by AnagramsMain for finding anagrams (can only use one dictionary per time), where switch between dictionaries can be done by adjusting the code on line 18.  

**LetterInventory:** a class that could count, add and subtract letters from words and phrases. The .class version is used for jGRASP and other basic editors whereas the .jar version is used for Eclipse.  



## Outcome
While running AnagramsMain.java, the program will ask for user input of a word or phrase. After the user simply typing into it, the program will give out all anagrams of the input. The output has two sections. The first one is all possible words in a set, and the second one is possible combinations of anagrams each time processing the input. 

For example, 

>User input: hairbrush

>Output (all possible words): [bar, briar, brush, bus, hub, huh, hush, rub, shrub, sir, sub]

Besides, the user is allowed to input a “max” number in the second part of output, which set the maximum number of words when scrambling the input each time. If a user input “2” for max, the output will only have those divides and scrambles the input into a maximum of two words. 

>Output (combination of words each time of scrambling, max of 2): [briar, hush], [hush, briar]



