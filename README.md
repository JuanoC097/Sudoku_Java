# Sudoku_Java
Solución de un sudoku mediante Backtracking en java

## Estructura general
El sudoku cuenta con 3 clases llamadas Cell, Board y Sudoku.

En la clase Sudoku se van a encontrar varias matrices y tambien la funcion Sudoku(puzzle) que recibe como parametro una matriz.

LA FUNCION PRINCIPAL PARA RESOLVER UN SUDOKU ES Sudoku(`puzzle`)

Donde `puzzle` es una matriz.

Para ingresar un sudoku se debe declarar como una matriz de  enteros y asignar valores de esta forma:

int[][] nomPuzzle = {
	8,0,0,4,0,6,0,0,7,
	0,0,0,0,0,0,4,0,0,
	0,1,0,0,0,0,6,5,0,
	5,0,9,0,3,0,7,8,0,
	0,0,0,0,7,0,0,0,0,
	0,4,8,0,2,0,1,0,3,
	0,5,2,0,0,0,0,9,0,
	0,0,1,0,0,0,0,0,0,
	3,0,0,9,0,2,0,0,5
};

De esta manera se puede representar el sudoku de forma matricial y para resolverlo llamamos a la funcion:

Sudoku( nomPuzzle );

LA FUNCION NOS VA A DEVOLVER LAS POSIBLES SOLUCIONES DEL SUDOKU, SI ES QUE LAS TIENE

## ¿Como lo hago funcionar?

Para que el codigo funcione, podemos crear un `package` de nombre sudoku para que nuestra clase pricipal tenga acceso a las otras clases.