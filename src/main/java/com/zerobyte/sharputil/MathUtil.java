package com.zerobyte.sharputil;

public class MathUtil {
    public static boolean notNaN(double x)
    {
        return !Double.isNaN(x);
    }

    public static boolean notInfinity(double x)
    {
        return !Double.isInfinite(x);
    }

    public static boolean notNaN(float x)
    {
        return !Float.isNaN(x);
    }

    public static boolean notInfinity(float x)
    {
        return !Float.isInfinite(x);
    }
    public static boolean between(double value, double a, double b)
    {
        return (value > a && value < b) || (value < a && value > b);
    }

    public static boolean between(float value, float a, float b)
    {
        return (value > a && value < b) || (value < a && value > b);
    }

    public static boolean between(int value, int a, int b)
    {
        return (value > a && value < b) || (value < a && value > b);
    }

    public static boolean between(long value, long a, long b)
    {
        return (value > a && value < b) || (value < a && value > b);
    }
}
