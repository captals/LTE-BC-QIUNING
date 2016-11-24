package name.qiu.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamTool 
{
    public static String inToStringByByte(InputStream in) throws Exception 
    {
        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        StringBuilder content = new StringBuilder();
        while ((len = in.read(buffer)) != -1) {
            content.append(new String(buffer, 0, len, "UTF-8"));
        }
        outStr.close();
        return content.toString();
    }
}