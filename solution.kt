//Prompt in screenshot
fun removeIslands(matrix: List<MutableList<Int>>): List<MutableList<Int>> {
    return finale(updateAdjacents(updateEdges(matrix)))
}

fun updateEdges(matrix: List<MutableList<Int>>): List<MutableList<Int>>{
  val rows = matrix.size
  val columns = matrix[0].size

  for(i in 0 until rows){
    for(j in 0 until columns){
      if((i==0 || i==rows-1 ||j==0 || j==columns-1) && matrix[i][j]==1){
        matrix[i][j]=2
      }
    }
  }
  return matrix
}

fun updateAdjacents(matrix: List<MutableList<Int>>): List<MutableList<Int>>{
  val rows = matrix.size
  val columns = matrix[0].size
  for(i in 0 until rows){
    for(j in 0 until columns){
      if(matrix[i][j]==2){
        dfs(matrix, i, j)
      }
    }
  }

  return matrix
    
}

fun getNeighbors(matrix: List<MutableList<Int>>, row: Int, column: Int): MutableList<Pair<Int,Int>>{
  var neighbors = mutableListOf<Pair<Int, Int>>()
  if(row>0){
    neighbors.add(Pair(row-1, column))
  }
  if(row< matrix.size-1){
    neighbors.add(Pair(row+1, column))
  }
  if(column>0){
    neighbors.add(Pair(row, column-1))
  }
  if(column<matrix[0].size-1){
    neighbors.add(Pair(row, column+1))
  }
  return neighbors
}

fun dfs(matrix: List<MutableList<Int>>, row: Int, column: Int): List<MutableList<Int>>{
    var neighbors = getNeighbors(matrix, row, column)
    for(neiba in neighbors){
      if(matrix[neiba.first][neiba.second]==1){
        matrix[neiba.first][neiba.second]=2
        dfs(matrix, neiba.first, neiba.second)
      }
    }
    
  return matrix
}

fun finale(matrix: List<MutableList<Int>>): List<MutableList<Int>>{
  for(i in 0 until matrix.size){
    for(j in 0 until matrix[0].size){
      if(matrix[i][j]==1){
        matrix[i][j]=0
      }
      if(matrix[i][j]==2){
        matrix[i][j]=1
      }
    }
  }
  return matrix
}



/*input
[
  [1, 0, 0, 0, 0, 0],
  [0, 1, 0, 1, 1, 1],
  [0, 0, 1, 0, 1, 0],
  [1, 1, 0, 0, 1, 0],
  [1, 0, 1, 1, 0, 0],
  [1, 0, 0, 0, 0, 1]
]*/

/*output
[
  [1, 0, 0, 0, 0, 0],
  [0, 0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1, 0],
  [1, 1, 0, 0, 1, 0],
  [1, 0, 0, 0, 0, 0],
  [1, 0, 0, 0, 0, 1]
]
*/
