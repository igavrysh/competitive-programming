# shamelessly borrowed solutions from here https://leetcode.com/discuss/interview-question/1929553/meta-stack-stabilization-2-interview
#

from typing import List
def getMinimumSecondsRequired(N: int, R: List[int], A: int, B: int) -> int:
    BIG = 10 ** 16
    # offset = adjusted R[i] - i
    # offset is a) the same in a tight group, b) different in 2 tight groups that are loose, 
    # and c) non-decreasing when `i` increases,
    def grp_cost(l, r, offset):
        c = 0
        for i in range(l, r):
            diff = R[i] - i - offset
            if diff > 0:  # True -> R[i] is too big
                c += diff * B
            else:
                c += -diff * A
        return c
    def grp_best_offset(l, r):
        # there must exists a best_cost without changing the size of one disk.
        best_cost = BIG
        best_offset = None
        for i in range(l, r):
            offset = R[i] - i
            cost = grp_cost(l, r, offset)
            if cost < best_cost:
                best_cost, best_offset = cost, offset
        return best_offset

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
    grp_offset = []  # optimal offset of the groups
    for i in range(N):  # O(N**3)
        # we first let the new disk to form a new group with only 1 disk
        curr_start = i
        curr_offset = R[i] - i
        while grp_offset and grp_offset[-1] >= curr_offset:  # every disc will append & pop at most once, so amortized O(1)
            # if breaking the rule, we iteratively combine the current group
            #   with the last group to form a new current group
            grp_offset.pop()
            curr_start = grp_start.pop()
            curr_offset = grp_best_offset(curr_start, i + 1)  # O(N**2)
        grp_start.append(curr_start)
        grp_offset.append(curr_offset)

    # Sum up all the costs and the pre_cost
    ans = 0
    grp_start.append(N)
    for i in range(len(grp_offset)):
        ans += grp_cost(grp_start[i], grp_start[i + 1], grp_offset[i])
    return ans + pre_cost