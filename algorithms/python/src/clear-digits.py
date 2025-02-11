class Solution:
    def clearDigits(self, s: str) -> str:
        i = 0
        while i < len(s):
            if s[i].isdigit():
                j = i - 1
                while j >= 0 and s[j].isdigit():
                    j -= 1
                
                if j >= 0:
                    s = s[:j] + s[i+1:]
                else:
                    s = s[i+1:]
                i = 0  # Reset to 0 after modification
            else:
                i += 1  # Only increment i if no modification was made
        return s
