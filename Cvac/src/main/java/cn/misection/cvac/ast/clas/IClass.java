package cn.misection.cvac.ast.clas;

import cn.misection.cvac.ast.ASTree;
import cn.misection.cvac.ast.decl.AbstractDeclaration;
import cn.misection.cvac.ast.method.AbstractMethod;

import java.util.List;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName AbstractClass
 * @Description TODO
 * @CreateTime 2021年02月14日 18:01:00
 */
public interface IClass extends ASTree
{
    /**
     * 类名;
     * @return
     */
    String name();

    /**
     * 父类;
     * @return
     */
    String parent();

    /**
     * field;
     * @return
     */
    List<AbstractDeclaration> getFieldList();

    /**
     * 方法;
     * @return
     */
    List<AbstractMethod> getMethodList();
}
