
def add(self,u,v):
    self.graph[u].append(v)
    self.graph[v].append(u)

def main():

    alaska = []
    hawaii = []
    with open('mediumG.txt') as f:
        for line in f:
            line = line.rstrip()
            alaska.append(line)
    

    int(alaska[0])

    for x in range(2, len(alaska)):
        hawaii.append(alaska[x].split(" "))

    for x in hawaii:
        x[0] = int(x[0])
        x[1] = int(x[1])


    print (hawaii)
    


    



    
    
    
    

main()
