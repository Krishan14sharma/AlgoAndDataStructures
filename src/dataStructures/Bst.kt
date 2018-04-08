package dataStructures

import java.util.*

/**
 * Created by krishan on 05/04/18.
 */
fun main(args: Array<String>) {
    val bst = BinarySearchTree()
    bst.addNode(11)
    bst.addNode(10)
    bst.addNode(12)
    bst.addNode(6)
    bst.addNode(7)
    bst.addNode(1)
    bst.addNode(18)
    bst.addNode(19)


//    print(Arrays.toString(bst.inorder))
//    bst.delete(7)
//    bst.delete(13)
//    print(Arrays.toString(bst.inorder))

//    println(Arrays.toString(bst.preOrder))
    println(Arrays.toString(bst.postOrder))
//    println(Arrays.toString(bst.levelOrder))
//    println(bst.heightOfTree)
    println(bst.sizeOfTree())

//    print(bst.find(13))
//    print(bst.find(7))
    println(findSum(bst, 34))

}

fun findSum(bst: BinarySearchTree, i: Int): Boolean {
    fun addSum(node: Node?, sum: Int): Boolean {
        if (node == null) {
            return false
        }
        return if (i == node.data + sum && node.leftNode == null && node.rightNode == null) {
            true
        } else {
            addSum(node.leftNode, sum + node.data) || addSum(node.rightNode, sum + node.data)
        }
    }
    return addSum(bst.root, 0)
}

