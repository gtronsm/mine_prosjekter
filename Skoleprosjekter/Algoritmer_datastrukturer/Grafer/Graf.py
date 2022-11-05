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

from collections import defaultdict


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
        self.fil = "inputVektet.txt"
        self.filen = open(self.fil, "r")
        
        for linje in self.filen:
            self.biter = linje.strip('\n').split()
            self.vekt = self.biter[1]
            self.nodene = self.biter[0].split("-")
            
            if self.nodene[0] not in self.noder.keys():
                print(self.nodene[0], "IKKE FRA FOER")
                node1 = Node(self.nodene[0])
                self.noder[self.nodene[0]] = node1
                
                if self.nodene[1] not in self.noder.keys():
                    print(self.nodene[1], "IKKE FRA FOER")
                    node2 = Node(self.nodene[1])
                    self.noder[self.nodene[1]] = node2

                    node1.vektKanter[node2] = float(self.vekt)
                    node2.vektKanter[node1] = float(self.vekt)
                
                else:
                    self.noder.get(self.nodene[0]).vektKanter[self.noder.get(self.nodene[1])] = float(self.vekt)
                    self.noder.get(self.nodene[1]).vektKanter[self.noder.get(self.nodene[0])] = float(self.vekt)
                    
            else:
                if self.nodene[1] not in self.noder.keys():
                    print(self.nodene[1], "IKKE FRA FOER")
                    node2 = Node(self.nodene[1])
                    self.noder[self.nodene[1]] = node2
                    
                    self.noder.get(self.nodene[0]).vektKanter[node2] = float(self.vekt)
                    node2.vektKanter[self.noder.get(self.nodene[0])] = float(self.vekt)
                    
                else:
                    self.noder.get(self.nodene[0]).vektKanter[self.noder.get(self.nodene[1])] = float(self.vekt)
                    self.noder.get(self.nodene[1]).vektKanter[self.noder.get(self.nodene[0])] = float(self.vekt)

        for node in self.noder.keys():
            print(self.noder.get(node).navn , "sine kanter: ")
            for kant in self.noder.get(node).vektKanter:
                print(kant.navn)
            
            print(self.noder.get(node).vektKanter)

    def Dijkstra(self):
        #Tar egentlig inn en startnode, men her setter vi den bare
        startnode = self.noder.get(0)
        
        visited = set()
        dist = defaultdict(lambda: float('inf'))
        
        
        pass
            
    

class Node:
    def __init__(self, navn):
        self.navn = navn
        self.inngrad = 0
        self.utgrad = 0
        self.kanter = []
        self.vektKanter = {}
     
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
    
    elif (x.lower() == "n"):
        pass
        
    elif (x.lower() == "a"):
        exit()
        
    else:
        print("\nUgyldig svar.\n")
        x = "false"
