import csv
import time
import random

class Node: 
    def __init__(self,key): 
        self.left = None
        self.right = None
        self.val = key 
  
def main():
     temp = []
     with open('input.dat') as inputfile:
         data = inputfile.read().split(",,") ##array of the data from input.dat file
         print(data)
    
     with open('UPC.csv') as upcfile:
         upcdata = upcfile.readlines()
         for line in upcdata:
             for Node in line.split(','):
                 temp.append(Node)
                  ##prints node so its stored but idk what to put here instead
                 

     key = random.choice(data)
     print("The key chosen is " + key)

     
def insert(x,y): 
    if x is None: 
        x = y 
    else: 
        if x.value < y.value: 
            if x.right is None: 
                x.right = y 
            else: 
                insert(x.right, y) 
        else: 
            if x.left is None: 
                x.left = y 
            else: 
                insert(x.left, y) 
  
 
def inorder(x): 
    if x != None: 
        inorder(x.left) 
        print(x.val) 
        inorder(x.right) 

def search(root,key):
    if root is None or root.value == key:
        return root
    if root.value < key:
        return search(root.right,key)
    else:
        return search(root.left,key)
    

main()

