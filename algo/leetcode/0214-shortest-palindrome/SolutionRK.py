class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        end = self.RabinKarp(s)
        return s[end + 1:][::-1] + s
    
    def RabinKarp(self, s):
        mod = 10 ** 9 + 7
        a = 26
        n = len(s)
        al = 1
        s_h = 0 #source hash
        t_h = 0 #target hash
        ans = float('inf')
        for i in range(n):
            if i > 0:
                al = (al * a) % mod #note that al must be 1 to start with or the fist palindrome will be missing
            s_h = (s_h * a + ord(s[i])) % mod
            t_h = (t_h + ord(s[i]) * al) % mod
            if s_h == t_h:
                if s[:i + 1] == s[:i + 1][::-1]:
                    ans = i
        return ans
