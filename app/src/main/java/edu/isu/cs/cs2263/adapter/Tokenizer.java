package edu.isu.cs.cs2263.adapter;
import java.util.*;

public class Tokenizer implements PushbackTokenizer{
    private String str = "The cheese is good";
    private String delim = " ";


    public Tokenizer(String str, String delim){
        setStr(str);
        setDelim(delim);

    }

    @Override
    public boolean hasMoreTokens() {
        return true;
    }

    @Override
    public void pushback() {

    }

    public String nextToken(){
        String next = getStr();

        if(this.hasMoreTokens()){
            next = this.nextToken();
        }
        return next;
    }

    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer("The cheese was good.");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
            //st.pushback();
        }

    }

    public String getStr() {
        return str;
    }
    public String getDelim(){
        return delim;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setDelim(String delim) {
        this.delim = delim;
    }
}
