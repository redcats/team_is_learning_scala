package team.is.learning.scala.ch4.rules.rule2

package object rule2a4 {

  implicit def convertToInt(r: String): Int = Integer.valueOf(r)

}
