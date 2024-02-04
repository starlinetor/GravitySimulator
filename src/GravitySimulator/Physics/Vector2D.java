package GravitySimulator.Physics;
import java.lang.Math;

public class Vector2D {

    private float xComponent;
    private float yComponent;
    final static float pi = (float) Math.PI;

    //builders
    public Vector2D(){
        this.xComponent = 0;
        this.yComponent = 0;
    }
    //the angle is the normal way you count rad angles so starting from right and going counterclockwise
    public Vector2D(float module, float angle){
        this.xComponent = (float) (module * Math.cos(angle));
        this.yComponent = (float) (module * Math.sin(angle));
    }
    //the flag parameter is useless, is just used to distinguish this constructor from the other
    public Vector2D(float xComponent, float yComponent, boolean flag){
        this.xComponent = xComponent;
        this.yComponent = yComponent;
    }
    //Set and get function
    public void setXComponent(float xComponent){
        this.xComponent = xComponent;
    }
    public void setYComponent(float yComponent){
        this.yComponent = yComponent;
    }
    public void setXYComponent(float xComponent, float yComponent){
        this.xComponent = xComponent;
        this.yComponent = yComponent;
    }
    public void setModuleAngle(float module, float angle){
        this.xComponent = (float) (module * Math.cos(angle));
        this.yComponent = (float) (module * Math.sin(angle));
    }
    public float getXComponent(){
        return this.xComponent;
    }
    public float getYComponent(){
        return this.yComponent;
    }
    public void clear(){
        this.xComponent = 0;
        this.yComponent = 0;
    }
    public void add(Vector2D vector){
        this.xComponent += vector.getXComponent();
        this.yComponent += vector.getYComponent();
    }

    //static methods
    public static float distanceTwoPoints(Vector2D vector1,Vector2D vector2){
        float x1 = vector1.getXComponent();
        float y1 = vector1.getYComponent();
        float x2 = vector2.getXComponent();
        float y2 = vector2.getYComponent();

        return (float) Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
    }

    //this angle is the one of the vector that goes from 1 to 2
    public static float angleTwoPoints(Vector2D vector1,Vector2D vector2, float distance){

        float x1 = vector1.getXComponent();
        float y1 = vector1.getYComponent();
        float x2 = vector2.getXComponent();
        float y2 = vector2.getYComponent();

        float deltaX = x2-x1;
        float deltaY = y2-y1;
        float baseAngle = (float) Math.acos(Math.abs(deltaX)/distance);

        //this is necessary to have the angle always based on the x-axis going anticlockwise
        if(deltaX > 0 && deltaY > 0){
            return baseAngle;
        }else if(deltaX < 0 && deltaY>0){
            return pi-baseAngle;
        } else if (deltaX>0 && deltaY<0) {
            return 2*pi-baseAngle;
        }else{
            return pi+baseAngle;
        }
    }

    //only for debug purposes
    public static void convertToDegree(float radiant){
        System.out.println("Angle : "+(radiant/0.7853982)*45);
    }
}
