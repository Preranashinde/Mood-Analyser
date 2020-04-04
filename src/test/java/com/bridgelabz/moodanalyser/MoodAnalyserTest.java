package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser;
    String result;

    @Test
    public void givenMessage_WhenProper_RespondAsSadMood()
    {
        moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenProper_RespondAsHappyMood()
    {
        moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() {
        moodAnalyser=new MoodAnalyser("I am in Any Mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", result);
    }
}
