// This is the entry point of the program

pkg cn.misection.cva.test;

call cva.native.io.*;
call cva.std.console.*;
/**
 * 原生string导入;
 */
call cva.lang.type.String;

class Increment
{
    int incre()
    {
        int i;
        i = 10;
        while (0 < i)
        {
            println i;
            i--;
        }
        return i;
    }
}

int main(string[] args)
{
    echo "hello, world!\n";
    println new Increment().incre();
    return 0;
}


//// This is the entry point of the program
//
//pkg cn.misection.cva.test;
//
//call cva.native.io.*;
//call cva.std.console.*;
///**
// * 原生string导入;
// */
//call cva.lang.type.String;
//
///**
// * block comm;
// */
//
//
//
//class Test
//{
//    int Compute(int num)
//    {
//        int total;
//        int i;
//        if ( num < 1)
//        {
//            total = 1;
//        }
//        else if (num < 5)
//        {
//            total = num * (this.Compute(num-1));
//            echo num;
//            echo "  ";
//        }
//        else
//        {
//            total = num * (this.Compute(num-1));
//        }
//        if (num < 7)
//        {
//            echo 999;
//            echo "\t";
////            echo(999);
//        }
//        i = num;
//        while (i < 5)
//        {
//            echo 888;
//            echo "\t";
////            echo("hello, string");
////            echo(888);
//            i = i + 1;
//            i++;
//        }
//        println("hello, string");
//        return total;
//    }
//}
//
//
//int main(string[] args)
//{
////    println("hello, string");
////    printf(1);
//    println(new Test().Compute(10));   // just a print statement
//    echo("this is cva main who can in a random place\n");
//    echo "\nhello, echo\n\n";
//
//    println 1 + 2;
//
//    println("hello, main method");
//    // return 0;
////    echo("hello, string");
//    return 0;
//}
