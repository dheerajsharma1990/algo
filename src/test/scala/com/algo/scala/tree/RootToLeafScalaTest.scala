package com.algo.scala.tree

import com.aglo.scala.tree.{EmptyTree, NonEmptyTree, Tree}
import org.scalatest.FunSuite


class RootToLeafScalaTest extends FunSuite {

  def emptyTree: Tree = new EmptyTree

  def rootToLeaf(root: Tree): List[String] = {
    def travelTree(root: Tree, currentPath: List[Int], allPaths: List[String]): List[String] = {
      if (root.isEmpty) allPaths
      else {

        if (root.isLeaf) {
          travelTree(root.left, currentPath :+ root.value, allPaths).union(
            travelTree(root.right, currentPath :+ root.value, allPaths)) :+ (currentPath :+ root.value).mkString("->")
        }
        else {
          travelTree(root.left, currentPath :+ root.value, allPaths).union(
            travelTree(root.right, currentPath :+ root.value, allPaths))
        }
      }
    }
    travelTree(root, List[Int](), List[String]())
  }

  test("Path Single Node Tree") {
    //given
    def tree = new NonEmptyTree(1, emptyTree, emptyTree)

    //when
    def paths = rootToLeaf(tree)

    //then
    assert(paths.size === 1)
    assert(paths.head.equals("1"))
  }

  test("Path Complete Three Node Tree") {
    //given
    def tree = new NonEmptyTree(1, new NonEmptyTree(2, emptyTree, emptyTree), new NonEmptyTree(3, emptyTree, emptyTree))

    //when
    def paths = rootToLeaf(tree)

    //then
    assert(paths.size === 2)
    assert(paths.head.equals("1->2"))
    assert(paths.tail.head.equals("1->3"))
  }

  test("Path Left Nodes Tree") {
    //given
    def tree = new NonEmptyTree(1, new NonEmptyTree(2, new NonEmptyTree(3, emptyTree, emptyTree), emptyTree), emptyTree)

    //when
    def paths = rootToLeaf(tree)

    //then
    assert(paths.size === 1)
    assert(paths.head.equals("1->2->3"))

  }

}
