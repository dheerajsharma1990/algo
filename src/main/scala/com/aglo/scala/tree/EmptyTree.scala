package com.aglo.scala.tree

class EmptyTree extends Tree {
  override def invert: Tree = new EmptyTree

  override def isEqual(tree: Tree): Boolean = tree.isEmpty

  override def isEmpty: Boolean = true

  override def left: Tree = throw new NoSuchElementException("EmptyTree.left")

  override def value: Int = throw new NoSuchElementException("EmptyTree.value")

  override def right: Tree = throw new NoSuchElementException("EmptyTree.right")
}
