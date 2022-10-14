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

from distutils.log import error
import sys
from warnings import catch_warnings

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


class RettetGraf:  
    def __init__(self):
        self.noder = {}
        self.fil = "inputRettet.txt"
        self.filen = open(self.fil, "r")
        
        for linje in self.filen:
            self.biter = linje.split(":")
            kanter = self.biter[1].strip('\n').split(",")
            
            if self.biter[0] not in self.noder.keys():
                node = Node(self.biter[0])
            else:
                node = self.noder.get(self.biter[0])
        
            #Legger inn som navn:node i ordboken noder
            self.noder[self.biter[0]] = node
            
            if self.biter[1] != '':
                for kant in kanter:
                    if kant not in self.noder.keys():
                        kantnode = Node(kant)
                        self.noder[kant] = kantnode
                 
                    else:
                        kantnode = self.noder.get(kant)
               
                    node.kanter.append(kantnode)
                    node.utgrad += 1
                    kantnode.inngrad += 1
        
        self.TopSortering()
        
        
    #Topologisk sortering
    def TopSortering(self):
        stack = []
        output = []
    
        for node in self.noder:
            if self.noder[node].inngrad == 0:
                stack.append(self.noder[node])
        
        while len(stack) != 0:
            curNode = stack.pop()
            output.append(curNode.navn)
            
            for kant in curNode.kanter:
                curNode.kanter.remove(kant)
                if kant.inngrad == 0:
                    stack.append(kant)
        
        print(output)
        
        if len(output) < len(self.noder):
            print("ERROR: Graf inneholder en sykel og kan ikke sorteres topologisk")

    
class Node:
    def __init__(self, navn):
        self.navn = navn
        self.inngrad = 0
        self.utgrad = 0
        self.kanter = []
     
        

#HOVEDPROGRAM

try:
    if sys.argv[1] == "rettet":
        graf = RettetGraf()
        #graf.TopSortering()


except:
    graf = Graf()
    print("DybdeFoerst: ")
    graf.DFSoekHele()
    print("\nBreddeFoerst: ")
    graf.BFSoekHele()
    
