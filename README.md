Introduction to Functional Programming with Clojure
===================================================

Conway's Game of Life rules
---------------------------

An infinite two-dimensional grid consists of square cells, each of which is either alive or dead. Every cell interacts with its eight neighbours (which are horizontally, vertically, or diagonally adjacent). Cells transition from one generation to the next according to these rules:

- Live cell with 2 or 3 live neighbours survives on to the next generation
- Live cell with < 2 or > 3 live neighbours dies
- Dead cell with 3 live neighbours becomes alive
