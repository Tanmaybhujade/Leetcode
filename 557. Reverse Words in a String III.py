class Solution:
    def reverseWords(self, s: str) -> str:
        f = ''
        b = s.split()
        for i in b:
            f += i[::-1]+ " "
        return f.rstrip(" ")
