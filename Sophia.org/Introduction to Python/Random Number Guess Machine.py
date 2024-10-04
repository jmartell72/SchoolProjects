# Importing a module to generate random number
import random

# We are creating a random even number between 2 and 10 by
# first randomizing an integer between 1 and 5. This will be our
# final number. The number to add will take this final number and multiply it by 2.
randomFinalNumber = random.randrange(1, 5)
numberToAdd = randomFinalNumber * 2

# Asking the user to enter in their name
name = input("Hello! What is your name?")

# Script to walk through each of the steps
print("Welcome " + name + ", we’ll perform some mind reading on you.")
print("First, think of a number between 1 and 10.")

# testing code
# enteredNumber = int(input("Enter in a number between 1 and 10: "))

print("Multiply the result by 2")

# testing code
# userNumber = enteredNumber * 2
# print(">> userNumber at this step = " + str(userNumber))

answer = input("Ready for the next step? ")
print("Now, add...let's see...")
print(numberToAdd)

# testing code
# userNumber = userNumber + numberToAdd
# print(">> userNumber at this step = " + str(userNumber))

answer = input("Ready for the next step?")
print("Now, divide the number you have by 2.")

# testing code
# userNumber = userNumber / 2
# print(" >> userNumber at this step " + str(userNumber))

answer = input("Ready for the next step? ")
print("Now, subtract the original number that you thought about.")
answer = input("Ready for the last step? ")

# Guessing the number
print("Well " + name +
      ", let me read your mind...The number that you have right now is a...")
print(randomFinalNumber)

# testing code
# userNumber = userNumber - enteredNumber
# print('>> userNumber at this step = ' + str(userNumber))
