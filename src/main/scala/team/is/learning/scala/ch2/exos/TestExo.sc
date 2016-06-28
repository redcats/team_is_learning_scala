import team.is.learning.scala.ch2.exos.Exercise

def f(x: Int): Int = 2 * x

Exercise.applyTwice(f, 2)

def fis(i: Int, s: String): Boolean = i == 2 && s == "test"

fis(2, "test")

def flippedFis = Exercise.flip(fis)

flippedFis("test", 2)

def example(x: Int, s: String) = s.length + x > 10
def flippedExample = Exercise.flip(example _)
assert(example(2, "scala") == flippedExample("scala", 2))

val filename = "learnscala.pdf"
//assert(Exercise.fileNameEndWith(filename, "pdf"))
//assert(Exercise.fileNameContains(filename, "scala"))
//assert(Exercise.fileNameStartWith(filename, "learn"))
//assert(!Exercise.fileNameStartWith(filename, "js"))

val xs = List(1,2,3,4,1,2,3,4)
def p( x: Int): Boolean = x < 3
Exercise.filter(xs, p)
Exercise.takeWhile(xs, p)
Exercise.dropWhile(xs, p)
Exercise.span(xs, p)