import processing.core.PApplet;

public class Sketch extends PApplet {

  int cellWidth = 20;
  int cellHeight = 20;
  int cellMargin = 5;

  int rowCount = 10;
  int columnCount = 10;

  int rowCheck = -1;
  int columnCheck = -1;

  int width = (cellWidth * rowCount) + (cellMargin * (rowCount + 1));
  int height = (cellHeight * columnCount) + (cellMargin * (columnCount + 1));

  int[][] intGrid = new int[rowCount][columnCount];

  int mouseSquareX = 300;
  int mouseSquareY = 300;

  int colouredSquares = 0;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(500, 600);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255,255,255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
  }

  public void mousePressed(){
    
  }
}
