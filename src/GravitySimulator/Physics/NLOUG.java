package GravitySimulator.Physics;

import GravitySimulator.SpaceBody;
import java.util.ArrayList;

//short for Newton's law of universal gravitation
public class NLOUG {

    private final float G;

    public NLOUG(float G){
        this.G = G;
    }

    //this function returns only the module of the vector
    public float calculateAcceleration(float mass, float distance){
        //this is just the base newton law without the mass of the object because is the acceleration of it
        return (float) ((G*mass)/(Math.pow(distance,2)));
    }

    public void PhysicsEngine(ArrayList<SpaceBody> spaceBodies){

        for (int i=0; i<spaceBodies.size();i++){

            SpaceBody body = spaceBodies.get(i);

            body.getAcceleration().clear();
            ArrayList<SpaceBody> otherBodies = (ArrayList<SpaceBody>) spaceBodies.clone();
            otherBodies.remove(body);
            for(int j=0; j <otherBodies.size(); j++){

                SpaceBody otherBody = otherBodies.get(j);

                float distance = Vector2D.distanceTwoPoints(
                        body.getCoordinates(),
                        otherBody.getCoordinates());

                body.getAcceleration().add(new Vector2D(
                        calculateAcceleration(
                                otherBody.getMass(),
                                distance),
                        Vector2D.angleTwoPoints(body.getCoordinates()
                                ,otherBody.getCoordinates()
                                ,distance)));
            }
            body.getVelocity().add(body.getAcceleration());
            body.getCoordinates().add(body.getVelocity());
        }
    }

}
