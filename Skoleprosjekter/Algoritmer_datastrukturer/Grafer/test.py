class Graf:
    
    def __init__(self):
        self.noder = set()
        self.kanterListe = {"A":["B"], "B":["A", "C", "D"], "C":["B", "D"], "D":["C", "B"]}
      
        
        self.noder.add("A")
        self.noder.add("B")
        self.noder.add("C")
        self.noder.add("D")
            
    def separationnodes_rec(self, noder, kanter, u, d, depth, low, seps):
        depth[u] = low[u] = d
        for v in kanter[u]:
            if v in depth:
                print("Vi skal fra", u, "til", v)
                low[u] = min(low[u], depth[v])
                continue
            self.separationnodes_rec(noder, kanter, v, d + 1, depth, low, seps)
            low[u] = min(low[u], low[v])
            if d <= low[v]:
                seps.add(u)

    def separationnodes(self):
        noder = self.noder
        kanter = self.kanterListe
    
        s = "A"
        depth = {s: 0}
        low = {s: 0}
        seps = set()

        for u in kanter[s]:
            if u not in depth:
                self.separationnodes_rec(noder, kanter, u, 1, depth, low, seps)

        if len([u for u in kanter[s] if depth[u] == 1]) > 1:
            seps.add(s)

        print("\nDette er nodene sin low, altsa hvor langt opp den kan naa")
        print(low)

        return seps
    

graf = Graf()
print("Separasjonsnoder: ", graf.separationnodes())