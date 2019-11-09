import random

def randomizeNQ(size):
    board = list()
    while (len(board) < size):
        number = random.randint(0, size-1)
        containsNumber = False
        for x in range(len(board)):
            #print(f"About to compare {board[x]} and {number}.")
            if (board[x] is number):
                containsNumber = True
                #print("Number contains.")
                break
        if (containsNumber == False):
            #print("Number doesnt contain, so its added.")
            board.append(number)
    return board

def countConflicts2(board):
    size = len(board)
    #print(f"Bpard size is {size}")
    conflicts = 0
    for y in range(size): # check diagonal conflicts
        row = board[y]
        column = y
        #print(f"Column is {column}, row is {row}.")
        if (column < size):
            for x in range(size - 1 - column):
                checkColumn = column + 1 + x
                #print(f"Checking column #{checkColumn}")
                if (board[checkColumn] is (row + 1 + x)):
                    #print("There is diagonal problem")
                    conflicts = conflicts + 1
                if (board[checkColumn] is (row - 1 - x)):
                    #print("There is diagonal problem")
                    conflicts = conflicts + 1
        if (0 < column):
            for x in range(0 + column):
                checkColumn = column - 1 - x
                #print(f"Checking column #{checkColumn}")
                if (board[checkColumn] is (row + 1 + x)):
                    #print("There is diagonal problem")
                    conflicts = conflicts + 1
                if (board[checkColumn] is (row - 1 - x)):
                    #print("There is diagonal problem")
                    conflicts = conflicts + 1
    return conflicts

def drawBoard(list):
    print(f"Drawing board for {list}.")
    for row in range(len(list)):
        print("")
        for column in range(len(list)):
            if (list[column] is row):
                print("Q", end=" ")
            else:
                print("-", end=" ")
    print("")



def getNumber():
    print("Please enter a size for NxN board.")
    while True:
        try:
            N = int(input())
            if (3 < N <= 15):
                break
            elif(N > 15):
                print("You entered a large number, it might take from couple minutes to couple hours to finish the program.")
                print("Do you want to continue? y/n")
                answer = input()
                if (answer is 'y'):
                    break
                else:
                    print("Please enter another number.")
            else:
                print("Please enter number larger than 3.")
        except ValueError:
            print("Please enter a valid integer.")
    return N

iteration = 0
number = getNumber()
NQ = randomizeNQ(number)

while True:
    #print("Entered a loop.")
    #print(NQ)
    conflicts = countConflicts2(NQ)
    iteration = iteration + 1
    #print(f"There are {conflicts} of conflicts.")
    if (conflicts is 0):
        drawBoard(NQ)
        print(f"I went thru {iteration} iterations to get correct answer.")
        break
    else:
        random.shuffle(NQ)
