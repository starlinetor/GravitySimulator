package GravitySimulator;

import GravitySimulator.Physics.NLOUG;
import GravitySimulator.Physics.Vector2D;
import GravitySimulator.Render2D.FrameRenderer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        FrameRenderer frameRenderer = new FrameRenderer(1000,700,2,false);
        NLOUG nloug = new NLOUG(0.000002f);
        ArrayList<SpaceBody> spaceBodies = new ArrayList<>();
        spaceBodies.add(new SpaceBody(
                new Vector2D(500,350,true),
                new Vector2D(0,0,true),
                100000000,
                Color.BLACK));
        spaceBodies.add(new SpaceBody(
                new Vector2D(500,150,true),
                new Vector2D(1.1f,0,true),
                100000,
                Color.BLACK));
        spaceBodies.add(new SpaceBody(
                new Vector2D(500,140,true),
                new Vector2D(1.2f,0,true),
                1000,
                Color.BLACK));

        while(true){

            nloug.PhysicsEngine(spaceBodies);

            //testingDemoVisuals(frameRenderer,spaceBodies);
            frameRenderer.newFrame(spaceBodies);


            //to go a step at the time
            //System.in.read();

            Thread.sleep(1);
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