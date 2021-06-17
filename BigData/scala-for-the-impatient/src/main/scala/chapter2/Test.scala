package chapter2

import java.net.{MalformedURLException, URL}
import scala.io.StdIn
import scala.util.Try

/**
 * @describe
 * @author gzho
 * @since 2021-06-16 17:50
 * @version 1.0.0
 * @updateTime 2021-06-16 17:50
 */
object Test {
  def main(args: Array[String]): Unit = {

    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital)

    //表达式都有值
    val i = if (1 > 0) 1 else -1
    //混合类型表达式
    val a = if (1 > 0) "positive" else -1

    //两句相同 else将返回Unit:表示没有值
    if (1 > 0) 1
    if (1 > 0) 1 else ()

    //语句终止
    val x = 1 + 2 //
    +3

    //块与表达式
    var block = {
      val a = 1 + 1
      val b = 1 + 2
      a + b
    }
    //赋值表达式的值是Unit
    val unit: Unit = block = 2

    println(unit)
    println(a)
    //格式化字符串
    println("hello, %s! you are %n", a, x)
    //字符串插值 %7.2f 宽度为7 精度为2的浮点数格式化
    println(f"Hello,$a,you'll be ${x + 9.8}%7.2f years old.%n")
    //    println(StdIn.readLine("Your name:"))


    //循环
    val s = "Hello"
    var sumInt = 0
    for (i <- 0 until s.length) {
      sumInt += s(i)
      println(sumInt)
    }

    //双生成器
    for (i <- 0 to 3; j <- 0 to 10)
      println(i + ":" + j)

    for (i <- 0 to 2; j <- 0 to 3 if i != j)
      println(f"${10 * i + j}%3d")

    for (i <- 1 to 3; from = 4 - i; j <- from to 5)
      println(f"${10 * i + j}%3d")

    val yield_i = for (i <- 1 to 10) yield i
    println(yield_i)

    //默认值
    println(decorate("hello"))
    println(decorate("hello", ">>>"))

    println(sum(1, 2, 4))
    //当做参数序列处理
    println(sum(1 to 10: _*))

    //懒值
    //如果程序不访问words, 那么文件也将不会被打开
    lazy val words = scala.io.Source.fromFile("/etc/test")

    //异常
    val in = new URL("http://hortmann.com/fred.gif").openStream()
    try {
      in.read()
    } catch {
      case _: MalformedURLException => println(s"bad url")
    } finally {
      in.close()
    }

    val result = for (
      a <- Try {
        StdIn.readLine("a: ").toInt
      };
      b <- Try {
        StdIn.readLine("b: ").toInt
      }
    ) yield a / b

  }

  /**
   * 默认值
   *
   * @param str
   * @param left
   * @param right
   * @return
   */
  def decorate(str: String, left: String = "[", right: String = "]"): String =
    left + str + right

  /**
   * 可变参数
   *
   * @param args
   * @return
   */
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

  /**
   * procedure 过程
   *
   * @param s
   */
  def box(s: String) {
    //nothing or print.....
  }
}
