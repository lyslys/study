package com.learn.datastructure;

/**
 * 链表数据结构
 */
public class LinkListDemo {

    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.addNode("节点1");
        nm.addNode("节点2");
        nm.addNode("节点3");
        nm.addNode("节点4");
        nm.addNode("节点5");
        nm.addNode("节点6");
        nm.printNode();
        nm.delNode("节点4");
        nm.printNode();
    }

}

class NodeManager{

    private Node root;//根节点

    //添加节点
    public void addNode(String name){
            //如果根节点为空，那么添加的就是根节点
            if(root == null){
                root = new Node(name);
            }else {
                root.add(name);
            }
    }

    //删除节点
    public void delNode(String name){
        if(root != null){
            if(root.name.equals(name)){
                root = root.next;
            }else{
                root.del(name);
            }
        }
    }

    //输出所有节点
    public void printNode(){
        if(root != null){
            System.out.print(root.name);
            root.print();
            System.out.println();
        }
    }

    //定义一个节点内部类
    class Node{

        private String name;
        private Node next;//表示下一个节点对象

        public Node(String name) {
            this.name = name;
        }

        //添加节点
        public void add(String name){
                if(this.next == null){
                    this.next = new Node(name);
                }else{
                    this.next.add(name);
                }
        }

        //删除节点
        public void del(String name){
                if(this.next != null){
                    if(this.next.name.equals(name)){
                        this.next = this.next.next;
                    }else{
                        this.next.del(name);
                    }
                }
        }

        //输出所有节点
        public void print(){
            if(this.next != null){
                System.out.print("-->"+this.next.name);
                this.next.print();
            }
        }

    }

}