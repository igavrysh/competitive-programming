def bs(a: list, key: int) -> int:
    bad = -1
    good = len(a)
    while good - bad > 1:
        m = (good + bad) // 2
        if a[m] >= key:
            good = m
        else:
            bad = m
    return good

def bs_with_m_one(a: list, key: int) -> int:
    bad = -1
    good = len(a)
    while good - bad > 1:
        m = (good + bad) // 2
        if a[m] >= key:
            good = m
        else:
            bad = m
    if good < len(a) and a[good] == key:
        return good
    return -1

for key in range(10):
    print(bs([], key))