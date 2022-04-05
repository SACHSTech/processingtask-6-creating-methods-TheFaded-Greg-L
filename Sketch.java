import processing.core.PApplet;
/**
 * A program, "Sketch.java", that draws objects within methods based on the parameters defined within the same methods.
 * @author G. Lui
 *
 */
public class Sketch extends PApplet {
	
  // global variables
	int intBrickCounter = 0;
  int intFlowerCounter = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255, 255, 255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // bricks
    bricks(150, 250);
    bricks(350, 500);
    bricks(500, 100);
    bricks(600, 600);

    // flowers
    flower(200, 200, 50, 16, 255, 10, 153, 0, 255, 255);
    flower(200, 600, 100, 8, 99, 79, 194, 214, 189, 45);
    flower(600, 200, 30, 32, 45, 214, 138, 214, 45, 45);

    // if true draw grass in center of screen.
    if(boolDrawGrass(intBrickCounter, intFlowerCounter)){

      ground((width / 2) - 50, (height / 2) - 50);
    }
  }
  
  // define other methods down here.
  // draw bricks
  public void bricks(float fltBrickX, float fltBrickY){

    //brick outline
    stroke(0, 0, 0, 0);
    strokeWeight(1);
    fill(232, 164, 135);
    rect(fltBrickX, fltBrickY, 100, 100);
  
    //brick forecolour
    fill(176, 61, 16);
    rect(fltBrickX, fltBrickY, 15, 20);
    rect(fltBrickX + 20, fltBrickY, 45, 20);
    rect(fltBrickX + 70, fltBrickY, 30, 20);

    rect(fltBrickX, fltBrickY + 25, 45, 20);
    rect(fltBrickX + 50, fltBrickY + 25, 45, 20);

    rect(fltBrickX, fltBrickY + 50, 15, 20);
    rect(fltBrickX + 20, fltBrickY + 50, 45, 20);
    rect(fltBrickX + 70, fltBrickY + 50, 30, 20);

    rect(fltBrickX, fltBrickY + 75, 45, 20);
    rect(fltBrickX + 50, fltBrickY + 75, 45, 20);
    
    //brick highlights
    fill(212, 75, 17);
    rect(fltBrickX, fltBrickY, 15, 5);
    rect(fltBrickX + 20, fltBrickY, 45, 5);
    rect(fltBrickX + 70, fltBrickY, 30, 5);

    rect(fltBrickX, fltBrickY + 25, 45, 5);
    rect(fltBrickX + 50, fltBrickY + 25, 45, 5);

    rect(fltBrickX, fltBrickY + 50, 15, 5);
    rect(fltBrickX + 20, fltBrickY + 50, 45, 5);
    rect(fltBrickX + 70, fltBrickY + 50, 30, 5);

    rect(fltBrickX, fltBrickY + 75, 45, 5);
    rect(fltBrickX + 50, fltBrickY + 75, 45, 5);

    //brick shadows
    fill(161, 56, 11);
    rect(fltBrickX, fltBrickY + 15, 15, 5);
    rect(fltBrickX + 20, fltBrickY + 15, 45, 5);
    rect(fltBrickX + 70, fltBrickY + 15, 30, 5);

    rect(fltBrickX, fltBrickY + 40, 45, 5);
    rect(fltBrickX + 50, fltBrickY + 40, 45, 5);

    rect(fltBrickX, fltBrickY + 65, 15, 5);
    rect(fltBrickX + 20, fltBrickY + 65, 45, 5);
    rect(fltBrickX + 70, fltBrickY + 65, 30, 5);

    rect(fltBrickX, fltBrickY + 90, 45, 5);
    rect(fltBrickX + 50, fltBrickY + 90, 45, 5);

    // increases the counter for the amount of bricks
    intBrickCounter += 1;
  }

  // draw flower
  public void flower(float fltFlowerX, float fltFlowerY, int intFlowerSize, int intPedalNum, int intPedalRed, int intPedalGreen, int intPedalBlue, int intPistilRed, int intPistilGreen, int intPistilBlue){

    // saves original position (0, 0)
    pushMatrix();

    fill(intPedalRed, intPedalGreen, intPedalBlue);
    stroke(0);
    strokeWeight(1);
    translate(fltFlowerX, fltFlowerY);

    // Pedals
    for(int i = 1; i <= intPedalNum; i++){

      rotate(TWO_PI / intPedalNum);
      ellipse(0, 0, 3 * intFlowerSize , intFlowerSize / 2);
    }

    // Pistil (Center Dot)
    fill(intPistilRed, intPistilGreen, intPistilBlue);
    ellipse(0, 0, intFlowerSize, intFlowerSize);

    // resets to original position (0, 0)
    popMatrix();

    // increases the counter for the amount of bricks
    intFlowerCounter += 1;
  }

  // draw grass
  public void ground(float groundX, float groundY){

    // dirt
    stroke(0, 0);
    fill(201, 134, 87);
    rect(groundX, groundY, 100, 100);

    // grass
    fill(18, 156, 11);
    rect(groundX, groundY, 100, 5);
    rect(groundX, groundY + 5, 100, 5);
    rect(groundX + 5, groundY + 10, 90, 5);
    rect(groundX + 15, groundY + 15, 70, 5);
    rect(groundX + 20, groundY + 20, 60, 5);
    rect(groundX + 40, groundY + 25, 20, 5);

    // particles in the ground
    fill(230, 226, 177);
    ellipse(groundX + 30, groundY + 80, 25, 25);
    ellipse(groundX + 70, groundY + 60, 10, 10);
  }

  // check to see if the grass is drawn
  public boolean boolDrawGrass(int intBrickNum, int intFlowerNum){

    // returns true if the number of bricks is greater than flowers, otherwise returns false.
    if(intBrickNum > intFlowerNum){

      return true;
    }

    return false;
  }
}