package com.zerobyte.sharputil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextUtil {
    public static String Formatting(String input, String[] Strings, double delay)
    {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0.0D)
        {
            delay = 0.001D;
        }
        int offset = (int)Math.floor(System.currentTimeMillis() /delay ) % Strings.length;
        for (int i = 0; i < input.length(); ++i)
        {
            char c = input.toCharArray()[i];
            sb.append(Strings[(Strings.length + i - offset) % Strings.length]).append(c);
        }
        return sb.toString();
    }

    public static String PrintDirectory(String path)
    {
        if (new File(path).exists())
        {
            return PrintDirectory(path, 0, "");
        }

        return "";
    }

    private static String PrintDirectory(String dirpath, int depth, String prefix)
    {
        StringBuilder StringBuilder = new StringBuilder();
        File dif = new File(dirpath);
        if (depth == 0)
            StringBuilder.append(prefix + dif.getName()).append('\n');
        else
        {
            //StringBuilder.Append(prefix.SubString(0, prefix.Length - 2) + "| ").Append('\n');
            StringBuilder.append(prefix.substring(0, prefix.length() - 2) + "|-" + dif.getName()).append('\n');
        }

        if (dif.listFiles()!=null) {
            for (int counter = 0; counter < dif.listFiles().length; counter++)
            {
                File di =  dif.listFiles()[counter];
                if (counter != dif.listFiles().length - 1 ||
                        dif.listFiles().length != 0)
                    StringBuilder.append(PrintDirectory(di.getAbsolutePath(), depth + 1, prefix + "| "));
                else
                    StringBuilder.append(PrintDirectory(di.getAbsolutePath(), depth + 1, prefix + " "));
            }
        }

        return StringBuilder.toString();
    }
}
