package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser;
    String result;

    @Test
    public void givenMessage_WhenProper_RespondAsSadMood() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenProper_RespondAsHappyMood() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenMessage_whenAny_shouldReturnHappy() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("I am in Any Mood");
        result=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_ShouldReturnHappy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser(null);
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void  givenNullMood_ShouldThrowCustomException()
    {
        try
        {
            moodAnalyser = new MoodAnalyser(null);
            result = moodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMood_ShouldThrowCustomExceptionWithExceptionType()
    {
        try
        {
            moodAnalyser = new MoodAnalyser();
            result = moodAnalyser.analyseMood(" ");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true,check);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("CroodAnalyser");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenClass_WhenConstructorIsNotProper_ShouldThrowMoodAnalysisException()
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}
