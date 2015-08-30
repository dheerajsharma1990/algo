package com.algo.scala.misc

import org.scalatest.FunSuite


class UglyNumberScalaTest extends FunSuite {

  def isUgly(num: Int): Boolean = {
    def remainder(divisor: Int)(num: Int): Int = {
      if (num == 0 || (num % divisor) != 0) num
      else remainder(divisor)(num / divisor)
    }
    remainder(5)(remainder(3)(remainder(2)(num))) == 1
  }

  test("0 is not ugly") {
    assert(!isUgly(0))
  }

  test("1 2 3 4 5 6 are ugly") {
    assert(isUgly(1))
    assert(isUgly(2))
    assert(isUgly(3))
    assert(isUgly(4))
    assert(isUgly(5))
    assert(isUgly(6))
  }

  test("7 is not ugly") {
    assert(!isUgly(7))
  }

  test("8 9 10 are ugly") {
    assert(isUgly(8))
    assert(isUgly(9))
    assert(isUgly(10))
  }


}
