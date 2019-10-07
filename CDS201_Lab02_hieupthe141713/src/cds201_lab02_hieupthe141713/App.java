/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cds201_lab02_hieupthe141713;

/**
 *
 * @author mac
 */
public class App {
    
    public static void main(String[] args) {
        BSTree BST = new BSTree();
        BST.addNode(6);
        BST.printInOrder();
        BST.addNode(4);
        BST.addNode(8);
        BST.printInOrder();
        BST.addNode(2);
        BST.addNode(5);
        BST.addNode(7);
        BST.addNode(9);
        BST.printInOrder();
        BST.addNode(13);
        BST.printInOrder();
        BST.remove(13);
        BST.printInOrder();
    }
}
