package com.bridgelabz.moodanalyser;
import java.util.Objects;

public class MoodAnalyser {
    public String message;
    public String returnMessage;
    //no-arg constructor
    public MoodAnalyser()
    {

    }
    //parametrized constructor
    public MoodAnalyser(String message)
    {
        this.message = message;
    }
    public String analyseMood(String message) throws MoodAnalysisException
    {
        this.message = message;
        return analyseMood();
    }
    // Overloaded analyseMood method
    public String analyseMood() throws MoodAnalysisException
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
            return "HAPPY";
        }
        return returnMessage;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof MoodAnalyser))
            return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message) && Objects.equals(returnMessage, that.returnMessage);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(message, returnMessage);
    }
}
