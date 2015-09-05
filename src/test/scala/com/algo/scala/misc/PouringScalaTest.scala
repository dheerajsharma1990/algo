package com.algo.scala.misc

import org.scalatest.FunSuite


class PouringScalaTest extends FunSuite {

  class Pouring(capacities: Vector[Int]) {

    type State = Vector[Int]

    val initialState = capacities map (count => 0)

    trait Move {
      def change(state: State): State
    }

    case class Fill(glass: Int) extends Move {
      override def change(state: State): State = state updated(glass, capacities(glass))
    }

    case class Empty(glass: Int) extends Move {
      override def change(state: State): State = state updated(glass, 0)
    }

    case class Pour(from: Int, to: Int) extends Move {
      override def change(state: State): State = {
        def amount = state(from) min (capacities(to) - state(to))
        state updated(from, state(from) - amount) updated(to, state(to) + amount)
      }
    }

    val glasses = 0 until capacities.length

    val moves = (for (g <- glasses) yield new Fill(g)) ++
      (for (g <- glasses) yield new Empty(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield new Pour(from, to))

    class Path(history: List[Move], val endState: State) {
      def extend(move: Move): Path = new Path(move :: history, move change endState)

      override def toString = (history.reverse mkString " ") + "-->" + endState
    }

    val initialPath = new Path(Nil, initialState)

    def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
      if (paths.isEmpty) Stream.empty
      else {
        val more = for {
          path <- paths
          next <- moves map path.extend
          if !(explored contains next.endState)
        } yield next
        paths #:: from(more, explored ++ (more map (_.endState)))
      }
    }

    def allPathsSet = from(Set(initialPath), Set(initialState))

    def solution(n: Int): Stream[Path] = {
      for {
        pathSet <- allPathsSet
        path <- pathSet
        if path.endState contains n
      } yield path
    }
  }
}
