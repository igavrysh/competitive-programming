# shamelessly borrowed solutions from here https://leetcode.com/discuss/interview-question/1929553/meta-stack-stabilization-2-interview
# O(N log N) solution by maintaining mergeable heaps to track the tot_size * B // (A + B) + 1th number and merge adjacent groups in O(log n) time.
#

from typing import List
# from itertools import count

class LeftistHeap:
    EMPTY = type("LeftistHeap", (), {'dist': 0})()
    __slots__ = ('val', 'left', 'right', 'dist')
    # cnt = count()

    def __init__(self, val):
        self.val = val
        self.left = self.EMPTY
        self.right = self.EMPTY
        self.dist = 1


def merge(x, y):
    # next(LeftistHeap.cnt)  # test time complexity is O(N log N)
    if x is LeftistHeap.EMPTY:
        return y
    if y is LeftistHeap.EMPTY:
        return x
    if x.val < y.val:  # keep the larger one as root
        x, y = y, x
    x.right = merge(x.right, y)
    if x.left.dist < x.right.dist:
        x.left, x.right = x.right, x.left
    x.dist = x.right.dist + 1
    return x


def pop(x):
    return merge(x.left, x.right)


def getMinimumSecondsRequired(N: int, R: List[int], A: int, B: int) -> int:
    def optimal_size(tot_size):
        """
        Proof:
        bigger is not better ==> opt*A - (tot-opt)*B >= 0
        smaller is not better ==> (tot-opt+1)*B - (opt-1) * A >= 0
        ==> tot * B/(A+B) <= opt <= tot * B/(A+B) + 1
        ==> opt = floor(tot * B/(A+B) + 1) is always correct
        """
        return tot_size * B // (A + B) + 1

    # Preprocessing: inflate all R[i] < i + 1 to R[i] = i + 1. Reason:
    # 1. The final size of R[i] must be R[i] >= i+1, otherwise the result will violate the rules,
    #   so this is essential. Since the order of the operations are not important, we do this at the beginning.
    # 2. If initially all R[i] >= i + 1, we can ignore the rule that radius > 0 since the optimal solution must
    #   satisfy that.
    pre_cost = 0
    for i in range(N):
        if R[i] < i + 1:
            pre_cost += (i + 1 - R[i]) * A
            R[i] = i + 1

    # Processing: find the optimal solution of disk 0..i and add new disks 1-by-1
    grp_start = []  # start idx of the groups (end = start of next group / end of disks)
    grp_offset_heap = []  # offset heap of the groups
    for i in range(N):  # O(N log N)
        # we first let the new disk to form a new group with only 1 disk
        curr_start = i
        curr_heap = LeftistHeap(R[i] - i)
        # every disc will append & pop at most once, so amortized O(1)
        while grp_offset_heap and grp_offset_heap[-1].val >= curr_heap.val:
            # if breaking the rule, we iteratively combine the current group
            #   with the last group to form a new current group
            curr_heap = merge(grp_offset_heap.pop(), curr_heap)  # O(log N)
            prev_start = grp_start.pop()
            pop_num = (optimal_size(i + 1 - curr_start)
                       + optimal_size(curr_start - prev_start)
                       - optimal_size(i + 1 - prev_start))  # prev_size + curr_size - merge_size, must be 0 or 1
            if pop_num:
                curr_heap = pop(curr_heap)
            curr_start = prev_start
        grp_start.append(curr_start)
        grp_offset_heap.append(curr_heap)

    # Sum up all the costs and the pre_cost
    ans = 0
    grp_start.append(N)
    for gi, heap_gi in enumerate(grp_offset_heap):
        offset = heap_gi.val
        for i in range(grp_start[gi], grp_start[gi + 1]):
            diff = R[i] - i - offset
            if diff > 0:  # True -> R[i] is too big, need to deflate
                ans += diff * B
            else:
                ans += -diff * A
    return ans + pre_cost
