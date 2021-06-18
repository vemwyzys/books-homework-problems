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

    /**
     * 1.一个数字如果为正数,则它的signum为1;如果为负数,则signum为-1;如果是0,则signum为0.
     * 编写一个函数来计算这个值
     */
    println(function(3))
    println(function(-3))
    println(function(0))

    /**
     * 2.空的块的表达式{}的值是空,类型是Unit
     */

    /**
     * 3.因为赋值语句的值是Unit,所以x的类型为Unit
     */
    var x: Unit = {}
    var y = 3
    x = y = 1

    /**
     * 4.
     */
    for (i <- 10 to(0, -1)) println(i)

    /**
     * 5.
     */
    countdown(5)

    /**
     * 6.
     */
    println("6: " + multiplyStr("Hello"))


    /**
     * 7
     */
    println("7: " + multiplyStrByMap("Hello"))

    /**
     * 8
     */
    println("8: " + recursiveMultiplyStr("Hello"))
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
  def multiplyStr(str: String): Long = {
    var multi: Long = 1
    for (i <- 0 until str.length) multi *= str(i)
    multi
  }

  /**
   * 7
   *
   * @param str
   * @return
   */
  def multiplyStrByMap(str: String): Long = {
    str.map(_.toLong).product
  }

  /**
   * 8
   *
   * @param str
   * @return
   */
  def recursiveMultiplyStr(str: String): Long = {
    if (str.length == 1) str(0).toLong
    else str(0).toLong * recursiveMultiplyStr(str.substring(1))
  }

  /**
   * 11
   * @param x
   * @param n
   * @return
   */
  def eleven(x: Double, n: Int): BigDecimal = {
    if (n == 0) {
      1
    }
    else if (n < 0) {
      1 / eleven(x, -1 * n)
    }
    else if (n % 2 == 1) {
      x * eleven(x, n - 1)
    }
    else {
      eleven(x, n / 2) * eleven(x, n / 2)
    }

  }

}
