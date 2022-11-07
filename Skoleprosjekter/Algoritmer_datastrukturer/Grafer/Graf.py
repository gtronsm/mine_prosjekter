#Dybde-forst soek: 
# Foelger en vilkaarlig sti vekk fra en gitt startnode
# Naar den ikke kan finne en ubesøkt node sporer den stien tilbake
# I hvert ledd forsoeker den aa foelge nye noder som leder vekk fra noden den er i

#Bredde-forst soek:
# Besoker hele tiden den nermeste ubesokte noden fra startnoden.
# Den jobber seg lagvis gjennom grafen, besoker forst alle direkte naboer, sa alle naboer sine naboer osv.
# Brukes for aa finne korteste stier fra en startnode til andre noder

#Topologisk sortering:
# Ordner nodene i en rettet asyklisk graf (DAG)
# Gir en mulig «gjennomføringsplan»
# Dersom det ikke gaar aa topologisk sortere nodene, saa kan vi konkludere med at grafen inneholder en sykel!

#Dijkstra:
# Gir en dict etter hvilken mest gunstige sti for vektede grafer fra en node til alle.

from collections import defaultdict
from queue import PriorityQueue
import time


class Graf:
    def __init__(self):
        self.ordbok = {}
        self.kanterListe = []
        self.fil = "input.txt"
        self.filen = open(self.fil, "r")
        
        for linje in self.filen:
            self.biter = linje.split(":")
            self.kanter = self.biter[1].strip('\n').split(",")
            
            for kant in self.kanter:
                self.kanterListe.append(kant)
            
            self.ordbok[self.biter[0]] = self.kanterListe
            self.kanterListe = []
            
            
    def DFSoekHele(self):
        #Soerger for at vi gaar gjennom alle kompnenter i grafen
        besoekt = []
        
        for key in self.ordbok.keys():
            if key not in besoekt:
                self.DFSoekRekursiv(key, besoekt)
                

    def DFSoekRekursiv(self, startnode, besoekt):
        # Besoker alle nodene i komponenten til en node noyaktig én gang
        print("Naa besoeker vi: "+ startnode+".")
        besoekt.append(startnode)
        
        kanter = self.ordbok.get(startnode)
        
        if len(kanter) != 0:
            for kant in kanter:
                if kant not in besoekt:
                    self.DFSoekRekursiv(kant, besoekt)
    
    
    def BFSoekHele(self):
        #Soerger for at vi gaar gjennom alle kompnenter i grafen noyaktig en gang
        besoekt = []
        
        for key in self.ordbok.keys():
            if key not in besoekt:
                self.BFSoek(key, besoekt)
    
    
    def BFSoek(self,startnode, besoekt):
        #Besoker den nermeste ubesokte noden fra startnoden
        besoekt.append(startnode)
        koe = [startnode]
        
        while len(koe) != 0:
            u = koe.pop(0)
            print("Naa besoeker vi: "+ u +".")
            kanter = self.ordbok.get(u)
            
            for kant in kanter:
                if kant not in besoekt:
                    besoekt.append(kant)
                    koe.append(kant)


class Rettet_graf:  
    def __init__(self):
        self.noder = {}
        self.fil = "inputRettet.txt"
        self.filen = open(self.fil, "r")
        
        for linje in self.filen:
            self.biter = linje.split(":")
            kanter = self.biter[1].strip('\n').split(",")
            
            if self.biter[0] not in self.noder.keys() and not self.biter[0] == '':
                node = Node(self.biter[0])
            else:
                node = self.noder.get(self.biter[0])
        
            #Legger inn som navn:node i ordboken noder
            self.noder[self.biter[0]] = node
            
            if not kanter[0] == '':
                for kant in kanter:
                    if kant not in self.noder.keys():
                        kantnode = Node(kant)
                        self.noder[kant] = kantnode
                 
                    else:
                        kantnode = self.noder.get(kant)
               
                    node.kanter.append(kantnode)
                    node.utgrad += 1
                    kantnode.inngrad += 1
        
    #Topologisk sortering
    def top_sortering(self):
        stack = []
        output = []
    
        for node in self.noder:          
            # Ser etter noder med inngrad 0 - disse kan vi starte med
            if self.noder[node].inngrad == 0:
                stack.append(self.noder[node])
        
        # Gaar i lokke over valgene som apner seg
        while len(stack) != 0:
            curNode = stack.pop()
            output.append(curNode.navn)
            
            if (curNode.kanter != 0):
                for kant in curNode.kanter:
                    curNode.kanter.remove(kant)
                    kant.inngrad -= 1
                    curNode.utgrad -= 1
                    if kant.inngrad == 0:
                        stack.append(kant)
        
        print(output)
        
        if len(output) > len(self.noder):
            print("ERROR: Graf inneholder en sykel og kan ikke sorteres topologisk")


class VektetGraf:
    def __init__(self):
        self.noder = {}
        self.fil = "inputNegVektet.txt"
        self.filen = open(self.fil, "r")
        self.oversiktNoder = set()
        
        for linje in self.filen:
            self.biter = linje.strip('\n').split()
            self.vekt = self.biter[1]
            self.nodene = self.biter[0].split("-")
            
            if self.nodene[0] not in self.oversiktNoder:
                node1 = Node(self.nodene[0])
                self.oversiktNoder.add(node1.navn)
            
            else:
                for key in self.noder:
                    en , to = key
                    if self.nodene[0] == en.navn:
                        node1 = en
                    elif self.nodene[0] == to.navn:
                        node1 = to         
            
            if self.nodene[1] not in self.oversiktNoder:
                node2 = Node(self.nodene[1])
                self.oversiktNoder.add(node2.navn)
            
            else:
                for key in self.noder:
                    en , to = key
                    if self.nodene[1] == en.navn:
                        node2 = en
                    elif self.nodene[1] == to.navn:
                        node2 = to
            
            tuple = (node1, node2)
            self.noder[tuple] = float(self.vekt)

    def djikstra(self):
        key = next(iter(self.noder))
        #Tar egentlig inn en startnode, men her setter vi den bare
        startnode, _ = key
        
        visited = set()
        dist = defaultdict(lambda: float('inf'))
        koe = PriorityQueue()
        
        koe.put((0,startnode))
        dist[startnode] = 0
        
        while (koe != 0 and len(visited) < len(self.oversiktNoder)):
            #Pakker ut tuppel
            _ , curNode = koe.get()
            if curNode not in visited:
                visited.add(curNode)
                
                #Her er kant en node
                for tuple in self.noder:
                    curNode, nextNode = tuple
                    vekt = float(dist[curNode]) + float(self.noder[tuple])
                    if vekt < dist[nextNode]:
                        dist[nextNode] = vekt
                        koe.put((vekt, nextNode))
        
        for key in dist.keys():
            print(key.navn + " :", dist[key])

class Negativt_vektet_graf:
    def __init__(self):
        self.noder = {}
        self.fil = "inputNegVektet.txt"
        self.filen = open(self.fil, "r")
        self.oversiktNoder = set()
        
        for linje in self.filen:
            self.biter = linje.strip('\n').split()
            self.vekt = self.biter[1]
            self.nodene = self.biter[0].split("-")
            
            if self.nodene[0] not in self.oversiktNoder:
                node1 = Node(self.nodene[0])
                self.oversiktNoder.add(node1.navn)
            
            else:
                for key in self.noder:
                    en , to = key
                    if self.nodene[0] == en.navn:
                        node1 = en
                    elif self.nodene[0] == to.navn:
                        node1 = to         
            
            if self.nodene[1] not in self.oversiktNoder:
                node2 = Node(self.nodene[1])
                self.oversiktNoder.add(node2.navn)
            
            else:
                for key in self.noder:
                    en , to = key
                    if self.nodene[1] == en.navn:
                        node2 = en
                    elif self.nodene[1] == to.navn:
                        node2 = to
            
            tuple = (node1, node2)
            self.noder[tuple] = float(self.vekt)
            

    def bellman_ford(self):
        key = next(iter(self.noder))
        #Tar egentlig inn en startnode, men her setter vi den bare
        startnode, _ = key
        
        dist = defaultdict(lambda: float('inf'))
        dist[startnode] = 0
        
        teller = 0
        
        #En sti kan ikke inneholder mer enn |V| - 1 kanter. Mer enn dette blir sykel.
        for tuple in self.noder:
            if teller == len(self.noder) - 1:
                break
            else:
                curNode, nextNode = tuple
                vekt = float(dist[curNode]) + float(self.noder[tuple])
                if vekt < dist[nextNode]:
                    dist[nextNode] = vekt
                teller += 1
                
        #Gar en runde til for aa sjekke at man ikke har en negativ sykel
        for tuple in self.noder:
            curNode, nextNode = tuple
            vekt = float(dist[curNode]) + float(self.noder[tuple])
            if vekt < dist[nextNode]:
                print("error: Grafen inneholder en negativ sykel")
                exit()
                        
        for key in dist.keys():
            print(key.navn, ":", dist[key])

class Node:
    def __init__(self, navn):
        self.navn = navn
        self.inngrad = 0
        self.utgrad = 0
        self.kanter = []
     
#HOVEDPROGRAM
x = "true"

while x == "true":
# while (not x == "r" or not x == "u"):
    print("_____________________")
    print("     VALGMENY \n")
    print("(Tast r) Rettet graf")
    print("(Tast u) Urettet graf")
    print("(Tast v) Vektet graf")
    print("(Tast n) Negativt vektet graf")
    print("(Tast a) Avslutt")
    
    x = input("\nDitt svar: ")
    
    if (x.lower() == "r"):
        graf = Rettet_graf()
        print("\nTopologisk: ")
        graf.top_sortering()
        
    elif (x.lower() == "u"):
        graf = Graf()
        print("\nDybdeFoerst: ")
        graf.DFSoekHele()
        print("\nBreddeFoerst: ")
        graf.BFSoekHele()
    
    elif (x.lower() == "v"):
        graf = VektetGraf()
        print("\nDjikstra: ")
        graf.djikstra()
    
    elif (x.lower() == "n"):
        graf = Negativt_vektet_graf()
        print("\nBellman-Ford: ")
        graf.bellman_ford()
        
    elif (x.lower() == "a"):
        exit()
        
    else:
        print("\nUgyldig svar.\n")
        x = "false"
