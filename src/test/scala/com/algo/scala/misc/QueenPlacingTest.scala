package com.algo.scala.misc

import org.scalatest.FunSuite


class QueenPlacingTest extends FunSuite {

  def queens(n: Int): Set[List[Int]] = {

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      def row = queens.length
      def queensWithRow = ((row - 1) to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => c != col && math.abs(r - row) != math.abs(c - col)
      }
    }

    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else {
        for {
          kQueens <- placeQueens(k - 1)
          col <- 0 until n
          if (isSafe(col, kQueens))
        } yield col :: kQueens
      }
    }
    placeQueens(n)
  }

  def map(list: List[Int]) = {
    val lines = for (col <- list) yield Vector.fill(list.length)("*").updated(col, "x").mkString + "\n"
    lines.mkString
  }

  test("Only one number add") {
    println(queens(4) map (map))
    assert(queens(4) contains List(2, 0, 3, 1))
  }


}
