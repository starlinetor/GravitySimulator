package GravitySimulator.Physics;
import java.lang.Math;

public class Vector2D {

    float xComponent;
    float yComponent;

    final static float pi = (float) Math.PI;

    //builders
    Vector2D(){
        this.xComponent = 0;
        this.yComponent = 0;
    }
    //the angle is the normal way you count rad angles so starting from right and going counterclockwise
    Vector2D(float module, float angle){
        this.xComponent = (float) (module * Math.cos(angle));
        this.yComponent = (float) (module * Math.sin(angle));
    }
    //Set and get function
    public void setXComponent(float xComponent){
        this.xComponent = xComponent;
    }
    public void setYComponent(float yComponent){
        this.yComponent = yComponent;
    }
    public void setModuleAngle(float module, float angle){
        this.xComponent = (float) (module * Math.cos(angle));
        this.yComponent = (float) (module * Math.sin(angle));
    }

    //static methods
    public static float distanceTwoPoints(float x1,float y1,float x2,float y2){
        return (float) Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
    }

    //this angle is the one of the vector that goes from 1 to 2
    public static float angleTwoPoints(float x1,float y1,float x2,float y2){
        float deltaX = x2-x1;
        float deltaY = y2-y1;
        float baseAngle = (float) Math.acos(Math.abs(deltaX)/distanceTwoPoints(x1,y1,x2,y2));

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
        System.out.println((radiant/0.7853982)*45);
    }
}
