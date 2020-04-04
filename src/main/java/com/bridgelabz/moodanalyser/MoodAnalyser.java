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

    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood()throws MoodAnalysisException
    {
        try
        {
            if (message.length() == 0)
            {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            }
            returnMessage = (message.contains("Sad")) ? "SAD":"HAPPY";
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please enter proper message");
        }
        return returnMessage;
    }

}
