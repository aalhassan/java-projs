package java112.project3;
import java.io.*;
import java.util.*;
/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 */
public class GradeBean extends java.lang.Object {

    private int score;
    private int scorePercent;
    private Map<String, ArrayList<String>> gradeMap;

    public GradeBean() {
       this.gradeMap = new TreeMap<String, ArrayList<String>>();
    }

    public GradeBean(int score, int scorePercent, Map<String, ArrayList<String>> gradeMap) {
        this();
        this.score = score;
        this.scorePercent = scorePercent;
        this.gradeMap = gradeMap;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScorePercent() {
        return scorePercent;
    }

    public void setScorePercent(int scorePercent) {
        this.scorePercent = scorePercent;
    }

    public Map<String, ArrayList<String>> getGradeMap() {
        return gradeMap;
    }

    public void setGradeMap(Map<String, ArrayList<String>> gradeMap) {
        this.gradeMap = gradeMap;
    }

}
