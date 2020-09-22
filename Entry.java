/*
 * **********************************************
 * San Francisco State University
 * CSC 340 - Programming Methodology
 * File Name: <Entry>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment2;

/**
 *
 * @author Ze Lei <github.com/CaedemSoftware/CSC220>
 */
enum Entry {
    //Speech objects to hold definitions together with their part of speech
    Arrow1("Arrow", new Speech("noun", new String[]{
        "Here is one arrow: <IMG> -=>> </IMG>"})),
    Book1("Book", new Speech("noun", new String[]{
        "A set of pages.",
        "A written work published in printed or electronic form."})),//3
    Book2("Book", new Speech("verb", new String[]{
        "To arrange for someone to have a seat on a plane.",
        "To arrange something on a particular date."})),
    Distinct1("Distinct", new Speech("adjective", new String[]{
        "Familiar. Worked in Java.",//6
        "Unique. No duplicates. Clearly different or of a different kind."})),
    Distinct2("Distinct", new Speech("adverb", new String[]{
        "Uniquely. Written \"distinctly\"."})),
    Distinct3("Distinct", new Speech("noun", new String[]{
        "A keyword in this assignment.",//9
        "A keyword in this assignment.",
        "A keyword in this assignment.",
        "An advanced search option.",//12
        "Distinct is a parameter in this assignment."})),
    Placeholder1("Placeholder", new Speech("adjective", new String[]{
        "To be updated...",
        "To be updated...",})),//15
    Placeholder2("Placeholder", new Speech("adverb", new String[]{
        "To be updated..."})),
    Placeholder3("Placeholder", new Speech("conjunction", new String[]{
        "To be updated..."})),
    Placeholder4("Placeholder", new Speech("interjection", new String[]{
        "To be updated..."})),//18
    Placeholder5("Placeholder", new Speech("noun", new String[]{
        "To be updated...",
        "To be updated...",
        "To be updated..."})),//21
    Placeholder6("Placeholder", new Speech("preposition", new String[]{
        "To be updated..."})),
    Placeholder7("Placeholder", new Speech("pronoun", new String[]{
        "To be updated..."})),
    Placeholder8("Placeholder", new Speech("verb", new String[]{
        "To be updated..."})),//24
    Reverse1("Reverse", new Speech("adjective", new String[]{
        "On back side.",
        "Opposite to usual or previous arrangement."})),
    Reverse2("Reverse", new Speech("noun", new String[]{
        "A dictionary program's parameter.",//27
        "Change to opposite direction.",
        "The opposite.",
        "To be updated...",//30
        "To be updated...",
        "To be updated...",
        "To be updated...",})),//33
    Reverse3("Reverse", new Speech("verb", new String[]{
        "Change something to opposite.",
        "Go back",
        "Revoke ruling.",//36
        "To be updated...",
        "To be updated...",
        "Turn something inside out."})),//39
    //end of assignment mandated keywords
    Radeon1("Radeon", new Speech("GPU", new String[]{
        "Team Red",
        "Big Navi",
        "RDNA 2"})),//42
    Nvidia1("Nvidia", new Speech("GPU", new String[]{
        "Jensen's Leather Jacket",
        "Team Green",
        "Ampere"})),//45
    Intel1("Intel", new Speech("CPU", new String[]{
        "Team Blue",
        "Tiger Lake"})),//48
    Amd1("Amd", new Speech("CPU", new String[]{
        "Zen 3",
        "Lisa Su"})),//51
    Apple1("Apple", new Speech("Big Tech", new String[]{
        "Tim Apple",
        "Think Different"})),
    Google1("Google", new Speech("Big Tech", new String[]{
        "Don't be evil",//54
        "A search engine"})),
    Huang1("Huang", new Speech("Person", new String[]{
        "grader"})),//57
    Ta1("Ta", new Speech("Person", new String[]{
        "lecturer"})),
    PartA1("Part A", new Speech("noun", new String[]{
        "the first in the list"})),
    Mulan1("Mulan", new Speech("noun", new String[]{
        "a movie "})),//60
    Cdpr1("Cdpr", new Speech("noun", new String[]{
        "video game developer"})),
    Java1("Java", new Speech("noun", new String[]{
        "a programming language"})),
    Cpp1("Cpp", new Speech("noun", new String[]{
        "a programming language"})),
    Golang1("Golang", new Speech("noun", new String[]{
        "a programming language"})),;//enum objects end
    private String key;
    private Speech speech;

    private Entry() {

    }

    private Entry(String key, Speech speech) {
        this.key = key;
        this.speech = speech;
    }

    public String getKey() {
        return this.key;
    }

    public Speech getSpeech() {
        return this.speech;
    }
}
