import random

correctGuessedNumbers = list()
wrongGuessedNumbers = list()
userResponse = 'Y'

while userResponse == 'Y':
    x = random.randint(1,100)
    print(f"Try to guess a number between 1 and 100. What is your guess?")
    wrongNumber = True
    while wrongNumber:
        userTestNum = input()
        try:
            userNum = int(userTestNum)
            if userNum == x:
                print("Great job you guessed the number.")
                wrongNumber = False
                correctGuessedNumbers.append(x)
            else:
                print(f"You didnt guess the number.")
                wrongGuessedNumbers.append(userNum)
                wrongNumber = True
                if userNum > x:
                    print("Your number is too high.")
                elif userNum < x:
                    print("Your number is too low.")
                print("Try again.")
        except ValueError:
            #Handle the exception
            print('This is not an integer. Please enter an integer.')
    print("Do you wish to continue? Y/N")
    userResponse = input()

print("You quited the game. Here are your statistics:")
print(f"You correctly guessed {len(correctGuessedNumbers)} numbers.")
print(f"Your correct guesses were {correctGuessedNumbers}.")
print(f"Your wrong guesses were {wrongGuessedNumbers}.")
print("The program now terminates.")
