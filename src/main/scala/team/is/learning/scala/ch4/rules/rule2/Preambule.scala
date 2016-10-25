package team.is.learning.scala.ch4.rules.rule2

import team.is.learning.scala.ch4.rules.rule2.soucre_target.{Developer, Employee}

object Preambule {
   implicit def convert(r: String): Int = Integer.valueOf(r)
   implicit def toEmpl(dev: Developer) : Employee = {
      println("from local")
      Employee(dev.id)
   }
}
