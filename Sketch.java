import processing.core.PApplet;

public class Sketch extends PApplet {

  int cellWidth = 50;
  int cellHeight = 50;
  int cellMargin = 5;
  int rowCount = 10;
  int columnCount = 10;
  
  int width = (cellWidth * rowCount) + (cellMargin * (rowCount + 1));
  int height = (cellHeight * columnCount) + (cellMargin * (columnCount + 1));
  int[][] intGrid = new int[rowCount][columnCount];
  int mouseXonGrid;
  int mouseYonGrid;
  int selectedCount;
  int selectedRowCount;
  int selectedColumnCount;
  int grid;
;
  boolean gridPressed = false;
  boolean gridPrint = false;
  boolean resetGrid;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(width, height);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    drawGrid();
    gridData();
  }

   public void drawGrid(){
    for (int COLUMNS = 0; COLUMNS < columnCount; COLUMNS++){
      for (int ROWS = 0; ROWS < rowCount; ROWS++){

        if (gridPressed && mouseX == COLUMNS && mouseY == ROWS){

          if (intGrid[ROWS][COLUMNS] == 0){

            intGrid[ROWS][COLUMNS] = 1;
            selectedCount ++;
          }

          else if (intGrid[ROWS][COLUMNS] == 1){

            intGrid[ROWS][COLUMNS] = 0;
            selectedCount --;
          }

          if (COLUMNS > 0 && intGrid[ROWS][COLUMNS-1] == 0){

            intGrid[ROWS][COLUMNS-1] = 1;
            selectedCount ++;
          }

          else if (COLUMNS > 0 && intGrid[ROWS][COLUMNS-1] == 1){
          
            intGrid[ROWS][COLUMNS-1] = 0;
            selectedCount --;
          }

          if (COLUMNS < columnCount - 1 && intGrid[ROWS][COLUMNS+1] == 0){

            intGrid[ROWS][COLUMNS+1] = 1;
            selectedCount ++;
          }

          else if (COLUMNS < columnCount - 1 && intGrid[ROWS][COLUMNS+1] == 1){

            intGrid[ROWS][COLUMNS+1] = 0;
            selectedCount --;
          }

          if (ROWS > 0 && intGrid[ROWS-1][COLUMNS] == 0){

            intGrid[ROWS-1][COLUMNS] = 1;
            selectedCount ++;
          }
          
          else if (ROWS > 0 && intGrid[ROWS-1][COLUMNS] == 1){

            intGrid[ROWS-1][COLUMNS] = 0;
            selectedCount --;
          }

          if (ROWS < rowCount - 1 && intGrid[ROWS+1][COLUMNS] == 0){

            intGrid[ROWS+1][COLUMNS] = 1;
            selectedCount ++;
          }

          else if (ROWS < rowCount - 1 && intGrid[ROWS+1][COLUMNS] == 1){

            intGrid[ROWS+1][COLUMNS] = 0;
            selectedCount --;
            
          }

          // text outputs
          println( "Total of " + selectedCount + " cells are selected.");
          
          gridPressed = false;
        }

        // colour change
        if (intGrid[ROWS][COLUMNS] == 1){

          fill(0, 255, 0);
          
        }

        else {

          fill(255, 255, 255);
        }

        rect(cellMargin + (COLUMNS * (cellWidth + cellMargin)), cellMargin + (ROWS * (cellHeight + cellMargin)), cellWidth, cellHeight);

        if (resetGrid){
          for (int i = 0; i < columnCount; i++){
            for (int j = 0; j < rowCount; j++){
    
              intGrid[j][i] = 0;
            }
          }

          selectedCount = 0;
          grid = 0;
          selectedRowCount = 0;
          selectedColumnCount = 0;
        }
      }
    }
  }
  
  public void gridData(){

    if (gridPrint){

      for (int i = 0; i < rowCount; i++){
        for (int j = 0; j < columnCount; j++){
  
          if (intGrid[i][j] == 1){

            selectedRowCount ++;
          }

          if (j < columnCount - 1){

            if (intGrid[i][j] == 1 && intGrid[i][j+1] == 1){

              grid ++;
            }
          }
          
          if (j > 0 && j < columnCount){

            if (intGrid[i][j-1] == 1 && intGrid[i][j] == 1 && j == columnCount - 1){

              grid ++;
            } 

            else if (intGrid[i][j-1] == 1 && intGrid[i][j] == 1 && intGrid[i][j+1] == 0 && j < columnCount - 1){

              grid ++;
            }
          }
        }

        if (selectedRowCount > 2 && grid > 0){

          println("There are " + grid + " continuous blocks selected on row " + i + ".");
        }

      println("Row " + i + " has " + selectedRowCount + " cells selected.");

       selectedRowCount = 0;
        grid = 0;
      }

      for (int i = 0; i < columnCount; i++){
        for (int j = 0; j < rowCount; j ++){

          if (intGrid[j][i] == 1){

            selectedColumnCount ++;
          }
        }

        println("Column " + i + " has " + selectedColumnCount + " cells selected.");
        selectedColumnCount = 0;
      }

      gridPrint = false;
    }
  }

  public void mousePressed(){
  
    mouseX = mouseX / (cellWidth + cellMargin);
    mouseY = mouseY / (cellHeight + cellMargin);
    gridPressed = true;
    gridPrint = true;
  }

  public void keyPressed(){
    if (key == 'r'){

      resetGrid = true;
    }
  }

  public void keyReleased(){
    if (key == 'r'){

      resetGrid = false;
    }
  }
}