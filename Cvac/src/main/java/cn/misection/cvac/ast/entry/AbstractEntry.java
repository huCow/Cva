package cn.misection.cvac.ast.entry;

import cn.misection.cvac.ast.statement.AbstractStatement;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName CvaMain
 * @Description main 方法入口;
 * @CreateTime 2021年02月14日 17:54:00
 */
public abstract class AbstractEntry implements IEntry
{
    protected String id;

    protected AbstractStatement statement;

    protected AbstractEntry(String id, AbstractStatement statement)
    {
        this.id = id;
        this.statement = statement;
    }

    public String getId()
    {
        return id;
    }

    public AbstractStatement getStatement()
    {
        return statement;
    }
}