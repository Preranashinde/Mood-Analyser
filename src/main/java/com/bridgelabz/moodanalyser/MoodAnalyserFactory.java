package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static Object createMethod(MoodAnalyser moodAnalyserObject, String methodName) throws InvocationTargetException, IllegalAccessException, MoodAnalysisException
    {
        Method method = null;
        try
        {
            method = moodAnalyserObject.getClass().getMethod(methodName);
            Object result = method.invoke(moodAnalyserObject);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Method not found");
        }
        return method.invoke(moodAnalyserObject);
    }
}
