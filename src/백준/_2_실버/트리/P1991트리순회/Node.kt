package 백준._2_실버.트리.P1991트리순회

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/1991
 */

class Node(
    val root: Char?,
    var left: Node? = null,
    var light: Node? = null,
) {
}

var head = Node('A', null, null)

fun main(args: Array<String>) {
    var bf: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()

    for (i in 0 until n) {
        val st = StringTokenizer(bf.readLine())
        val root = st.nextToken().toCharArray()[0]
        val left = st.nextToken().toCharArray()[0]
        val light = st.nextToken().toCharArray()[0]
        insert(head, root, left, light)
    }
    preOrder(head)
    println()
    inOrder(head)
    println()
    postOrder(head)
}

fun insert(node: Node, root: Char, left: Char, light: Char) {
    if (node.root == root) {
        node.left = if (left == '.') Node(null, null, null) else Node(left, null, null)
        node.light = if (light == '.') Node(null, null, null) else Node(light, null, null)
    } else {
        node.left?.let { insert(it, root, left, light) }
        node.light?.let {insert(it, root, left, light) }
    }
}

fun preOrder(node: Node) {
    node.root?.let {print(it) }
    node.left?.let { preOrder(it) }
    node.light?.let { preOrder(it) }
}

fun inOrder(node: Node) {
    node.left?.let { inOrder(it) }
    node.root?.let {print(it) }
    node.light?.let { inOrder(it) }
}

fun postOrder(node: Node) {
    node.left?.let { postOrder(it) }
    node.light?.let { postOrder(it) }
    node.root?.let {print(it) }
}
