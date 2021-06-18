package chapter3

import scala.io.Source

/**
 * @describe
 * @author gzho
 * @since 2021-06-18 14:10
 * @version 1.0.0
 * @updateTime 2021-06-18 14:10
 */
object Test {
  def main(args: Array[String]): Unit = {

    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)

    //List拼接   :::
    val oneToFour = oneTwo ::: threeFour

    //空列表 Nil or List()
    //拼接元素::
    val fromNil = 1 :: 2 :: 3 :: Nil

    //tuple
    val pair = (99, "antelope")
    println(pair._1)
    println(pair._2)

    val treasureMap = scala.collection.mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to tokyo")
    treasureMap += (2 -> "Find big X on ground")
    treasureMap += (3 -> "Little sister")

    println(treasureMap.toString())

    Console.err.println("Error")

    for (line <- Source.fromFile("/uri").getLines())
      println(line.length + "" + line)

  }

  def formatArgs(args: Array[String]): String = args.mkString("\n")
}
