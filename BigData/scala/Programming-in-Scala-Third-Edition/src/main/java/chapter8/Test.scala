package chapter8

/**
 * @describe
 * @author gzho
 * @since 2021-06-22 15:08
 * @version 1.0.0
 * @updateTime 2021-06-22 15:08
 */
object Test {

  def main(args: Array[String]): Unit = {
    val increase = (x: Int) => x + 1
    println(increase)
    println(increase(3))

    val fibonacci = () => {

    }

    val someNumbers = List(-11, -10, -5, 5, 10)
    someNumbers.foreach((x: Int) => println(x))
    //Int 目标类型 target typing
    someNumbers.foreach(x => println(x))

    val newList = someNumbers.filter((x: Int) => x > 0)

    //_ 占位符 表示 每一个  或者说  需要被填写的空格位置
    println(someNumbers.filter(_ > 0))
    println(someNumbers.filter((_: Int) > 0))

    //第一个_表示第一个参数  第二个_表示第二个参数
    val f = (_: Int) + (_: Int)
    println(f(1, 2))

    //占位符实际是全体参数列表的占位符
    someNumbers.foreach(println(_))

    //部分应用函数
    val sum = (a: Int, b: Int, c: Int) => a + b + c
    val a = sum
    println(a(1, 2, 3))
    val b = sum(1, _: Int, 3)
    println(b(2))


    ////闭包/////
    var more = 10
    more = more + 1
    //x: bound variable
    //more: free variable
    //捕获生成lambda时活跃的变量   此处为more
    val closure = (x: Int) => x + more
    println(closure(1))
    more = 1000
    //不用害怕自由变量被出栈
    //scala编译器会重新组织安排, 让被捕获的参数在堆上继续存活
    //不用担心, 看到喜欢的变量,只管捕获就好了
    println(closure(2))

    //重复参数
    def echo(args: String*) =
      for (arg <- args) println(arg)

    val strs = Array("a", "ab", "korean", "map")
    //需要使用_*
    echo(strs: _*)

    //带名字的参数
    def speed(distance: Int, time: Float) =
      distance / time

    println(speed(100, 10))
    //指定参数
    println(speed(time = 10, distance = 100))

    //缺省参数
    def printTime(out: java.io.PrintStream = Console.out) =
      out.println("time =" + System.currentTimeMillis())
  }

}
