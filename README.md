# SudokuGraphSolver
Sudoku solver that uses graph coloring to find solutions

## Representing Sudoku as a graph
A Sudoku board can be viewed as a graph with each number field corresponding to a single vertex. Since each row, column and 3x3 block must contain all numbers 1-9, each vertex is connected to every other vertex in its row, column and block. Connected vertices cannot have the same color. Each 3x3 block is a complete graph on 9 vertices (K9), so the graph has a chromatic number of 9 — it requires at least 9 colors to solve. Since valid solutions are possible, the graph is 9-colorable.    
![alt text](https://github.com/Fima1/SudokuGraphSolver/blob/main/sudokugraph_image.png?raw=true)
## Graph implementation
The Graph class contains an implementation of the graph data structure. The class stores a mapping of ids to nodes. Each node contains a color and a list of the nodes it is adjacent to. This class allows us to modify the vertices by changing node mappings and modify the edges by manipulating the adjacency lists maintained by each node.
## Coloring algorithm
This project implements a Greedy coloring algorithm using recursive backtracking. Each vertex is assigned the smallest color (1-9) not shared by any of its neighbors. The function recursively colors the rest of the vertices or backtracks if no solution is found.

## Sample output
```
Before Solving:

  1 2 3   4 5 6   7 8 9
  - - - - - - - - - - -
| 2 0 0 | 3 0 0 | 0 0 0 | 1
| 8 0 4 | 0 6 2 | 0 0 3 | 2
| 0 1 3 | 8 0 0 | 2 0 0 | 3
  - - - - - - - - - - -
| 0 0 0 | 0 2 0 | 3 9 0 | 4
| 5 0 7 | 0 0 0 | 6 2 1 | 5
| 0 3 2 | 0 0 6 | 0 0 0 | 6
  - - - - - - - - - - -
| 0 2 0 | 0 0 9 | 1 4 0 | 7
| 6 0 1 | 2 5 0 | 8 0 9 | 8
| 0 0 0 | 0 0 1 | 0 0 2 | 9
  - - - - - - - - - - -

After Solving:

  1 2 3   4 5 6   7 8 9
  - - - - - - - - - - -
| 2 7 6 | 3 1 4 | 9 5 8 | 1
| 8 5 4 | 9 6 2 | 7 1 3 | 2
| 9 1 3 | 8 7 5 | 2 6 4 | 3
  - - - - - - - - - - -
| 4 6 8 | 1 2 7 | 3 9 5 | 4
| 5 9 7 | 4 3 8 | 6 2 1 | 5
| 1 3 2 | 5 9 6 | 4 8 7 | 6
  - - - - - - - - - - -
| 3 2 5 | 7 8 9 | 1 4 6 | 7
| 6 4 1 | 2 5 3 | 8 7 9 | 8
| 7 8 9 | 6 4 1 | 5 3 2 | 9
  - - - - - - - - - - -
```
