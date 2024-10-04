# the following code creates the board
board = [["-", "-", "-"],
         ["-", "-", "-"],
         ["-", "-", "-"]]

print(board[0])
print(board[1])
print(board[2])

# this is player X’s first move
col = int(input("X player, select a column 1-3: "))
row = int(input("X player, select a row 1-3: "))
col -= 1
row -= 1

board[row][col] = "X"
print(board[0])
print(board[1])
print(board[2])

# this is player O’s first move
col = int(input("O player, select a column 1-3: "))
row = int(input("O player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "O"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player X’s second move
col = int(input("X player, select a column 1-3: "))
row = int(input("X player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "X"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player O’s second move
col = int(input("O player, select a column 1-3: "))
row = int(input("O player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "O"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player X’s third move
col = int(input("X player, select a column 1-3: "))
row = int(input("X player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "X"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player O’s third move
col = int(input("O player, select a column 1-3: "))
row = int(input("O player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "O"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player X’s fourth move
col = int(input("X player, select a column 1-3: "))
row = int(input("X player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "X"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player O’s fourth move
col = int(input("O player, select a column 1-3: "))
row = int(input("O player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "O"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])

# this is player X’s fifth move
col = int(input("X player, select a column 1-3: "))
row = int(input("X player, select a row 1-3: "))
col -= 1
row -= 1

if board[row][col] == '-':
    board[row][col] = "X"
else:
    print("Oops, that spot was already taken. ")
print(board[0])
print(board[1])
print(board[2])
