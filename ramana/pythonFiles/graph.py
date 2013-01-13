class Edge:
 def __init__(self, u, v):
  self.start = u
  self.end = v
  self.directed = False

 def makeDirected(self):
  self.directed = True

 def __eq__(self, other):
  return self.__dict__ == other.__dict__

class Vertex:
 def __init__(self, name):
  self.name = name
  self.adjacent = []

 def addAdjacentVertex(self, v):
  self.adjacent.append(v)

 def __eq__(self, other):
  return self.name == other.name

 def __hash__(self):
  return hash(self.name)

class Graph:
 def __init__(self):
  self.vertices = []
  self.edges = []

 def addVertex(self, v):
  self.vertices.append(v)
  for u in v.adjacent:
   e = Edge(v, u)
   if e not in self.edges:
    self.edges.append(e)


def areConnected(g, u, v):
 if u == v:
  return True
 explored = set()
 unexplored = []
 unexplored.append(u)
 while len(unexplored) > 0:
  x = unexplored.pop(0)
  if x in explored:
   continue
  if v in x.adjacent:
   return True
  unexplored.extend(x.adjacent)
  explored.add(x)
 return False
a = Vertex("a")
b = Vertex("b")
c = Vertex("c")
d = Vertex("d")
a.addAdjacentVertex(b)
a.addAdjacentVertex(d)
b.addAdjacentVertex(c)
g = Graph()
g.addVertex(a)
g.addVertex(b)
g.addVertex(c)
g.addVertex(d)

print areConnected(g, a, c)
print areConnected(g, c, d)
