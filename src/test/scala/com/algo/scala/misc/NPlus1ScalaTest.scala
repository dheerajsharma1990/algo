package com.algo.scala.misc

import org.scalatest.FunSuite


class NPlus1ScalaTest extends FunSuite {

  def duplicateNumber(num: List[Int]): Int = {
    def getDuplicate(arr: List[Int]): Int = {
      arr match {
        case x1 :: x2 :: xs => if (x1 == x2) x1 else getDuplicate(x2 :: xs)
      }
    }
    getDuplicate(num.sorted)
  }

  test("should return 1") {
    assert(duplicateNumber(List(1, 1, 2)) === 1)
  }

  test("should return 2") {
    assert(duplicateNumber(List(1, 2, 2)) === 2)
  }

  test("should return 3") {
    assert(duplicateNumber(List(2, 3, 1, 3)) === 3)
  }

  test("should return 4") {
    assert(duplicateNumber(List(4, 1, 3, 4, 2, 6, 5)) === 4)
  }

}
