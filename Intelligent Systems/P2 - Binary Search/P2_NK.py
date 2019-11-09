import math
import time
import os

print("What is the maximum range, 1 to ___?")
hi = int(input())
lo = 1
guess = 0
userInput = 1
tries = 0
triedNumbers = list()
maxTries = math.ceil(math.log(hi, 2))

while (userInput != 'y'):
    guess = (hi + lo)//2
    tries = tries + 1
    if (triedNumbers.count(guess)):
        print("I think you are messing with me!")
        break
    triedNumbers.append(guess)
    print(f"Is it {guess}? Tell me too high with >, too low with <, or y if I got it!")
    userInput = input()
    if (userInput == 'y'):
        print("Wow! I got it!")
    elif (userInput == '<'):
        lo = guess
    elif (userInput == '>'):
        hi = guess
    else:
        print("You entered something else, please start over.")
        break

print(f"I only tried {tries} times :) I had maximum of {maxTries} tries.")
print("Thanks for playing.")
