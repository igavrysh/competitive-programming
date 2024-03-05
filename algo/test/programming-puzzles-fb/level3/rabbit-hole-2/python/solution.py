 
from typing import List
from collections import defaultdict
from collections import deque

class Tarjan(object):
    def __init__(self, N, edges):
        self.edges = edges
        self.stack = []
        self.on_stack = [False]*N
        self.ids = [None]*N
        self.low = [None]*N
        self.cur_id = 0
        self.cycles = {}
        self.num_cycles = 0

    def tarjan(self, i):
        dfs = [i]
        while dfs:
            i = dfs[-1]
            if not self.on_stack[i]:
                self.stack.append(i)
                self.on_stack[i] = True
            # need to check since dfs could re-eval
            if self.ids[i] is None:
                self.ids[i] = self.cur_id
                self.low[i] = self.cur_id
                self.cur_id += 1
            for j in self.edges[i]:
                if self.ids[j] is None:  # if unvisited
                    dfs.append(j)
                    break
                if self.on_stack[j]:  # if it's on the stack it's been visited
                    self.low[i] = min(self.low[i], self.low[j])  # propagate low-link value

            if dfs[-1] != i:
                continue

            if self.ids[i] == self.low[i]:  # if we're at beginning of cycle
                cur_cycle = set()
                while self.on_stack[i]:
                    j = self.stack.pop()
                    self.low[j] = self.low[i]
                    self.on_stack[j] = False
                    cur_cycle.add(j)
                self.cycles[self.num_cycles] = cur_cycle
                self.num_cycles += 1
            dfs.pop()

    def tarjan_all(self, N):
        for i in range(N):
            if self.ids[i] is None:
                self.tarjan(i)

    def node_size(self, i):
        return len(self.cycles[i])


def getMaxVisitableWebpages(N: int, M: int, A: List[int], B: List[int]) -> int:
    edges = defaultdict(set)  # key: from_index, value: set{to_indices}
    for _from, _to in zip(A, B):
        # zero-index from and to nodes by subtracting 1
        edges[_from-1].add(_to-1)

    tarjan = Tarjan(N, edges)
    tarjan.tarjan_all(N)

    # replace all old node ids with new node ids represented by the cycle num
    old_id_to_new_id = {old_id: new_id
                        for new_id, old_ids in tarjan.cycles.items()
                        for old_id in old_ids}

    new_edges = defaultdict(set)
    for _from, _to_nodes in edges.items():
        new_from = old_id_to_new_id[_from]
        new_to_nodes = {old_id_to_new_id[_to] for _to in _to_nodes}
        new_to_nodes.discard(new_from)
        new_edges[new_from].update(new_to_nodes)

    # kahn's algorithm
    # we have num_cycles ids in the new nodes
    indegrees = [0]*tarjan.num_cycles
    for _from, _to_nodes in new_edges.items():
        for _to in _to_nodes:
            indegrees[_to] += 1

    queue = deque([i for i, c in enumerate(indegrees) if c == 0])
    longest_path = [tarjan.node_size(i) for i in range(tarjan.num_cycles)]
    while queue:
        i = queue.popleft()
        for j in new_edges[i]:
            longest_path[j] = max(longest_path[j], longest_path[i]+tarjan.node_size(j))
            indegrees[j] -= 1
            if indegrees[j] == 0:
                queue.append(j)
    return max(longest_path)
