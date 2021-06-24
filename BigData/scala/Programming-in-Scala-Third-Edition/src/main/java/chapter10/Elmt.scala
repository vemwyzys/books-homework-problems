package chapter10

import chapter10.Elmt.ArrayElmt

/**
 * @describe
 * @author gzho
 * @since 2021-06-23 18:00
 * @version 1.0.0
 * @updateTime 2021-06-23 18:00
 */
object Elmt {

  def main(args: Array[String]): Unit = {
    val aboveElmt = elmt(Array("hello")) above elmt("world!")
  }




  def elmt(contents: Array[String]): Elmt =
    new ArrayElmt(contents)

  def elmt(str: String): Elmt =
    new LineElmt(str)

  def elmt(chr: Char, width: Int, height: Int): Elmt =
    new UniformElmt(chr, width, height)

  private class ArrayElmt(conts: Array[String]) extends Elmt {
    override val contents: Array[String] = conts
  }

  private class LineElmt(s: String) extends ArrayElmt(Array(s)) {
    override def width: Int = s.length

    override def height: Int = 1
  }

  private class UniformElmt(val ch: Char,
                            override val width: Int,
                            override val height: Int
                           ) extends Elmt {
    private val line = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }

}

abstract class Elmt {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Elmt): Elmt =
    new ArrayElmt(this.contents ++ that.contents)

  def beside(that: Elmt): Elmt =
    new ArrayElmt(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString: String = contents mkString "\n"

}
