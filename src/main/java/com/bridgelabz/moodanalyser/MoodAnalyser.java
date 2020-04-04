package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    private String message;
    private String returnMessage;

    public MoodAnalyser()
    {

    }
    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message) {
        this.message = message;
        return analyseMood();
    }

    String analyseMood() {
        if (message.equals("I am in Sad Mood"))
        {
            returnMessage="SAD";
        }
        else if (message.equals("I am in Happy Mood") || message.equals("I am in Any Mood"))
        {
            returnMessage="HAPPY";
        }
        return returnMessage;
    }
}
