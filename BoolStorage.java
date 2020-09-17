/*
 * **********************************************
 * San Francisco State University
 * CSC 340 - Programming Methodology
 * File Name: <BoolStorage>
 * Author: Duc Ta
 * Author: Ze Lei
 * **********************************************
 */
package assignment2;

/**
 *
 * @author Ze Lei <github.com/CaedemSoftware/CSC220>
 */
public class BoolStorage {
    private Boolean reverse, distinct;
    
    public BoolStorage(){
        
    }
    
    public BoolStorage(Boolean distinct, Boolean reverse){
        this.distinct = distinct;
        this.reverse = reverse;
    }
    
    public Boolean getReverse(){
        return this.reverse;
    }
    
    public Boolean getDistinct(){
        return this.distinct;
    }
    
    public void setReverse(Boolean reverse){
        this.reverse = reverse;
    }
    
    public void setDistinct(Boolean distinct){
        this.distinct = distinct;
    }
}
