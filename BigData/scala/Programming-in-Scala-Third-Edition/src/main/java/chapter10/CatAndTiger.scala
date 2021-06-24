package chapter10

/**
 * @describe
 * @author gzho
 * @since 2021-06-23 16:35
 * @version 1.0.0
 * @updateTime 2021-06-23 16:35
 */
class CatAndTiger {

}

class Cat {
  val dangerous = false
}

//复杂写法
class TigerComplex(param1: Boolean, param2: Int) extends Cat {
  override val dangerous: Boolean = param1
  private var age: Int = param2
}

//简单写法
class TigerSimple(override val dangerous: Boolean,
                  private var age: Int
                 ) extends Cat
