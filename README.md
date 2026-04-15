# Sudoku-Puzzle-Generator

Title: Sudoku Puzzle Generator
By: Denio Dema


Description: 
This program is an application that allows you to solve a 9x9 Sudoku Puzzle using Java. It adheres to the rules by making sure the numbers 1-9 appear exactly once in every column, row, and box. It uses recursive backtracking and with randomized placing to efficiently generate a unique puzzle every time.

How to run: 
Go to Java Sandbox, upload the code, and press Run.

How the board is generated: 

I started my board with 3 diagonal randomly filled-in boxes using a method because the rows and columns would be independent of each other before they could cause a problem. Then, I created a method fillCell() that could find numbers, randomize them, test them, and change them if they didn’t work in order throughout the board, stopping when a sequence is found. If, by some chance, a cell has no numbers that works within the position given, it returns false and the cell preceding it will try different values until it works. Therefore, my boolean method creates a history the board can follow to create a 9x9 functioning Sudoku Board.


List of files included in the project:
SudokuBoard.java
README.md
Design Document.docx