package com.algo.scala.misc

import org.scalatest.FunSuite


class MissingNumberScalaTest extends FunSuite {
  def missingNumber(num: Array[Int]): Int = {
    ((num.length * (num.length + 1)) / 2) - num.sum
  }

  test("2 should be missing") {
    assert(missingNumber(Array(0, 1, 3)) === 2)
  }

  test("1 should be missing") {
    assert(missingNumber(Array(0)) === 1)
  }
}
