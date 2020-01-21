class Node: 
    def __init__(self,key): 
        self.left = None
        self.right = None
        self.val = key 
  
def main():
    r = Node(50) 
    insert(r,Node(30)) 
    insert(r,Node(20)) 
    insert(r,Node(40)) 
    insert(r,Node(70)) 
    insert(r,Node(60)) 
    insert(r,Node(80)) 
    inorder(r)

def insert(x,y): 
    if x is None: 
        x = y 
    else: 
        if x.val < y.val: 
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


main()
