package GravitySimulator;

import GravitySimulator.Physics.Vector2D;

import java.awt.*;
import java.util.Vector;

public class SpaceBody {

    private Vector2D coordinates;
    private Vector2D velocity;
    private Vector2D acceleration;

    final private float mass;
    //mass of the object, determinates the force of gravital attraction
    //default 1
    final private Color color;
    //color of the object
    //default is black

    //LEGACY VARIABLES
    private float xCoordinate;
    private float yCoordinate;
    //x and y coordinates of the object
    //default 0
    private float xVelocity;
    private float yVelocity;
    //x and y velocity of the object, determinates the movement of the object
    //default 0
    private float xAcceleration;
    private float yAcceleration;
    //just used for storing the acceleration of an object before calculating the new speed
    //always default to 0


    //static methods
    public static Color randomColorGenerator(){
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    };

    //non-static methods
    public Color getColor(){
        return this.color;
    }
    public Vector2D getCoordinates(){
        return this.coordinates;
    }
    public Vector2D getVelocity(){
        return this.velocity;
    }
    public Vector2D getAcceleration(){
        return this.acceleration;
    }
    //testing and debugging methods
    public void setCoordinates(float xCoordinate, float yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }


    //builders
    SpaceBody(boolean leagacy){
        if(leagacy == true){
            this.xCoordinate = 0;
            this.yCoordinate = 0;
            this.mass = 1;
            this.xVelocity = 0;
            this.yVelocity = 0;
            this.xAcceleration = 0;
            this.yAcceleration = 0;
            this.color = new Color(0, 0, 0);
        }else{
            this.coordinates = new Vector2D();
            this.mass = 1;
            this.velocity = new Vector2D();
            this.acceleration = new Vector2D();
            this.color =  new Color(0, 0, 0);
        }
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

    SpaceBody(Vector2D coordinates, Vector2D velocity, float mass, Color color){
        this.coordinates = coordinates;
        this.mass = mass;
        this.velocity = velocity;
        this.acceleration = new Vector2D();
        this.color = color;
    }

    //LEGACY METHODS
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
}
