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
public class BSTree {
    
    int dep=0;
    Node root; 
  
    boolean addNode(int x){
         
        if(root == null){
            root = new Node(x);
            return true;
        }
        
        Node c,p;
        p = root;c = null;
        
        while(p != null){
            if(p.key == x){
                System.err.println( x + " has already exists!");
                return false;
            } c = p;
            if(x < p.key)
                p = p.left;
            else
                p = p.right;
        }
        if(x<c.key)
            c.left = new Node(x);
        else
            c.right = new Node(x);
        return true;
    }
    
     BSTree() {  
        root = null;  
    } 
    
    Node searchT(Node p, int x){ 
        if(p == null) return(null);
        if(p.key == x) return(p);
        if(x  < p.key)
            return(searchT(p.left, x));
        else
           return(searchT(p.right, x));
    }
    
    
     boolean remove(int x){
        Node parent = root;
	Node current = root;
	boolean isLeftChild = false;
	while(current.key != x){
            parent = current;
            if(current.key > x){
		isLeftChild = true;
                    current = current.left;
                }else{
                    isLeftChild = false;
                    current = current.right;
                }
            if(current == null){
		return false;
            }
	}
	
	if(current.left == null && current.right == null){
            if(current == root){
                root = null;
            }
            if(isLeftChild == true){
                parent.left = null;
            }else{
                parent.right = null;
            }
	}
	
	else if(current.right==null){
            if(current==root){
		root = current.left;
            }else if(isLeftChild){
		parent.left = current.left;
            }else{
		parent.right = current.left;
            }
	}
        else if(current.left==null){
            if(current==root){
		root = current.right;
            }else if(isLeftChild){
		parent.left = current.right;
            }else{
		parent.right = current.right;
            }
	}else if(current.left!=null && current.right!=null){
			
            
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }			
            successor.left = current.left;
        }		
        return true;		
        
    }
    
     Node getSuccessor(Node deleleNode){
	Node successsor =null;
	Node successsorParent =null;
	Node current = deleleNode.right;
	while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
	if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
	}
	return successsor;
    }
    
    
     int Depth(Node p){ 
        if(p==null) return 0;
        else{
            int maxl= Depth(p.left);
            int maxr= Depth(p.right);
            if (maxl > maxr) return maxl+1;
            else return maxr+1;
        }
        
    }
    
    void printInOrder(){
        inOrder(root);
        System.out.println(" ");
    }
    
    void inOrder(Node root){
        if (root != null){
            if(root.left != null)
                inOrder(root.left);
            
            System.out.print(root.key+" ");
            
            if(root.right != null)
                inOrder(root.right);
        }
    }
    
     void clear(){
       root = null;
        
    }
    
}
    
    

