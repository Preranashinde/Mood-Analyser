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
        try
        {
            returnMessage = (message.contains("Sad")) ? "SAD":"HAPPY";
        }
        catch (NullPointerException e)
        {
            return "HAPPY";
        }
        return returnMessage;
    }
}
