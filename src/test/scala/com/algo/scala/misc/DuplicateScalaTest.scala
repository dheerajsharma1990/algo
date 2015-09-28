package com.algo.scala.misc

import org.scalatest.FunSuite


class DuplicateScalaTest extends FunSuite {
  def containsDuplicate(num: Array[Int]): Boolean = !(num.distinct.size == num.size)

  test("should return false") {
    assert(!containsDuplicate(Array(0, 1, 3)))
  }

  test("should return true") {
    assert(containsDuplicate(Array(0, 1, 1)))
  }



}
