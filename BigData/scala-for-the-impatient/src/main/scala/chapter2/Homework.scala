package chapter2

/**
 * @describe
 * @author gzho
 * @since 2021-06-17 16:07
 * @version 1.0.0
 * @updateTime 2021-06-17 16:07
 */
object Homework {

  def main(args: Array[String]): Unit = {
    //1.
    println(function(3))
    println(function(-3))
    println(function(0))

    //2.空的块的表达式{}的值是空,类型是Unit

    //3.因为赋值语句的值是Unit,所以x的类型为Unit
    var x: Unit = {}
    var y = 3
    x = y = 1

    //4.
    for (i <- 10 to(0, -1)) println(i)

    //5.
    countdown(5)

    //6.
    println(multiplyStr("Hello"))
  }

  /**
   * 1
   *
   * @param num
   * @return
   */
  def function(num: Int): Int = {
    if (num > 0) 1 else if (num == 0) 0 else -1
  }

  /**
   * 5
   *
   * @param num
   */
  def countdown(num: Int): Unit = {
    for (num <- num to 0 by (-1)) println(num)
  }

  /**
   * 6
   *
   * @param str
   * @return
   */
  def multiplyStr(str: String): BigInt = {
    if (null == str) return null
    var multi: BigInt = 1
    for (i <- 0 until str.length) multi *= str(i)
    multi
  }

  /**
   * 7
   *
   * @param str
   * @return
   */
  def multiplyStr(str: String): Long = {
    if (null == str) return null
    str.map(_.toLong).product
  }

}
