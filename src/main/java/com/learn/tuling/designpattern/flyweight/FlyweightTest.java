package com.learn.tuling.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 */
public class FlyweightTest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, 6, TreeFactory.getTree("xx", "uu"));
        TreeNode treeNode1 = new TreeNode(8, 66, TreeFactory.getTree("xx", "uu"));
        TreeNode treeNode2 = new TreeNode(6, 9, TreeFactory.getTree("x2x", "uu"));
    }
}

class TreeFactory {
    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }

        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }


}

class TreeNode {
    private int i;
    private int y;
    private Tree tree;

    public TreeNode(int i, int y, Tree tree) {
        this.i = i;
        this.y = y;
        this.tree = tree;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}

class Tree {

    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("name:"+name+"创建了");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}