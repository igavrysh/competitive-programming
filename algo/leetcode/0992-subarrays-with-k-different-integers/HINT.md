**Intuition:**

First you may have feeling of using sliding window.
Then this idea get stuck in the middle.

This problem will be a very typical sliding window,
if it asks the number of subarrays with at most `K` distinct elements.

Just need one more step to reach the folloing equation:

`exactly(K) = atMost(K) - atMost(K-1)`