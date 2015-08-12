package com.aglo.scala.tree

class NonEmptyTree(val value: Int, val left: Tree, val right: Tree) extends Tree {
  override def invert: Tree = new NonEmptyTree(value, right.invert, left.invert)

  override def isEmpty: Boolean = false

  override def isEqual(tree: Tree): Boolean = !tree.isEmpty && value == tree.value && left.isEqual(tree.left) && right.isEqual(tree.right)
}
