package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static Constructor<?> getConstructor(String className, Class<?> ... param) throws MoodAnalysisException
    {
        try
        {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Class not found");
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Method not found");
        }
    }
    public static MoodAnalyser createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor,Object ... message) throws IllegalAccessException, InvocationTargetException, InstantiationException
    {
        return (MoodAnalyser) moodAnalyserConstructor.newInstance(message);
    }
}
