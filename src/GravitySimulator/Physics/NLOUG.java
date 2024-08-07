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
            for (SpaceBody otherBody : otherBodies) {

                float distance = Vector2D.distanceTwoPoints(
                        body.getCoordinates(),
                        otherBody.getCoordinates());

                body.getAcceleration().add(new Vector2D(
                        calculateAcceleration(
                                otherBody.getMass(),
                                distance),
                        Vector2D.angleTwoPoints(body.getCoordinates()
                                , otherBody.getCoordinates()
                                , distance)));
            }
            body.getVelocity().add(body.getAcceleration());
            body.getCoordinates().add(body.getVelocity());
        }
    }

    //new physics engine that can handle DeltaT, lower values increase precision but more iterations are needed
    //low Delta values reduce the drift of momentum resulting in more stable and realistic orbits.
    public void PhysicsEngine(ArrayList<SpaceBody> spaceBodies, float deltaT){

        for (int i=0; i<spaceBodies.size();i++){

            SpaceBody body = spaceBodies.get(i);

            body.getAcceleration().clear();
            ArrayList<SpaceBody> otherBodies = (ArrayList<SpaceBody>) spaceBodies.clone();
            otherBodies.remove(body);
            for (SpaceBody otherBody : otherBodies) {

                float distance = Vector2D.distanceTwoPoints(
                        body.getCoordinates(),
                        otherBody.getCoordinates());

                body.getAcceleration().add(new Vector2D(
                        calculateAcceleration(
                                otherBody.getMass(),
                                distance),
                        Vector2D.angleTwoPoints(body.getCoordinates()
                                , otherBody.getCoordinates()
                                , distance)));
            }
            body.getVelocity().add(body.getAcceleration().multiplyReturn(deltaT));
            body.getCoordinates().add(body.getVelocity().multiplyReturn(deltaT));
        }
    }

}
