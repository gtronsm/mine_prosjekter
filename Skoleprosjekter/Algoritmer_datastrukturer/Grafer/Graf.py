#Dybde-først soek foelger en vilkaarlig sti vekk fra en gitt startnode
#Naar den ikke kan finne en ubesøkt node sporer den stien tilbake
#I hvert ledd forsoeker den aa foelge nye noder som leder vekk fra noden den er i


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


    def DFSsoek(self, startnode, besoekt):
        pass


graf = Graf()
graf.DFSoek('A', None)