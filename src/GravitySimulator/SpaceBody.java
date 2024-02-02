package GravitySimulator;

import java.awt.*;
public class SpaceBody {

    private float xCoordinate;
    private float yCoordinate;
    //x and y coordinates of the object
    //default 0
    final private float mass;
    //mass of the object, determinates the force of gravital attraction
    //default 1
    private float xVelocity;
    private float yVelocity;
    //x and y velocity of the object, determinates the movement of the object
    //default 0
    private float xAcceleration;
    private float yAcceleration;
    //just used for storing the acceleration of an object before calculating the new speed
    //always default to 0
    final private Color color;
    //color of the object
    //default is black

    //static methods
    public static Color randomColorGenerator(){
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    };

    //nonstatic methods
    //get methods
    public float getXCoordinate(){
        return this.xCoordinate;
    }
    public float getYCoordinate(){
        return this.yCoordinate;
    }
    public float getxVelocity(){
        return this.xVelocity;
    }
    public float getyVelocity(){
        return this.yVelocity;
    }
    public float getMass(){
        return this.mass;
    }
    public Color getColor(){
        return this.color;
    }
    //testing and debugging methods
    public void setCoordinates(float xCoordinate, float yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    //builders
    SpaceBody(){
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.mass = 1;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.xAcceleration = 0;
        this.yAcceleration = 0;
        this.color = new Color(0, 0, 0);
    }

    SpaceBody(float xCordinate,float yCordinate,float mass, float xVelocity, float yVelocity, Color color){
        this.xCoordinate = xCordinate;
        this.yCoordinate = yCordinate;
        this.mass = mass;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xAcceleration = 0;
        this.yAcceleration = 0;
        this.color = color;
    }
}
