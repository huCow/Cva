package cn.misection.cvac.lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName BufferedHandler
 * @Description TODO
 * @CreateTime 2021年02月14日 14:10:00
 */
public class BufferedHandler extends BufferedReader
{
    private final StringBuffer buffer = new StringBuffer();

    public BufferedHandler(Reader in) throws IOException
    {
        super(in);
        init();
    }

    private void init() throws IOException
    {
        load();
    }

    private void load() throws IOException
    {
        String line = null;
        while ((line = this.readLine()) != null)
        {
            buffer.append(line);
        }
        this.close();
    }

    public char peek()
    {
        return peek(0);
    }

    public char peek(int num)
    {
        return buffer.charAt(num);
    }

    public String poll(int num)
    {
        String polled = buffer.substring(0, num);
        buffer.delete(0, num);
        return polled;
    }

    public char poll()
    {
        char c = peek();
        buffer.delete(0, 1);
        return c;
    }

    public StringBuffer getBuffer()
    {
        return buffer;
    }
}