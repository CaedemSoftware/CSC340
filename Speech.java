/*
 * **********************************************
 * San Francisco State University
 * CSC 340 - Programming Methodology
 * File Name: <Speech>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment2;

/**
 *
 * @author Ze Lei <github.com/CaedemSoftware/CSC220>
 */
public class Speech {

    private String partOfSpeech;
    private String[] defintions;

    public Speech() {

    }

    public Speech(String partOfSpeech, String[] definitions) {
        this.partOfSpeech = partOfSpeech;
        this.defintions = definitions;
    }

    public String getPartOfSpeech() {
        return this.partOfSpeech;
    }

    public String[] getArray() {
        return this.defintions;
    }

    public String getDefinition(int index) {
        return this.defintions[index];
    }
    
    //for sorting
    public int compareTo(Speech object){
        return this.partOfSpeech.compareTo(object.getPartOfSpeech());
    }
}
