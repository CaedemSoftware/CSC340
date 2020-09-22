/*
 * **********************************************
 * San Francisco State University
 * CSC 340 - Programming Methodology
 * File Name: <assignment2Driver>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment2;

/**
 *
 * @author Ze Lei <github.com/CaedemSoftware/CSC220>
 */
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class assignment2Driver {

    @SuppressWarnings("unchecked")
    //warnings are from ArrayList and Stack
    public static void main(String[] args) {
        System.out.println("! Loading data...");
        //multimap so I can store definitions with the same keyword and different
        //parts of speech
        Multimap<String, Speech> dictionaryGG = ArrayListMultimap.create();
        int keywordCount = 0;
        int definitionCount = 0;
        ArrayList speechList = new ArrayList();
        for (Entry word : Entry.values()) {
            dictionaryGG.put(word.getKey(), word.getSpeech());
            if (word.name().contains("1")) {
                keywordCount++;
            }
            for (String array : word.getSpeech().getArray()) {
                //definitions are stored in arrays
                definitionCount++;
            }
            if (!speechList.contains(word.getSpeech().getPartOfSpeech())) {
                //stores all the parts of speech listed in enum
                speechList.add(word.getSpeech().getPartOfSpeech());
            }
        }
        //done with data source(enum)
        System.out.println("! Loading completed...\n\n"
                + "===== DICTIONARY 340 JAVA =====\n"
                + "----- Keywords: " + keywordCount + "\n"
                + "----- Definitions: " + definitionCount + "\n");
        //searchCount does not reset
        int searchCount = 1;
        while (true) {
            String searchKey;
            String[] inputArr;
            int inputCount = 0;
            //BoolStorage keeps the booleans referenced in the check[Keyword] methods
            BoolStorage bool = new BoolStorage(false, false);
            Scanner input = new Scanner(System.in);
            System.out.print("Search [" + searchCount + "]: ");
            searchCount++;
            String testEmpty = input.nextLine().toLowerCase();
            String partOfSpeech = "";
            if (testEmpty.isBlank()) {//if input has no char
                searchKey = "!help";
            } else {//standard case
                inputArr = testEmpty.split(" ");
                searchKey = inputArr[inputCount];
                while (searchKey.isBlank()) {//if spaces before first keyword
                    //delete the empty elements in inputArr
                    String[] tempArray = new String[inputArr.length - 1];
                    System.arraycopy(inputArr, 1, tempArray, 0, tempArray.length);
                    inputArr = tempArray;
                    searchKey = inputArr[inputCount];
                }
                //casing for multimap key
                searchKey = Character.toString(searchKey.charAt(0)).toUpperCase()
                        + searchKey.substring(1);
                //check for quit before unnecessary processes
                if (searchKey.equals("!q") || searchKey.equals("Quit")
                        || searchKey.equals("!quit")) {
                    break;//end while loop
                }
                //subtract once instead of three times
                int arrSize = inputArr.length - 1;
                if (arrSize >= 4) {//more than 4 keywords
                    displayHowTo();
                    System.out.println(String.format("%4s", "|"));
                    continue;
                }
                if (inputCount < arrSize) {//2 keywords
                    inputCount++;
                    //partOfSpeech -> distinct -> reverse
                    partOfSpeech = checkSpeech(inputArr[inputCount], speechList, bool);
                }
                if (inputCount < arrSize) {//3 keywords
                    inputCount++;
                    //distinct -> reverse
                    bool.setDistinct(checkDistinct(inputArr[inputCount], bool, 0));
                }
                if (inputCount < arrSize) {//4 keywords
                    inputCount++;
                    //reverse
                    bool.setReverse(checkReverse(inputArr[inputCount], bool, 0));
                }
            }//end standard case
            //boolean in case key is in multimap but no associated entry
            boolean found = false;
            if (dictionaryGG.containsKey(searchKey)) {//check multimap keys
                System.out.println(String.format("%4s", "|"));
                Iterator<Speech> it = dictionaryGG.get(searchKey).iterator();
                //stack for reverse function, had to be before while
                Stack reverseStack = new Stack();
                while (it.hasNext()) {
                    Speech word = it.next();
                    if (!word.getPartOfSpeech().contains(partOfSpeech)) {//skip this speech object
                        continue;
                    }
                    String temp = "";
                    found = true;//word && part of speech in dictionary
                    //found will be false if the keyword doesn't have
                    //the selected part of speech
                    for (String def : word.getArray()) {
                        String out = "    " + searchKey + " "
                                + "[" + word.getPartOfSpeech() + "] : " + def;
                        if (bool.getDistinct()) {
                            if (temp.equals(def)) {
                                continue;//skips repeated definitions
                            }
                        }
                        temp = def;//store last definition
                        if (!bool.getReverse()) {
                            System.out.println(out);
                        }
                        if (bool.getReverse()) {
                            reverseStack.addElement(out);//stack FILO
                        }
                    }//end for each
                }// end iterator while
                if (bool.getReverse()) {
                    while (!reverseStack.isEmpty()) {
                        System.out.println(reverseStack.pop());
                    }
                }
                if (!found) {
                    displayNotFound();
                    displayHowTo();
                }
            }//end if contains searchKey
            else {
                if (!searchKey.equals("!help")) {
                    System.out.println(String.format("%4s", "|"));
                    displayNotFound();
                }
                displayHowTo();
            }
            System.out.println(String.format("%4s", "|"));
        }
        System.out.println("\n-----THANK YOU-----");
    }

    private static String checkSpeech(String input2, ArrayList speechList,
            BoolStorage bool) {
        if (speechList.contains(input2)) {
            return input2;
        } else {
            bool.setDistinct(checkDistinct(input2, bool, 1));
        }
        return "";
    }

    private static boolean checkDistinct(String input3,
            BoolStorage bool, int failCount) {
        if (input3.equals("distinct")) {
            return true;
        } else {
            bool.setReverse(checkReverse(input3, bool, failCount + 1));
        }
        return bool.getDistinct();
    }

    //undoes distinct?
    private static boolean checkReverse(String input4, BoolStorage bool, int failCount) {
        if (input4.equals("reverse")) {
            return true;
        } else {
            displayError(input4, failCount + 1);
        }
        return bool.getReverse();
    }

    private static void displayError(String input, int failCount) {
        switch (failCount) {
            case 3://2nd para
                System.out.println(String.format("%4s", "|") + "\n"
                        + "    <The entered 2nd parameter '" + input + "' is NOT a part of speech.>\n"
                        + "    <The entered 2nd parameter '" + input + "' is NOT 'distinct'.>\n"
                        + "    <The entered 2nd parameter '" + input + "' is NOT 'reverse'.>\n"
                        + "    <The entered 2nd parameter '" + input + "' was disregarded.>\n"
                        + "    <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>\n"
                        + String.format("%4s", "|")
                );
                break;
            case 2://3rd para
                System.out.println(String.format("%4s", "|") + "\n"
                        + "    <The entered 3rd parameter '" + input + "' is NOT 'distinct'.>\n"
                        + "    <The entered 3rd parameter '" + input + "' is NOT 'reverse'.>\n"
                        + "    <The entered 3rd parameter '" + input + "' was disregarded.>\n"
                        + "    <The 3rd parameter should be 'distinct' or 'reverse'.>\n"
                        + String.format("%4s", "|")
                );
                break;
            case 1://4th para
                System.out.println(String.format("%4s", "|") + "\n"
                        + "    <The entered 4th parameter '" + input + "' is NOT 'reverse'.>\n"
                        + "    <The entered 4th parameter '" + input + "' was disregarded.>\n"
                        + "    <The 4th parameter should be 'reverse'.>\n"
                        + String.format("%4s", "|")
                );
            default:
                break;
        }
    }

    private static void displayHowTo() {
        System.out.println(String.format("%4s", "|")
                + "\n    PARAMETER HOW-TO, please enter:\n"//how to
                + "    1. A search key -then 2. An optional part of speech -then\n"
                + "    3. An optional 'distinct' -then 4. An optional 'reverse'");
    }

    private static void displayNotFound() {
        System.out.println("    <NOT FOUND> To be considered for the next release. "
                + "Thank you.\n"
                + (String.format("%4s", "|")));
    }
}
