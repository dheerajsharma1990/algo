package com.algo.scala.misc

import org.scalatest.FunSuite


class MaximumWinningScalaTest extends FunSuite {

  def maximumWinning(question: String, answer: String, winning: List[Int]): Int = {
    val correctAnswers = question zip answer count { case (q, a) => q == a}
    if (question.length == correctAnswers) winning(correctAnswers) else winning take (correctAnswers + 1) max
  }

  test("should return last if all correct") {
    assert(maximumWinning("ABC", "ABC", List(3, 2, 1, 0)) === 0)
  }

  test("should return correct answer for various scenarios") {
    assert(maximumWinning("ABCDE", "EBCDA", List(0, 10, 20, 30, 40, 50)) === 30)
    assert(maximumWinning("CHEF", "QUIZ", List(4, 3, 2, 1, 0)) === 4)
    assert(maximumWinning("ABBABAAB", "ABABABAB", List(100, 100, 100, 100, 100, 100, 100, 100, 100)) === 100)
  }

}
