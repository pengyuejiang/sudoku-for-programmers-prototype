# sudoku-for-programmers-prototype
## Introduction

This is an automated Sudoku puzzle solver for 16x16 Sudoku puzzles from 0 to F. It serves as a core functionality that will later be migrated to **Sudoku for Programmers** project.

## Features

1. The console output contains comprehensive information regarding the process of solving the puzzle.
2. The entire puzzle is printed once per step so the user can keep track of the progress of the puzzle.
3. This program has an easily extendable framework that can be used for larger sizes of puzzles with similar natures.
4. This program contains a run time timer that keeps track of the run time.

## Notes

1. The puzzle is stored in the file `sudoku.txt`, where `.` is used to represent an empty cell. This is not mandatory, feel free to change it into any other symbols other than candidate numbers.

## Appendix - Sample Console Output

```
[., ., ., ., ., 4, ., ., A, 8, E, D, ., ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., ., ., 1, ., ., ., ., .] 
[., ., 0, A, 2, ., ., ., ., ., 4, ., ., 9, ., C] 
[., ., ., E, ., 9, 6, ., 0, ., ., ., 7, 5, ., F] 
[8, B, ., ., ., ., D, ., 4, 6, ., ., ., ., ., A] 
[., A, ., 5, ., ., ., ., ., ., 7, ., ., ., ., .] 
[C, F, ., 2, 9, ., ., 7, E, ., D, ., 1, ., ., .] 
[0, ., ., 6, ., ., ., ., ., ., ., 1, ., ., 7, 9] 
[., 2, ., B, 7, 5, ., ., ., ., ., C, 3, 4, ., .] 
[., ., 3, ., ., 0, ., ., ., 2, ., ., ., ., ., .] 
[D, 9, C, ., ., ., 4, 8, ., ., ., 3, ., ., ., 6] 
[., 7, 8, ., C, 3, ., 9, F, ., 5, ., ., E, D, 0] 
[7, ., ., ., F, ., 8, 0, 3, 4, ., ., ., ., ., .] 
[., ., A, ., B, 1, ., ., 5, ., ., 7, E, ., ., .] 
[., 5, ., ., A, 6, 2, C, D, ., ., 0, B, ., ., .] 
[B, ., ., ., ., ., ., 3, ., A, 8, ., ., ., 0, .] 
Hidden single of 5 at R0C2B0 (from 0)
Removing Row Possibility of 5 in cell (0, 0)
Removing Row Possibility of 5 in cell (0, 4)
Removing Row Possibility of 5 in cell (0, 6)
Removing Row Possibility of 5 in cell (0, 7)
Removing Block Possibility of 5 in cell (2, 0)
Hidden single of 7 at R0C3B0 (from 0)
Removing Row Possibility of 7 in cell (0, 6)
Removing Column Possibility of 7 in cell (4, 3)
Naked single of 0 at R0CcB3 (from 0)
Removing Row Possibility of 0 in cell (0, d)
Removing Column Possibility of 0 in cell (4, c)
Removing Column Possibility of 0 in cell (5, c)
Hidden single of d at R2CcB3 (from 0)
Removing Row Possibility of d in cell (2, 5)
Removing Row Possibility of d in cell (2, 7)
Removing Column Possibility of d in cell (5, c)
Removing Column Possibility of d in cell (7, c)
Removing Column Possibility of d in cell (c, c)
Removing Column Possibility of d in cell (f, c)
Hidden single of b at R3C2B0 (from 0)
Removing Row Possibility of b in cell (3, 7)
Removing Row Possibility of b in cell (3, 9)
Removing Row Possibility of b in cell (3, a)
Removing Row Possibility of b in cell (3, b)
Removing Row Possibility of b in cell (3, e)
Naked single of 2 at R3CbB2 (from 0)
Removing Row Possibility of 2 in cell (3, a)
Removing Column Possibility of 2 in cell (4, b)
Removing Column Possibility of 2 in cell (5, b)
Removing Column Possibility of 2 in cell (c, b)
Removing Column Possibility of 2 in cell (f, b)
Hidden single of 4 at R3CeB3 (from 0)
Removing Column Possibility of 4 in cell (5, e)
Removing Column Possibility of 4 in cell (6, e)
Removing Column Possibility of 4 in cell (d, e)
Removing Column Possibility of 4 in cell (e, e)
Hidden single of 7 at R4C2B4 (from 0)
Naked single of 4 at R6C2B4 (from 0)
Removing Row Possibility of 4 in cell (6, f)
Removing Column Possibility of 4 in cell (5, 2)
Removing Column Possibility of 4 in cell (7, 2)
Removing Column Possibility of 4 in cell (e, 2)
Removing Column Possibility of 4 in cell (f, 2)
Removing Block Possibility of 4 in cell (5, 0)
Removing Block Possibility of 4 in cell (7, 1)
Hidden single of 6 at R6CdB7 (from 0)
Removing Column Possibility of 6 in cell (5, d)
Removing Column Possibility of 6 in cell (c, d)
Removing Column Possibility of 6 in cell (d, d)
Removing Column Possibility of 6 in cell (f, d)
Removing Block Possibility of 6 in cell (5, c)
Hidden single of d at R7C1B4 (from 0)
Removing Row Possibility of d in cell (7, d)
Removing Column Possibility of d in cell (c, 1)
Removing Column Possibility of d in cell (d, 1)
Removing Column Possibility of d in cell (f, 1)
Naked single of e at R7C2B4 (from 0)
Removing Row Possibility of e in cell (7, 4)
Removing Row Possibility of e in cell (7, 5)
Removing Row Possibility of e in cell (7, 6)
Removing Row Possibility of e in cell (7, 7)
Removing Column Possibility of e in cell (5, 2)
Removing Column Possibility of e in cell (8, 2)
Removing Column Possibility of e in cell (c, 2)
Removing Column Possibility of e in cell (e, 2)
Removing Column Possibility of e in cell (f, 2)
Removing Block Possibility of e in cell (5, 0)
Hidden single of d at R8C9Ba (from 0)
Removing Row Possibility of d in cell (8, 7)
Hidden single of 0 at R8CaBa (from 0)
Removing Column Possibility of 0 in cell (4, a)
Removing Column Possibility of 0 in cell (a, a)
Removing Block Possibility of 0 in cell (a, 9)
Hidden single of 5 at R9C0B8 (from 0)
Removing Row Possibility of 5 in cell (9, c)
Removing Row Possibility of 5 in cell (9, e)
Removing Row Possibility of 5 in cell (9, f)
Hidden single of 0 at RaC3B8 (from 0)
Removing Column Possibility of 0 in cell (d, 3)
Hidden single of 2 at RaC5B9 (from 0)
Removing Row Possibility of 2 in cell (a, c)
Removing Row Possibility of 2 in cell (a, d)
Removing Row Possibility of 2 in cell (a, e)
Removing Column Possibility of 2 in cell (4, 5)
Removing Column Possibility of 2 in cell (5, 5)
Removing Column Possibility of 2 in cell (7, 5)
Naked single of 1 at RbC3B8 (from 0)
Removing Row Possibility of 1 in cell (b, 0)
Removing Row Possibility of 1 in cell (b, 6)
Removing Row Possibility of 1 in cell (b, 9)
Removing Column Possibility of 1 in cell (4, 3)
Removing Column Possibility of 1 in cell (9, 3)
Removing Column Possibility of 1 in cell (c, 3)
Removing Column Possibility of 1 in cell (e, 3)
Removing Column Possibility of 1 in cell (f, 3)
Removing Block Possibility of 1 in cell (8, 0)
Removing Block Possibility of 1 in cell (8, 2)
Removing Block Possibility of 1 in cell (9, 1)
Naked single of b at RbC9Ba (from 0)
Removing Row Possibility of b in cell (b, 6)
Removing Row Possibility of b in cell (b, b)
Removing Column Possibility of b in cell (1, 9)
Removing Column Possibility of b in cell (2, 9)
Removing Column Possibility of b in cell (5, 9)
Removing Column Possibility of b in cell (6, 9)
Removing Column Possibility of b in cell (7, 9)
Removing Column Possibility of b in cell (a, 9)
Removing Block Possibility of b in cell (9, 8)
Removing Block Possibility of b in cell (9, a)
Removing Block Possibility of b in cell (9, b)
Removing Block Possibility of b in cell (a, 8)
Removing Block Possibility of b in cell (a, a)
Hidden single of 2 at RbCcBb (from 0)
Removing Column Possibility of 2 in cell (4, c)
Removing Column Possibility of 2 in cell (5, c)
Removing Column Possibility of 2 in cell (7, c)
Removing Column Possibility of 2 in cell (c, c)
Removing Column Possibility of 2 in cell (f, c)
Hidden single of 0 at RdC1Bc (from 0)
Naked single of 9 at RdC6Bd (from 0)
Removing Row Possibility of 9 in cell (d, 0)
Removing Row Possibility of 9 in cell (d, 3)
Removing Row Possibility of 9 in cell (d, 9)
Removing Row Possibility of 9 in cell (d, a)
Removing Row Possibility of 9 in cell (d, e)
Removing Column Possibility of 9 in cell (f, 6)
[., ., 5, 7, ., 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., ., ., 1, ., ., ., ., .] 
[., ., 0, A, 2, ., ., ., ., ., 4, ., D, 9, ., C] 
[., ., B, E, ., 9, 6, ., 0, ., ., 2, 7, 5, 4, F] 
[8, B, 7, ., ., ., D, ., 4, 6, ., ., ., ., ., A] 
[., A, ., 5, ., ., ., ., ., ., 7, ., ., ., ., .] 
[C, F, 4, 2, 9, ., ., 7, E, ., D, ., 1, 6, ., .] 
[0, D, E, 6, ., ., ., ., ., ., ., 1, ., ., 7, 9] 
[., 2, ., B, 7, 5, ., ., ., D, 0, C, 3, 4, ., .] 
[5, ., 3, ., ., 0, ., ., ., 2, ., ., ., ., ., .] 
[D, 9, C, 0, ., 2, 4, 8, ., ., ., 3, ., ., ., 6] 
[., 7, 8, 1, C, 3, ., 9, F, B, 5, ., 2, E, D, 0] 
[7, ., ., ., F, ., 8, 0, 3, 4, ., ., ., ., ., .] 
[., 0, A, ., B, 1, 9, ., 5, ., ., 7, E, ., ., .] 
[., 5, ., ., A, 6, 2, C, D, ., ., 0, B, ., ., .] 
[B, ., ., ., ., ., ., 3, ., A, 8, ., ., ., 0, .] 
Hidden single of 9 at R0C0B0 (from 0)
Removing Column Possibility of 9 in cell (5, 0)
Removing Column Possibility of 9 in cell (e, 0)
Hidden single of f at R2C0B0 (from 0)
Removing Row Possibility of f in cell (2, 5)
Removing Row Possibility of f in cell (2, 6)
Removing Row Possibility of f in cell (2, 7)
Removing Row Possibility of f in cell (2, 9)
Removing Row Possibility of f in cell (2, b)
Removing Column Possibility of f in cell (8, 0)
Removing Column Possibility of f in cell (d, 0)
Removing Column Possibility of f in cell (e, 0)
Hidden single of a at R3C7B1 (from 0)
Removing Column Possibility of a in cell (1, 7)
Removing Column Possibility of a in cell (7, 7)
Removing Column Possibility of a in cell (8, 7)
Removing Column Possibility of a in cell (9, 7)
Removing Block Possibility of a in cell (1, 5)
Removing Block Possibility of a in cell (1, 6)
Hidden single of 0 at R4CdB7 (from 0)
Removing Column Possibility of 0 in cell (5, d)
Naked single of f at R9C3B8 (from 0)
Removing Row Possibility of f in cell (9, 6)
Removing Row Possibility of f in cell (9, 7)
Removing Row Possibility of f in cell (9, c)
Removing Row Possibility of f in cell (9, d)
Removing Row Possibility of f in cell (9, e)
Removing Column Possibility of f in cell (d, 3)
Removing Column Possibility of f in cell (e, 3)
Removing Column Possibility of f in cell (f, 3)
Removing Block Possibility of f in cell (8, 2)
Naked single of a at RaCaBa (from 0)
Removing Row Possibility of a in cell (a, c)
Removing Row Possibility of a in cell (a, d)
Removing Row Possibility of a in cell (a, e)
Removing Column Possibility of a in cell (7, a)
Removing Column Possibility of a in cell (9, a)
Removing Block Possibility of a in cell (9, b)
Removing Block Possibility of a in cell (b, b)
Naked single of a at RbC6B9 (from 0)
Removing Row Possibility of a in cell (b, 0)
Removing Column Possibility of a in cell (6, 6)
Removing Column Possibility of a in cell (7, 6)
Removing Column Possibility of a in cell (8, 6)
Removing Column Possibility of a in cell (9, 6)
[9, ., 5, 7, ., 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., ., ., 1, ., ., ., ., .] 
[F, ., 0, A, 2, ., ., ., ., ., 4, ., D, 9, ., C] 
[., ., B, E, ., 9, 6, A, 0, ., ., 2, 7, 5, 4, F] 
[8, B, 7, ., ., ., D, ., 4, 6, ., ., ., 0, ., A] 
[., A, ., 5, ., ., ., ., ., ., 7, ., ., ., ., .] 
[C, F, 4, 2, 9, ., ., 7, E, ., D, ., 1, 6, ., .] 
[0, D, E, 6, ., ., ., ., ., ., ., 1, ., ., 7, 9] 
[., 2, ., B, 7, 5, ., ., ., D, 0, C, 3, 4, ., .] 
[5, ., 3, F, ., 0, ., ., ., 2, ., ., ., ., ., .] 
[D, 9, C, 0, ., 2, 4, 8, ., ., A, 3, ., ., ., 6] 
[., 7, 8, 1, C, 3, A, 9, F, B, 5, ., 2, E, D, 0] 
[7, ., ., ., F, ., 8, 0, 3, 4, ., ., ., ., ., .] 
[., 0, A, ., B, 1, 9, ., 5, ., ., 7, E, ., ., .] 
[., 5, ., ., A, 6, 2, C, D, ., ., 0, B, ., ., .] 
[B, ., ., ., ., ., ., 3, ., A, 8, ., ., ., 0, .] 
Hidden single of d at R3C4B1 (from 0)
Removing Column Possibility of d in cell (9, 4)
Removing Column Possibility of d in cell (f, 4)
Hidden single of a at R6CbB6 (from 0)
Removing Row Possibility of a in cell (6, 5)
Hidden single of a at R7C5B5 (from 0)
Hidden single of a at R8C0B8 (from 0)
Removing Row Possibility of a in cell (8, e)
Naked single of 6 at R8C2B8 (from 0)
Removing Row Possibility of 6 in cell (8, 7)
Removing Row Possibility of 6 in cell (8, 8)
Removing Column Possibility of 6 in cell (c, 2)
Removing Column Possibility of 6 in cell (f, 2)
Removing Block Possibility of 6 in cell (b, 0)
Hidden single of e at R9C1B8 (from 0)
Removing Row Possibility of e in cell (9, 4)
Removing Row Possibility of e in cell (9, 6)
Removing Row Possibility of e in cell (9, 7)
Removing Row Possibility of e in cell (9, b)
Removing Column Possibility of e in cell (c, 1)
Removing Column Possibility of e in cell (f, 1)
Hidden single of d at R9C7B9 (from 0)
Removing Column Possibility of d in cell (d, 7)
Hidden single of 4 at R9CbBa (from 0)
Removing Column Possibility of 4 in cell (b, b)
Hidden single of e at RaC9Ba (from 0)
Removing Row Possibility of e in cell (a, 4)
Removing Column Possibility of e in cell (e, 9)
Naked single of 4 at RbC0B8 (from 0)
Removing Column Possibility of 4 in cell (d, 0)
Removing Column Possibility of 4 in cell (e, 0)
Naked single of 6 at RbCbBa (from 0)
Removing Column Possibility of 6 in cell (2, b)
Removing Column Possibility of 6 in cell (c, b)
Removing Column Possibility of 6 in cell (f, b)
Removing Block Possibility of 6 in cell (9, 8)
Removing Block Possibility of 6 in cell (9, a)
Hidden single of 6 at RdC0Bc (from 0)
Removing Row Possibility of 6 in cell (d, a)
Naked single of 4 at RdC7Bd (from 0)
Removing Row Possibility of 4 in cell (d, f)
Removing Column Possibility of 4 in cell (5, 7)
Removing Column Possibility of 4 in cell (7, 7)
Removing Block Possibility of 4 in cell (f, 4)
Hidden single of e at ReC0Bc (from 0)
Hidden single of 1 at ReC9Be (from 0)
Removing Row Possibility of 1 in cell (e, 2)
Removing Row Possibility of 1 in cell (e, d)
Removing Row Possibility of 1 in cell (e, e)
Removing Row Possibility of 1 in cell (e, f)
Removing Block Possibility of 1 in cell (f, 8)
Hidden single of 4 at ReCfBf (from 0)
Removing Column Possibility of 4 in cell (5, f)
Removing Column Possibility of 4 in cell (f, f)
Removing Block Possibility of 4 in cell (f, c)
Hidden single of 4 at RfC1Bc (from 0)
[9, ., 5, 7, ., 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., ., ., 1, ., ., ., ., .] 
[F, ., 0, A, 2, ., ., ., ., ., 4, ., D, 9, ., C] 
[., ., B, E, D, 9, 6, A, 0, ., ., 2, 7, 5, 4, F] 
[8, B, 7, ., ., ., D, ., 4, 6, ., ., ., 0, ., A] 
[., A, ., 5, ., ., ., ., ., ., 7, ., ., ., ., .] 
[C, F, 4, 2, 9, ., ., 7, E, ., D, A, 1, 6, ., .] 
[0, D, E, 6, ., A, ., ., ., ., ., 1, ., ., 7, 9] 
[A, 2, 6, B, 7, 5, ., ., ., D, 0, C, 3, 4, ., .] 
[5, E, 3, F, ., 0, ., D, ., 2, ., 4, ., ., ., .] 
[D, 9, C, 0, ., 2, 4, 8, ., E, A, 3, ., ., ., 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, ., ., ., F, ., 8, 0, 3, 4, ., ., ., ., ., .] 
[6, 0, A, ., B, 1, 9, 4, 5, ., ., 7, E, ., ., .] 
[E, 5, ., ., A, 6, 2, C, D, 1, ., 0, B, ., ., 4] 
[B, 4, ., ., ., ., ., 3, ., A, 8, ., ., ., 0, .] 
Hidden single of 6 at R2C8B2 (from 0)
Removing Column Possibility of 6 in cell (f, 8)
Hidden single of 8 at R3C1B0 (from 0)
Removing Column Possibility of 8 in cell (2, 1)
Hidden single of 6 at R5C7B5 (from 0)
Removing Row Possibility of 6 in cell (5, 4)
Hidden single of 8 at R5CbB6 (from 0)
Removing Row Possibility of 8 in cell (5, 4)
Removing Row Possibility of 8 in cell (5, 5)
Removing Row Possibility of 8 in cell (5, 8)
Removing Row Possibility of 8 in cell (5, c)
Removing Row Possibility of 8 in cell (5, d)
Removing Row Possibility of 8 in cell (5, e)
Removing Row Possibility of 8 in cell (5, f)
Removing Block Possibility of 8 in cell (7, 8)
Hidden single of 8 at R7C4B5 (from 0)
Removing Row Possibility of 8 in cell (7, c)
Removing Row Possibility of 8 in cell (7, d)
Removing Block Possibility of 8 in cell (6, 5)
Hidden single of 4 at R7CcB7 (from 0)
Removing Column Possibility of 4 in cell (5, c)
Hidden single of 6 at R9C4B9 (from 0)
Hidden single of b at R9C6B9 (from 0)
Removing Row Possibility of b in cell (9, d)
Removing Row Possibility of b in cell (9, e)
Removing Row Possibility of b in cell (9, f)
Removing Column Possibility of b in cell (0, 6)
Removing Column Possibility of b in cell (1, 6)
Removing Column Possibility of b in cell (2, 6)
Removing Column Possibility of b in cell (5, 6)
Removing Column Possibility of b in cell (6, 6)
Removing Column Possibility of b in cell (7, 6)
Naked single of 9 at R9CaBa (from 0)
Removing Row Possibility of 9 in cell (9, 8)
Removing Row Possibility of 9 in cell (9, c)
Removing Row Possibility of 9 in cell (9, e)
Removing Column Possibility of 9 in cell (4, a)
Removing Column Possibility of 9 in cell (c, a)
Removing Column Possibility of 9 in cell (e, a)
Removing Block Possibility of 9 in cell (8, 8)
Naked single of 1 at RaC4B9 (from 0)
Removing Row Possibility of 1 in cell (a, 8)
Removing Row Possibility of 1 in cell (a, d)
Removing Row Possibility of 1 in cell (a, e)
Removing Column Possibility of 1 in cell (0, 4)
Removing Column Possibility of 1 in cell (4, 4)
Removing Column Possibility of 1 in cell (5, 4)
Removing Block Possibility of 1 in cell (8, 6)
Removing Block Possibility of 1 in cell (8, 7)
Naked single of 7 at RaC8Ba (from 0)
Removing Row Possibility of 7 in cell (a, d)
Removing Column Possibility of 7 in cell (1, 8)
Removing Column Possibility of 7 in cell (9, 8)
Hidden single of 6 at RcCaBe (from 0)
Removing Row Possibility of 6 in cell (c, c)
Hidden single of b at RcCbBe (from 0)
Removing Column Possibility of b in cell (1, b)
Removing Column Possibility of b in cell (2, b)
Naked single of f at ReCaBe (from 0)
Removing Row Possibility of f in cell (e, 2)
Removing Row Possibility of f in cell (e, d)
Removing Row Possibility of f in cell (e, e)
Removing Column Possibility of f in cell (4, a)
Removing Column Possibility of f in cell (7, a)
Removing Column Possibility of f in cell (d, a)
Removing Block Possibility of f in cell (d, 9)
Removing Block Possibility of f in cell (f, b)
Hidden single of 7 at ReCdBf (from 0)
Removing Column Possibility of 7 in cell (9, d)
Removing Column Possibility of 7 in cell (f, d)
Removing Block Possibility of 7 in cell (f, f)
Hidden single of f at RfC2Bc (from 0)
Removing Row Possibility of f in cell (f, c)
Removing Row Possibility of f in cell (f, d)
Hidden single of e at RfCbBe (from 0)
Removing Row Possibility of e in cell (f, 4)
Removing Row Possibility of e in cell (f, 5)
Removing Row Possibility of e in cell (f, 6)
Hidden single of 6 at RfCcBf (from 0)
[9, ., 5, 7, ., 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., ., ., 1, ., ., ., ., .] 
[F, ., 0, A, 2, ., ., ., 6, ., 4, ., D, 9, ., C] 
[., 8, B, E, D, 9, 6, A, 0, ., ., 2, 7, 5, 4, F] 
[8, B, 7, ., ., ., D, ., 4, 6, ., ., ., 0, ., A] 
[., A, ., 5, ., ., ., 6, ., ., 7, 8, ., ., ., .] 
[C, F, 4, 2, 9, ., ., 7, E, ., D, A, 1, 6, ., .] 
[0, D, E, 6, 8, A, ., ., ., ., ., 1, 4, ., 7, 9] 
[A, 2, 6, B, 7, 5, ., ., ., D, 0, C, 3, 4, ., .] 
[5, E, 3, F, 6, 0, B, D, ., 2, 9, 4, ., ., ., .] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, ., ., ., 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, ., ., ., F, ., 8, 0, 3, 4, 6, B, ., ., ., .] 
[6, 0, A, ., B, 1, 9, 4, 5, ., ., 7, E, ., ., .] 
[E, 5, ., ., A, 6, 2, C, D, 1, F, 0, B, 7, ., 4] 
[B, 4, F, ., ., ., ., 3, ., A, 8, E, 6, ., 0, .] 
Hidden single of c at R0C1B0 (from 0)
Removing Row Possibility of c in cell (0, 6)
Removing Column Possibility of c in cell (c, 1)
Naked single of 3 at R0C4B1 (from 0)
Removing Row Possibility of 3 in cell (0, 6)
Removing Row Possibility of 3 in cell (0, d)
Removing Column Possibility of 3 in cell (4, 4)
Removing Column Possibility of 3 in cell (5, 4)
Removing Block Possibility of 3 in cell (1, 6)
Removing Block Possibility of 3 in cell (2, 6)
Hidden single of b at R1C8B2 (from 0)
Removing Row Possibility of b in cell (1, 5)
Removing Row Possibility of b in cell (1, 7)
Removing Row Possibility of b in cell (1, d)
Removing Row Possibility of b in cell (1, e)
Removing Row Possibility of b in cell (1, f)
Removing Column Possibility of b in cell (5, 8)
Removing Column Possibility of b in cell (7, 8)
Hidden single of 3 at R2C1B0 (from 0)
Removing Row Possibility of 3 in cell (2, 9)
Removing Row Possibility of 3 in cell (2, e)
Removing Block Possibility of 3 in cell (3, 0)
Naked single of 5 at R2CbB2 (from 0)
Removing Row Possibility of 5 in cell (2, 6)
Removing Row Possibility of 5 in cell (2, 7)
Removing Row Possibility of 5 in cell (2, 9)
Removing Column Possibility of 5 in cell (1, b)
Removing Column Possibility of 5 in cell (4, b)
Removing Block Possibility of 5 in cell (1, 9)
Naked single of 1 at R3C0B0 (from 0)
Removing Column Possibility of 1 in cell (5, 0)
Hidden single of 1 at R4C7B5 (from 0)
Removing Column Possibility of 1 in cell (0, 7)
Removing Column Possibility of 1 in cell (2, 7)
Removing Block Possibility of 1 in cell (5, 6)
Naked single of 3 at R5C0B4 (from 0)
Removing Row Possibility of 3 in cell (5, 6)
Removing Row Possibility of 3 in cell (5, 9)
Removing Row Possibility of 3 in cell (5, d)
Removing Row Possibility of 3 in cell (5, e)
Removing Row Possibility of 3 in cell (5, f)
Removing Block Possibility of 3 in cell (4, 3)
Hidden single of 1 at R5C2B4 (from 0)
Removing Column Possibility of 1 in cell (c, 2)
Hidden single of 4 at R5C4B5 (from 0)
Naked single of b at R6C5B5 (from 0)
Removing Row Possibility of b in cell (6, e)
Removing Row Possibility of b in cell (6, f)
Removing Column Possibility of b in cell (2, 5)
Removing Column Possibility of b in cell (5, 5)
Removing Block Possibility of b in cell (7, 7)
Hidden single of 2 at R7C7B5 (from 0)
Removing Row Possibility of 2 in cell (7, 8)
Removing Row Possibility of 2 in cell (7, a)
Removing Row Possibility of 2 in cell (7, d)
Naked single of c at R7C8B6 (from 0)
Removing Row Possibility of c in cell (7, 6)
Removing Row Possibility of c in cell (7, 9)
Removing Row Possibility of c in cell (7, a)
Removing Row Possibility of c in cell (7, d)
Removing Column Possibility of c in cell (5, 8)
Removing Column Possibility of c in cell (f, 8)
Removing Block Possibility of c in cell (4, a)
Removing Block Possibility of c in cell (5, 9)
Hidden single of b at R7CaB6 (from 0)
Removing Row Possibility of b in cell (7, d)
Hidden single of 9 at R8CeBb (from 0)
Removing Column Possibility of 9 in cell (c, e)
Removing Column Possibility of 9 in cell (e, e)
Hidden single of 7 at R9CfBb (from 0)
Naked single of 1 at RcC1Bc (from 0)
Removing Row Possibility of 1 in cell (c, d)
Removing Row Possibility of 1 in cell (c, e)
Removing Row Possibility of 1 in cell (c, f)
Hidden single of 2 at RcC2Bc (from 0)
Removing Row Possibility of 2 in cell (c, d)
Removing Row Possibility of 2 in cell (c, e)
Hidden single of e at RcC5Bd (from 0)
Removing Column Possibility of e in cell (1, 5)
Removing Column Possibility of e in cell (2, 5)
Removing Column Possibility of e in cell (4, 5)
Removing Column Possibility of e in cell (5, 5)
Hidden single of 9 at RcCcBf (from 0)
Removing Row Possibility of 9 in cell (c, 3)
Naked single of c at RdC9Be (from 0)
Removing Row Possibility of c in cell (d, 3)
Removing Row Possibility of c in cell (d, a)
Removing Row Possibility of c in cell (d, d)
Removing Row Possibility of c in cell (d, e)
Removing Column Possibility of c in cell (1, 9)
Removing Column Possibility of c in cell (3, 9)
Naked single of 2 at RdCaBe (from 0)
Removing Row Possibility of 2 in cell (d, d)
Removing Row Possibility of 2 in cell (d, e)
Removing Column Possibility of 2 in cell (4, a)
Removing Block Possibility of 2 in cell (f, 8)
Naked single of 9 at ReC2Bc (from 0)
Removing Row Possibility of 9 in cell (e, 3)
Removing Block Possibility of 9 in cell (f, 3)
Naked single of 5 at RfC4Bd (from 0)
Removing Row Possibility of 5 in cell (f, 6)
Removing Row Possibility of 5 in cell (f, f)
Removing Column Possibility of 5 in cell (4, 4)
Hidden single of d at RfC5Bd (from 0)
Removing Row Possibility of d in cell (f, 3)
Removing Row Possibility of d in cell (f, d)
Removing Row Possibility of d in cell (f, f)
Naked single of 7 at RfC6Bd (from 0)
Removing Column Possibility of 7 in cell (1, 6)
Removing Column Possibility of 7 in cell (2, 6)
Naked single of 9 at RfC8Be (from 0)
Removing Column Possibility of 9 in cell (5, 8)
Hidden single of 2 at RfCdBf (from 0)
Removing Column Possibility of 2 in cell (5, d)
Naked single of 1 at RfCfBf (from 0)
Removing Column Possibility of 1 in cell (8, f)
[9, C, 5, 7, 3, 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., ., B, ., 1, ., ., ., ., .] 
[F, 3, 0, A, 2, ., ., ., 6, ., 4, 5, D, 9, ., C] 
[1, 8, B, E, D, 9, 6, A, 0, ., ., 2, 7, 5, 4, F] 
[8, B, 7, ., ., ., D, 1, 4, 6, ., ., ., 0, ., A] 
[3, A, 1, 5, 4, ., ., 6, ., ., 7, 8, ., ., ., .] 
[C, F, 4, 2, 9, B, ., 7, E, ., D, A, 1, 6, ., .] 
[0, D, E, 6, 8, A, ., 2, C, ., B, 1, 4, ., 7, 9] 
[A, 2, 6, B, 7, 5, ., ., ., D, 0, C, 3, 4, 9, .] 
[5, E, 3, F, 6, 0, B, D, ., 2, 9, 4, ., ., ., 7] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, ., ., ., 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, 1, 2, ., F, E, 8, 0, 3, 4, 6, B, 9, ., ., .] 
[6, 0, A, ., B, 1, 9, 4, 5, C, 2, 7, E, ., ., .] 
[E, 5, 9, ., A, 6, 2, C, D, 1, F, 0, B, 7, ., 4] 
[B, 4, F, ., 5, D, 7, 3, 9, A, 8, E, 6, 2, 0, 1] 
Hidden single of 5 at R1C7B1 (from 0)
Removing Row Possibility of 5 in cell (1, 6)
Naked single of 7 at R2C9B2 (from 0)
Removing Row Possibility of 7 in cell (2, 5)
Removing Column Possibility of 7 in cell (1, 9)
Naked single of 3 at R3C9B2 (from 0)
Removing Row Possibility of 3 in cell (3, a)
Removing Column Possibility of 3 in cell (1, 9)
Removing Column Possibility of 3 in cell (6, 9)
Removing Column Possibility of 3 in cell (7, 9)
Naked single of c at R3CaB2 (from 0)
Naked single of 9 at R4C3B4 (from 0)
Removing Row Possibility of 9 in cell (4, b)
Naked single of e at R4C4B5 (from 0)
Removing Row Possibility of e in cell (4, e)
Removing Block Possibility of e in cell (5, 6)
Naked single of 3 at R4CaB6 (from 0)
Removing Row Possibility of 3 in cell (4, e)
Naked single of f at R4CbB6 (from 0)
Removing Row Possibility of f in cell (4, 5)
Removing Row Possibility of f in cell (4, c)
Removing Row Possibility of f in cell (4, e)
Removing Column Possibility of f in cell (1, b)
Removing Block Possibility of f in cell (5, 9)
Removing Block Possibility of f in cell (7, 9)
Hidden single of 2 at R4CeB7 (from 0)
Removing Column Possibility of 2 in cell (5, e)
Naked single of 2 at R5C8B6 (from 0)
Hidden single of 9 at R5C9B6 (from 0)
Removing Column Possibility of 9 in cell (1, 9)
Hidden single of b at R5CfB7 (from 0)
Removing Row Possibility of b in cell (5, d)
Removing Row Possibility of b in cell (5, e)
Hidden single of 0 at R6C9B6 (from 0)
Removing Row Possibility of 0 in cell (6, 6)
Naked single of 5 at R7C9B6 (from 0)
Removing Row Possibility of 5 in cell (7, 6)
Hidden single of 1 at R8C8Ba (from 0)
Removing Column Possibility of 1 in cell (9, 8)
Naked single of 8 at R8CfBb (from 0)
Removing Column Possibility of 8 in cell (1, f)
Removing Column Possibility of 8 in cell (6, f)
Removing Column Possibility of 8 in cell (d, f)
Removing Block Possibility of 8 in cell (9, c)
Removing Block Possibility of 8 in cell (9, d)
Removing Block Possibility of 8 in cell (9, e)
Naked single of 8 at R9C8Ba (from 0)
Naked single of c at RfC3Bc (from 0)
Removing Column Possibility of c in cell (c, 3)
[9, C, 5, 7, 3, 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, ., ., 5, B, ., 1, ., ., ., ., .] 
[F, 3, 0, A, 2, ., ., ., 6, 7, 4, 5, D, 9, ., C] 
[1, 8, B, E, D, 9, 6, A, 0, 3, C, 2, 7, 5, 4, F] 
[8, B, 7, 9, E, ., D, 1, 4, 6, 3, F, ., 0, 2, A] 
[3, A, 1, 5, 4, ., ., 6, 2, 9, 7, 8, ., ., ., B] 
[C, F, 4, 2, 9, B, ., 7, E, 0, D, A, 1, 6, ., .] 
[0, D, E, 6, 8, A, ., 2, C, 5, B, 1, 4, ., 7, 9] 
[A, 2, 6, B, 7, 5, ., ., 1, D, 0, C, 3, 4, 9, 8] 
[5, E, 3, F, 6, 0, B, D, 8, 2, 9, 4, ., ., ., 7] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, ., ., ., 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, 1, 2, ., F, E, 8, 0, 3, 4, 6, B, 9, ., ., .] 
[6, 0, A, ., B, 1, 9, 4, 5, C, 2, 7, E, ., ., .] 
[E, 5, 9, ., A, 6, 2, C, D, 1, F, 0, B, 7, ., 4] 
[B, 4, F, C, 5, D, 7, 3, 9, A, 8, E, 6, 2, 0, 1] 
Hidden single of 7 at R1C5B1 (from 0)
Hidden single of c at R1C6B1 (from 0)
Removing Column Possibility of c in cell (5, 6)
Naked single of f at R1C9B2 (from 0)
Naked single of 9 at R1CbB2 (from 0)
Hidden single of 8 at R1CcB3 (from 0)
Removing Row Possibility of 8 in cell (1, d)
Removing Row Possibility of 8 in cell (1, e)
Removing Block Possibility of 8 in cell (2, e)
Hidden single of e at R1CfB3 (from 0)
Removing Row Possibility of e in cell (1, e)
Removing Block Possibility of e in cell (2, e)
Naked single of 8 at R2C5B1 (from 0)
Naked single of c at R4C5B5 (from 0)
Removing Row Possibility of c in cell (4, c)
Removing Column Possibility of c in cell (5, 5)
Naked single of 5 at R4CcB7 (from 0)
Removing Column Possibility of 5 in cell (a, c)
Removing Block Possibility of 5 in cell (6, e)
Removing Block Possibility of 5 in cell (6, f)
Naked single of f at R5C5B5 (from 0)
Removing Row Possibility of f in cell (5, 6)
Removing Row Possibility of f in cell (5, c)
Removing Row Possibility of f in cell (5, d)
Removing Row Possibility of f in cell (5, e)
Removing Block Possibility of f in cell (7, 6)
Naked single of 0 at R5C6B5 (from 0)
Naked single of c at R5CcB7 (from 0)
Removing Row Possibility of c in cell (5, d)
Removing Row Possibility of c in cell (5, e)
Removing Column Possibility of c in cell (9, c)
Naked single of d at R5CdB7 (from 0)
Removing Column Possibility of d in cell (c, d)
Removing Column Possibility of d in cell (d, d)
Naked single of e at R5CeB7 (from 0)
Hidden single of 5 at R6C6B5 (from 0)
Hidden single of 8 at R6CeB7 (from 0)
Removing Column Possibility of 8 in cell (d, e)
Removing Column Possibility of 8 in cell (e, e)
Naked single of 3 at R6CfB7 (from 0)
Removing Column Possibility of 3 in cell (d, f)
Removing Block Possibility of 3 in cell (7, d)
Naked single of 3 at R7C6B5 (from 0)
Naked single of f at R7CdB7 (from 0)
Removing Column Possibility of f in cell (a, d)
Removing Column Possibility of f in cell (d, d)
Naked single of a at R9CcBb (from 0)
Removing Row Possibility of a in cell (9, d)
Removing Row Possibility of a in cell (9, e)
Naked single of f at RaCcBb (from 0)
Removing Row Possibility of f in cell (a, e)
Naked single of b at RaCdBb (from 0)
Removing Row Possibility of b in cell (a, e)
Removing Column Possibility of b in cell (0, d)
Naked single of 5 at RaCeBb (from 0)
Removing Column Possibility of 5 in cell (c, e)
Naked single of d at RcC3Bc (from 0)
Removing Row Possibility of d in cell (c, f)
Removing Column Possibility of d in cell (d, 3)
Naked single of 5 at RcCfBf (from 0)
Hidden single of 8 at RdCdBf (from 0)
Removing Row Possibility of 8 in cell (d, 3)
Hidden single of f at RdCeBf (from 0)
Naked single of d at RdCfBf (from 0)
Hidden single of 8 at ReC3Bc (from 0)
Naked single of 3 at ReCeBf (from 0)
Removing Column Possibility of 3 in cell (1, e)
[9, C, 5, 7, 3, 4, ., ., A, 8, E, D, 0, ., 6, 2] 
[2, 6, D, 4, 0, 7, C, 5, B, F, 1, 9, 8, ., ., E] 
[F, 3, 0, A, 2, 8, ., ., 6, 7, 4, 5, D, 9, ., C] 
[1, 8, B, E, D, 9, 6, A, 0, 3, C, 2, 7, 5, 4, F] 
[8, B, 7, 9, E, C, D, 1, 4, 6, 3, F, 5, 0, 2, A] 
[3, A, 1, 5, 4, F, 0, 6, 2, 9, 7, 8, C, D, E, B] 
[C, F, 4, 2, 9, B, 5, 7, E, 0, D, A, 1, 6, 8, 3] 
[0, D, E, 6, 8, A, 3, 2, C, 5, B, 1, 4, F, 7, 9] 
[A, 2, 6, B, 7, 5, ., ., 1, D, 0, C, 3, 4, 9, 8] 
[5, E, 3, F, 6, 0, B, D, 8, 2, 9, 4, A, ., ., 7] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, F, B, 5, 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, 1, 2, D, F, E, 8, 0, 3, 4, 6, B, 9, ., ., 5] 
[6, 0, A, ., B, 1, 9, 4, 5, C, 2, 7, E, 8, F, D] 
[E, 5, 9, 8, A, 6, 2, C, D, 1, F, 0, B, 7, 3, 4] 
[B, 4, F, C, 5, D, 7, 3, 9, A, 8, E, 6, 2, 0, 1] 
Hidden single of b at R0C7B1 (from 0)
Removing Column Possibility of b in cell (2, 7)
Naked single of 1 at R0CdB3 (from 0)
Removing Row Possibility of 1 in cell (0, 6)
Removing Column Possibility of 1 in cell (9, d)
Removing Block Possibility of 1 in cell (2, e)
Hidden single of 3 at R1CdB3 (from 0)
Naked single of a at R1CeB3 (from 0)
Removing Column Possibility of a in cell (c, e)
Hidden single of 1 at R2C6B1 (from 0)
Naked single of e at R2C7B1 (from 0)
Removing Column Possibility of e in cell (8, 7)
Naked single of b at R2CeB3 (from 0)
Hidden single of e at R8C6B9 (from 0)
Naked single of f at R8C7B9 (from 0)
Naked single of c at R9CdBb (from 0)
Removing Row Possibility of c in cell (9, e)
Removing Column Possibility of c in cell (c, d)
Naked single of 1 at R9CeBb (from 0)
Naked single of a at RcCdBf (from 0)
Naked single of c at RcCeBf (from 0)
Naked single of 3 at RdC3Bc (from 0)
[9, C, 5, 7, 3, 4, ., B, A, 8, E, D, 0, 1, 6, 2] 
[2, 6, D, 4, 0, 7, C, 5, B, F, 1, 9, 8, 3, A, E] 
[F, 3, 0, A, 2, 8, 1, E, 6, 7, 4, 5, D, 9, B, C] 
[1, 8, B, E, D, 9, 6, A, 0, 3, C, 2, 7, 5, 4, F] 
[8, B, 7, 9, E, C, D, 1, 4, 6, 3, F, 5, 0, 2, A] 
[3, A, 1, 5, 4, F, 0, 6, 2, 9, 7, 8, C, D, E, B] 
[C, F, 4, 2, 9, B, 5, 7, E, 0, D, A, 1, 6, 8, 3] 
[0, D, E, 6, 8, A, 3, 2, C, 5, B, 1, 4, F, 7, 9] 
[A, 2, 6, B, 7, 5, E, F, 1, D, 0, C, 3, 4, 9, 8] 
[5, E, 3, F, 6, 0, B, D, 8, 2, 9, 4, A, C, 1, 7] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, F, B, 5, 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, 1, 2, D, F, E, 8, 0, 3, 4, 6, B, 9, A, C, 5] 
[6, 0, A, 3, B, 1, 9, 4, 5, C, 2, 7, E, 8, F, D] 
[E, 5, 9, 8, A, 6, 2, C, D, 1, F, 0, B, 7, 3, 4] 
[B, 4, F, C, 5, D, 7, 3, 9, A, 8, E, 6, 2, 0, 1] 
Naked single of f at R0C6B1 (from 0)
[9, C, 5, 7, 3, 4, F, B, A, 8, E, D, 0, 1, 6, 2] 
[2, 6, D, 4, 0, 7, C, 5, B, F, 1, 9, 8, 3, A, E] 
[F, 3, 0, A, 2, 8, 1, E, 6, 7, 4, 5, D, 9, B, C] 
[1, 8, B, E, D, 9, 6, A, 0, 3, C, 2, 7, 5, 4, F] 
[8, B, 7, 9, E, C, D, 1, 4, 6, 3, F, 5, 0, 2, A] 
[3, A, 1, 5, 4, F, 0, 6, 2, 9, 7, 8, C, D, E, B] 
[C, F, 4, 2, 9, B, 5, 7, E, 0, D, A, 1, 6, 8, 3] 
[0, D, E, 6, 8, A, 3, 2, C, 5, B, 1, 4, F, 7, 9] 
[A, 2, 6, B, 7, 5, E, F, 1, D, 0, C, 3, 4, 9, 8] 
[5, E, 3, F, 6, 0, B, D, 8, 2, 9, 4, A, C, 1, 7] 
[D, 9, C, 0, 1, 2, 4, 8, 7, E, A, 3, F, B, 5, 6] 
[4, 7, 8, 1, C, 3, A, 9, F, B, 5, 6, 2, E, D, 0] 
[7, 1, 2, D, F, E, 8, 0, 3, 4, 6, B, 9, A, C, 5] 
[6, 0, A, 3, B, 1, 9, 4, 5, C, 2, 7, E, 8, F, D] 
[E, 5, 9, 8, A, 6, 2, C, D, 1, F, 0, B, 7, 3, 4] 
[B, 4, F, C, 5, D, 7, 3, 9, A, 8, E, 6, 2, 0, 1] 
Run Time: 154ms
```

