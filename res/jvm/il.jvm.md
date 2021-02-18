```java
class TestMain
{
    // This is the entry point of the program
    void main()
    {
        print(new Test().Compute(10));   // just a print statement
    }
}
class Test
{
    int Compute(int num)
    {
        int total;
        if ( num < 1)
            total = 1;
        else
            total = num * (this.Compute(num-1));
        return total;
    }
}
```
- 观察以上一段代码，我们主要关注Compute方法编译出的指令，而且给出了较详细的注释。

```nasm
.method public Compute(I)I
.limit stack 4096 ; 栈调用深度，这个算法我们还没有实现，因此编译结果给出默认值 4096
.limit locals 4 ; 共计有4个本地变量
    ; num < 1 对于if语句中的判别式进行计算
    iload 1     ; 从本地变量表中加载变量1的值(num)到栈上
    ldc 1       ; 将整型数字1压入栈
    if_icmplt Label_2 ;比较两个值，如果第一个值(num)小于整数1，跳转至Label_2; 栈顶大, 就跳转;
    ldc 0       ; 将整数0压入栈(用于表示比较结果为false)
    goto Label_3
Label_2:
    ldc 1       ; 将整数1压入栈(用于表示比较结果为真)
Label_3:        ; 判别式计算完成
    ldc 1
    if_icmplt Label_0 ; 对于求值真假进行计算
    ldc 1       ; 将整数1压入栈
    istore 2    ; 将栈上的数字存入本地变量2
    goto Label_1
Label_0:
    iload 1     ; 从本地变量表中加载变量1的值 (num)
    aload 0     ; 从本地变量表中加载变量0的值 (this)
    iload 1
    ldc 1
    isub
    invokevirtual Test/Compute(I)I ; 调用实例方法(在指令参数处指出了方法的从属及签名)
    imul
    istore 2
Label_1:
    iload 2     ; 从本地变量表中加赞变量2的值
    ireturn     ; 从方法返回。
.end method

; This file is automatically generated by the compiler
; Do Not Modify!
```

```nasm
;application;
.class public Application
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 4096
.limit locals 2
    new Test
    dup
    invokespecial Test/<init>()V
    ldc 10 ; 常量10压入栈
    invokevirtual Test/Compute(I)I ; 调用方法, 同时应该是要把计算结果压入;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap ; 因为打印要数字在栈顶;
    invokevirtual java/io/PrintStream/print(I)V
    return
.end method
```


```java
class SomeClass
{
    private void printString(String s) {
        if (s.length() == 0) {
            return;
        }
        
        ProgramGenerator generator = ProgramGenerator.getInstance();
        // 先压入out流处理;
        generator.emit(Instruction.GETSTATIC, "java/lang/System/out Ljava/io/PrintStream;");
        // 再压入常量;
        generator.emit(Instruction.LDC, "\"" + s + "\"");
        // 再调用方法, 所以如果打印的东西在栈顶, 需要swap;
        String printMethod = "java/io/PrintStream/print(Ljava/lang/String;)V";
        generator.emit(Instruction.INVOKEVIRTUAL, printMethod);
    }
    
    private void printInteger(int posInList) {
        ProgramGenerator generator = ProgramGenerator.getInstance();
        generator.emit(Instruction.GETSTATIC, "java/lang/System/out Ljava/io/PrintStream;");
        generator.emit(Instruction.ILOAD, "" + posInList);
        String printMethod = "java/io/PrintStream/print(I)V";
        generator.emit(Instruction.INVOKEVIRTUAL, printMethod);
    }
}
```