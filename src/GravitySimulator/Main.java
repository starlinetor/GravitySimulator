package GravitySimulator;

import GravitySimulator.Physics.ConservationOfME;
import GravitySimulator.Physics.NLOUG;
import GravitySimulator.Physics.Vector2D;
import GravitySimulator.Render2D.FrameRenderer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static <bool> void main(String[] args) throws InterruptedException, IOException {

        FrameRenderer frameRenderer = new FrameRenderer(1000,700,2f,false);
        NLOUG nloug = new NLOUG(0.000002f);
        ArrayList<SpaceBody> spaceBodies = new ArrayList<>();

        spaceBodies.add(new SpaceBody(
                new Vector2D(500,200,true),
                new Vector2D(0.5f,0.001f,true),
                100000000,
                Color.RED));

        spaceBodies.add(new SpaceBody(
                new Vector2D(500,500,true),
                new Vector2D(-0.5f,0.001f,true),
                100000000,
                Color.BLACK));


        final float deltaT =0.01F;

        ConservationOfME debugMomentum = new ConservationOfME(spaceBodies);

        while(true){

            //physics engine
            nloug.PhysicsEngine(spaceBodies,deltaT);

            //renders a new frame
            frameRenderer.newFrame(spaceBodies);

            //Momentum debug
            debugMomentum.momentumTester(spaceBodies,deltaT);

            //to go a step at the time
            Thread.sleep(0, 0);


        }

    }

    //Demo
    public static void testingDemoVisuals(FrameRenderer frameRenderer,ArrayList<SpaceBody> spaceBodies){
        if(spaceBodies.size()<500 && Math.random()>0.5){
            spaceBodies.add(new SpaceBody(
                    0,
                    0,
                    (float)Math.random()*20,
                    (float)Math.random()*5+1,
                    (float)Math.random()*5+1,
                    SpaceBody.randomColorGenerator()));
        }

        frameRenderer.newFrame(spaceBodies);

        ArrayList<SpaceBody> removedSpaceBodies = new ArrayList<>();

        for(SpaceBody body: spaceBodies){
            body.setCoordinates(
                    body.getXCoordinate()+body.getxVelocity(),
                    body.getYCoordinate()+body.getyVelocity());
            if(body.getXCoordinate()>frameRenderer.getPanelWidth()||body.getYCoordinate()>frameRenderer.getPanelHeight()){
                removedSpaceBodies.add(body);
            }
        }

        for(SpaceBody body: removedSpaceBodies){
            spaceBodies.remove(body);
        }
    }
}