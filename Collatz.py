# Determine largest number > 2 billion which takes fewer
# collatz calls than any smaller natural number.


class Collatz:

    callCounts = {}

    def __init__(self):
        self.callCounts[0] = 0
        self.callCounts[1] = 1

    def go(self):
        self.collatzCallCounter(3)
        self.collatzCallCounter(5)
        self.collatzCallCounter(1723519)
        self.collatzCallCounter(2000001)
        max_call_count = 0
        trigger = 0
        import time
        start = time.time()
        for i in range(1, 50000000):
            self.callCounts[i] = self.collatzCallCounter(i)
            if self.callCounts[i] > max_call_count:
                trigger = i
                max_call_count = self.callCounts[i]
        print("trigger: " + str(trigger))
        print("count: " + str(max_call_count))
        print("Run time: " + str(time.time() - start))

    def collatzCallCounter(self, target):
        count = 1
        while target != 1:
            if target in self.callCounts:
                count += self.callCounts[target]
                break
            else:
                if target % 2 == 0:  # Even
                    count += 1
                    target = target // 2
                else:
                    count += 1
                    target = (target * 3) + 1
            continue
        return count


c = Collatz()
c.go()

# trigger: 837799
# count: 525
# 25.375
# AFTER MEMOIZATION
# 2.605
