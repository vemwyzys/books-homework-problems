package chapter4_classAndObject

/**
 * @describe
 * @author gzho
 * @since 2021-06-18 15:54
 * @version 1.0.0
 * @updateTime 2021-06-18 15:54
 */
object Test {
  def main(args: Array[String]): Unit = {
    //scala默认包为public

    println(
      """|welcome to new language
         |Type "Help",
         |or quit""".stripMargin)

    println(f"${math.Pi}%.5f")
  }

}

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte) = sum += b

  def checksum() = ~(sum & 0xFF) + 1
}

class Person {
  var age: Int = 0
}

class Rational(n: Int, d: Int)
