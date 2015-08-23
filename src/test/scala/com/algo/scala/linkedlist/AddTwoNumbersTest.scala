package com.algo.scala.linkedlist

import org.scalatest.FunSuite

import scala.util.Sorting


class AddTwoNumbersTest extends FunSuite {

  def addReverseNumbers(num1: List[Int], num2: List[Int]): List[Int] = {
    def addReverseNumbersWithCarry(num1: List[Int], num2: List[Int], carry: Int): List[Int] = {
      (num1, num2) match {
        case (Nil, Nil) => if (carry == 1) List(1) else Nil
        case (Nil, y :: ys) => ((y + carry) % 10) :: addReverseNumbersWithCarry(num1, ys, (y + carry) / 10)
        case (x :: xs, Nil) => ((x + carry) % 10) :: addReverseNumbersWithCarry(xs, num2, (x + carry) / 10)
        case (x :: xs, y :: ys) => ((x + y + carry) % 10) :: addReverseNumbersWithCarry(xs, ys, (x + y + carry) / 10)
      }
    }
    addReverseNumbersWithCarry(num1, num2, 0)
  }

  test("Only one number add") {
    assert(addReverseNumbers(List(1), Nil) == List(1))
  }

  test("Single digit number add") {
    assert(addReverseNumbers(List(1), List(2)) == List(3))
  }

  test("Single digit where result produces sum") {
    assert(addReverseNumbers(List(9), List(8)) == List(7, 1))
  }

  test("Multiple digit sum") {
    assert(addReverseNumbers(List(2, 4, 3), List(5, 6, 4)) == List(7, 0, 8))
  }

  test("Multiple digit sum with car") {
    assert(addReverseNumbers(List(2, 4, 8), List(5, 6, 4)) == List(7, 0, 3, 1))
  }

}
