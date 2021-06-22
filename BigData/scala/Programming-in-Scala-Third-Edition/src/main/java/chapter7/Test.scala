package chapter7

import java.io.{File, FileNotFoundException, FileReader, IOException}

/**
 * @describe
 * @author gzho
 * @since 2021-06-22 10:27
 * @version 1.0.0
 * @updateTime 2021-06-22 10:27
 */
object Test {

  def main(args: Array[String]): Unit = {
    val filename =
      if (!args.isEmpty) args(0)
      else "default.txt"

    //filter
    val filesHere = (new File(".")).listFiles()
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      if file.getName.startsWith("scala")
    } {
      println(file)
    }

    val n = 100

    //half要么被成功初始化, 要么抛出异常
    val half =
      if (n % 2 == 0)
        n / 2
      else
        throw new RuntimeException("n must be even")

    try {
      val fr = new FileReader(".")
    } catch {
      case ex: FileNotFoundException => println("")
      case ex: IOException => println("")
    }

    val firstArg = args(0)
    val friend = firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case _ => "huh?"
    }

    var x = 0
    var foundIt = false
    while (x < args.length && !foundIt) {
      if (!args(x).startsWith("-")) {
        if (args(x).endsWith(".scala"))
          foundIt = true
      }
      x += 1
    }

    //recursive
    def searchFrom(i: Int): Int = {
      if (i >= args.length) -1
      else if (args(i).startsWith("-")) searchFrom(i + 1)
      else if (args(i).endsWith(".scala")) i
      else searchFrom(i + 1)
    }

    val i = searchFrom(0)

    //作用域
    ////后面分号是必须的,因为scala的分号推断不会自动判断
    val one = 3;
    {
      //内嵌作用域的同名变量会遮挡(shadow)外部作用域
      val one = 4
    }

  }

  def grep(pattern: String) = {
    val filesHere = (new File(".")).listFiles()
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- file.list()
      //mid-stream 中途变量绑定
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ":" + trimmed)
  }

  def scalaFiles: IndexedSeq[Int] =
    for (i <- 1 to 200) yield i


}
