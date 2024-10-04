# Import functions as needed
import numpy as np
import os
import platform
import random
import sys

# Basic card template
cardSetup = ["-", "-", "-", "-", "-", "-", "-", "-", "-", "-"]


# Function that will duplicate the amount of cards chosen to create pairs and then shuffle the cards
def buildNumberSystem(amountOfCards):
    # Create the blank list
    numberSystem = []

    # for each card, will start at 1 instead of 0
    for i in range(1, amountOfCards + 1):
        newStr = ""
        # adds a 0 in front of single digit numbers for formatting
        newStr = "0" + str(i) if i < 10 else str(i)
        # adds the formatted number twice for a pair
        numberSystem.append(newStr)
        numberSystem.append(newStr)

    # Shuffles the new numbers
    random.shuffle(numberSystem)

    # retuns the numberSystem for further use
    return numberSystem


# Function that will print the cards in a grid format
def createNewBoard(amountOfCards):
    # runs the numberSystem function for values
    numberSystem = buildNumberSystem(amountOfCards)

    # creates the board with the proper size as a 2x(Cardamount/10 + 2) multidemensional array
    board = [numberSystem[i:i + 10] for i in range(0, len(numberSystem), 10)]

    # starts the formatting for the board; i will be equal to the number of row
    for i in range(len(board)):
        # creates a holding line for the label of the rows and formats it appropriately
        if i + 1 < 10 or i == 9:
            hold = "Row: " + "0" + str(i)
        else:
            hold = "Row: " + str(i)
        # insert the Row labels so they are at the beginning of every row with cards
        board[i].insert(0, hold)
        # inserts after the new number a | for formatting
        board[i].insert(1, "|")
        # creates two new multidemensional arrays that will hold the two formatting multidemensional arrays
        build = [[]]
        underline = [[]]
        newStr = ""
        underStr = ""
        # creates another variable for the values inside of the inner array in the table
        for j in range(len(board[i])):
            # sets value/formatting for the first value of each new row
            if j == 0:
                newStr = "Col:   "
                underStr = "-------"
            # sets formatting for the second value of each new row
            elif j == 1:
                newStr = "|"
                underStr = "|"
            # sets formatting/value for the single digit numbers in the table
            elif (j < 11):
                newStr = "0" + str(j - 1)
                underStr = "--"
            # sets formatting/value for the double digit numbers in the table
            else:
                newStr = str(j - 1)
                underStr = "--"

            # inserts each new value at the appropriate index
            build[0].insert(j, newStr)
            underline[0].insert(j, underStr)

    # stacks the new rows on top of the board
    arr = np.vstack((build, underline, board))
    # returns the board
    return arr


# takes in the foundCards, board, and copyBoard which holds all the values
def obscureBoard(foundCards, board, copyBoard):
    # for each row in the table
    for i in range(len(board)):
        # excludes the two top rows of the table
        if (i > 1):
            # selects the values in the rows that actually contain data
            for j in range(len(board[i])):
                # excludes the two formatting values in the table
                if (j > 1):
                    # selects for each of the values that are in foundCards
                    for k in range(len(foundCards)):
                        newStr = ""
                        # sets check to the value
                        check = foundCards[k]
                        # formats that value if a single digit
                        if check < 10:
                            newStr = "0" + str(check)
                        else:
                            str(check)
                        # if the value is found in foundCards, will set that space to be ..
                        if copyBoard[i][j] == newStr:
                            board[i][j] = ".."
                            break
                        # else will default to [] for a flipped card
                        elif (k == len(foundCards) - 1):
                            board[i][j] = "[]"
    # returns the board
    return board


# reveals the cards chosen
def revealedCards(obscure, board, card1, card2):
    # default will not be a match
    match = False

    # selects the values of rows and columns for the cards selected by user for easy access
    card1Column = card1[0] + 1
    card1Row = card1[1] + 1

    card2Column = card2[0] + 1
    card2Row = card2[1] + 1

    # sets the BoardValue variable to be the boards value at the selected row
    card1BoardValue = board[card1Row][card1Column]
    card2BoardValue = board[card2Row][card2Column]

    # sets match to true if true
    if card1BoardValue == card2BoardValue:
        match = True

    # Sets an obscure board to return just these two cards locations
    obscure[card1Row][card1Column] = card1BoardValue
    obscure[card2Row][card2Column] = card2BoardValue

    return obscure, card1BoardValue, card2BoardValue, match


# starts the main game function
def game():
    # global variables for the game
    user = ""
    difficultyStr = ""
    difficultyValue = 0
    cards = ""

    # mainMenu
    def mainMenu():
        # can read the global variables
        global user
        global difficultyStr
        global difficultyValue
        global cards

        # if all else fails, will display a default user
        if user == "":
            choice = input(
                "Welcome defaultUser to Memory! Please choose from the following options:\n1. Play a New Game\n2. Run setup again\n3. Quit\n>"
            )
            choice = int(choice)
            # greets user
        else:
            choice = input(
                "Welcome " + user +
                " to Memory! Please choose from the following options:\n1. Play a New Game\n2. Run setup again\n3. Quit\n>"
            )
            choice = int(choice)

        # Play New game
        if choice == 1:
            newGame()

        # Run Setup
        elif choice == 2:
            setup()

        # Quit
        elif choice == 3:
            sys.exit()
        # Anything else restarts the mainMenu
        mainMenu()

    # Used to reload the setting from file
    def reloadSettings():
        # global variable
        global user
        global difficultyStr
        global difficultyValue
        global cards

        # trys to read the file if available
        try:
            # opens the settings file
            with open("./settings.data", "r") as f:
                holdStr = f.read()
                # if the file has contents will load them into the game
                if holdStr:
                    # splits the variables into a list for assignment
                    holdList = holdStr.split(",")
                    # sets the variables accordingly
                    user = holdList[0]
                    difficultyStr = holdList[1]
                    difficultyValue = int(holdList[2])
                    cards = holdList[3]
                    # returns to the mainMenu once done
                    mainMenu()
        # if file is not found will go to setup
        except (FileNotFoundError, ValueError):
            setup()

    # runs the setups for the game
    def setup():
        # global variables
        global user
        global difficultyStr
        global difficultyValue
        global cards

        print('\nWelcome to setup!\n')
        # sets the userName
        user = input("What is your Username?\n>")

        # default no cards
        cards = 0
        # makes sure cards is in proper format so no logical errors occur
        while (cards == 0 or cards % 10 != 0 or cards > 100):
            # different options for different language flavor but will repeat asking for cards until proper
            if cards > 100:
                cards = int(
                    input(
                        "\nError! You can select up to 100 cards for this game. Please Try again:\n>"
                    ))
            elif cards == 0:
                cards = int(
                    input(
                        "\nHow many Cards do you want to play with? (Multiples of 10):\n>"
                    ))
            elif cards % 10 != 0:
                cards = int(
                    input(
                        "\nWhoops! You need to put in a number that is divisible by 10! Try again:\n>"
                    ))

        difficultyStr = ""
        difficultyValue = 0

        # sets the difficulty dynamically based on amount of cards chosen
        easyCalc = cards * .8
        medCalc = cards * .6
        hardCalc = cards * .4
        # until difficulty is one of three values, repeats
        while difficultyStr not in ["Easy", "Medium", "Hard"]:
            difficultyStr = input(
                "\nWhich difficulty would you like to choose (Exact Name!)?\n\nEasy: "
                + str(int(easyCalc)) + " lives\nMedium: " + str(int(medCalc)) +
                " lives\nHard: " + str(int(hardCalc)) +
                " lives\n\n>").capitalize()
            print()
            # sets values based on difficulty chosen
            if difficultyStr == "Easy":
                difficultyValue = int(easyCalc)
            if difficultyStr == "Medium":
                difficultyValue = int(medCalc)
            if difficultyStr == "Hard":
                difficultyValue = int(hardCalc)

        # overwrites any settings and inserts the user
        f = open("./settings.data", "w")
        f.write(user + ",")
        f.close()

        # appends the rest of the settings
        f = open("./settings.data", "a")
        f.write(difficultyStr + ",")
        f.write(str(difficultyValue) + ",")
        f.write(str(cards))
        f.close()
        # returns to main menu
        mainMenu()

    # newGame
    def newGame():
        # global variables
        global difficultyValue
        global difficultyStr
        global cards
        global user

        # internal function that will clear the console upon the next turn
        def consoleClear():
            # sets a clear condition for either windows or linux
            def clear(): return os.system('clear')
            def clear1(): return os.system('cls')
            name = platform.system()
            # runs either condition based upon os
            if name == 'Windows':
                return clear1()
            else:
                return clear()

        # renames difficulty for easier access
        lives = difficultyValue
        # default will be a loss
        win = False
        # no cards found by default
        foundCards = [0]
        # creates the new board
        board = createNewBoard(int(cards))
        # creates a copy so values are always available
        copyBoard = board.copy()

        # place holder for later
        col_row = ""

        # while there are still lives left
        while (lives > 0):
            card1 = []
            card2 = []
            # prints a formatted obscured board out
            consoleClear()
            print(*obscureBoard(foundCards, board, copyBoard), sep='\n')

            # retrieves the board row and column lengths in the table for verfication purposes
            stringBoardLengths = str(len(board[0]) -
                                     2) + "," + str(len(board) - 2)

            # internal function for formatting the coordinates used in this game
            def formatter(string):
                hold = string.split(",")
                hold[0] = int(hold[0])
                hold[1] = int(hold[1])
                return hold

            # formats the table dimensions
            bLengths = formatter(stringBoardLengths)

            x = 0
            # this function will loop and make sure that card1 and card2 are chosen appropriately
            while (x <= 1):
                # requests a value for the card in a specific format
                col_row = input(
                    "\nTime to pick a card! Please enter a column and then row number (ie 1,4 ) (X to exit the game):\n>"
                )
                # attempts to format the card and verify it
                try:
                    if col_row.lower() == "x":
                        sys.exit()
                    # runs the new value through the formatter
                    col_row = formatter(col_row)
                    # if the values selected are below the table constraints
                    if not ((col_row[0] > bLengths[0]) or
                            (col_row[1] > bLengths[1])):
                        # if x is still 0, will set card1
                        if x == 0:
                            card1 = col_row
                            x = 1

                        # if x is 1, will start card2
                        elif x == 1:
                            card2 = col_row
                            # if card2 is not the same as card1, will break the loop
                            if not (card1 == card2):
                                x = 2
                            # else will reset card2 to try again
                            else:
                                x = 1
                                print(
                                    "\nCard 2 cannot be the same as Card 1; Try again!\n Card 1 is located at "
                                    + str(card1))
                    # if cards are out of bounds, will reset to card 1 again
                    else:
                        print("\nPlease enter a card that is within bounds!")
                # if anything that is not formatted properly is inputted, will reset to card 1 again
                except SystemExit:
                    print('\nTootles')
                    sys.exit()
                except:
                    print("\nInvalid Input! Try again!")

            # sets an obscure board for use in revealing cards
            obscure = obscureBoard(foundCards, board, copyBoard)
            # reveals the cards selected
            obscure, card1BoardValue, card2BoardValue, match = revealedCards(
                obscure, copyBoard, card1, card2)
            # prints a the newly formatted obscured board
            print(*obscure, sep='\n')

            # if the revealedCards match will run these
            if match == True:
                # displays the cards that were found
                input("\nMatch Found! " + str(card1BoardValue) +
                      "'s removed from the board. Press any key to continue!")
                # adds the cards to the found cards array
                foundCards.append(int(card1BoardValue))
                foundCards.append(int(card1BoardValue))
                # clears the console
                consoleClear()
                # checks to see if all the cards have been found and then win
                if len(foundCards) - 1 == cards:
                    win = True
                    break
            # if not a match
            else:
                # deducts a life
                lives -= 1
                # outputs how many lives are left
                input("\nIncorrect! Minus 1 Lives; your Lives now are: " +
                      str(lives) + ". Press any key to continue!")
                # clears the console
                consoleClear()

        # after either all lives are lost or a win is declared
        if win == True:
            while (True):
                # displays how many lives were left
                input(("\nCongratulations, you won! You had " + str(lives) +
                       " lives left."))
        # else you lose
        else:
            print("\nSorry you lost!")
        #  determines to either go back to Main Menu or Exit program
        while (True):
            choice = input(
                "\nWould you like to return to the Main Menu (MM) or Exit (X): "
            )
            if choice == "MM" or choice == "mm":
                mainMenu()
            elif choice == "X" or choice == "x":
                sys.exit()

    # when game is ran, it will reloadSettings() to set all global values and then run the mainMenu
    reloadSettings()
    mainMenu()


# runs the game
game()
