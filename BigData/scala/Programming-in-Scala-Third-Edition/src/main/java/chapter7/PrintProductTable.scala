package chapter7

/**
 * @describe
 * @author gzho
 * @since 2021-06-22 14:27
 * @version 1.0.0
 * @updateTime 2021-06-22 14:27
 */
object PrintProductTable {
  def main(args: Array[String]): Unit = {

    //以序列方式返回一行
    def makeRowSeq(row: Int) =
      for (col <- 1 to 10)
        yield {
          //乘积
          val prod = (row * col).toString
          //中间数字的间隔
          val padding = " " * (4 - prod.length)
          padding + prod
        }

    //以字符串形式返回一行
    def makeRow(row: Int) =
      makeRowSeq(row).mkString

    //以字符串形式返回一行
    def multiTable() = {
      val tableSeq = {
        for (row <- 1 to 10)
          yield makeRow(row)
      }
      tableSeq.mkString("\n")
    }

    //将乘法表打印
    println(multiTable())
  }
}
