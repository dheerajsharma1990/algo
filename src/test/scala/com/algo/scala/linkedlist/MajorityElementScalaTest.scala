package com.algo.scala.linkedlist

import com.aglo.scala.linkedlist._
import org.scalatest.FunSuite

import scala.util.Sorting


class MajorityElementScalaTest extends FunSuite {

  def majorityElement(arr: Array[Int]) = {
    Sorting.quickSort(arr)
    arr(arr.length / 2)
  }

  test("Single Element Majority Element") {
    assert(majorityElement(Array(1)) == 1)
  }

  test("Multiple Element Majority Element") {
    assert(majorityElement(Array(2, 2, 1)) == 2)
  }

}
