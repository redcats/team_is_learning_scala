package team.is.learning.scala.ch4.rules.rule2

class Rule2aBase {

  implicit def convert(r: String): Int = Integer.valueOf(r)

}
