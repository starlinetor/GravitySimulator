package GravitySimulator.Physics;

//short for Newton's law of universal gravitation
public class NLOUG {

    private final float G;

    NLOUG(float G){
        this.G = G;
    }

    //this function returns only the module of the vector
    public float calculateAcceleration(float mass, float distance){
        //this is just the base newton law without the mass of the object because is the acceleration of it
        return (float) ((G*mass)/(Math.pow(distance,2)));
    }
}
