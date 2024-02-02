package GravitySimulator;

import GravitySimulator.Physics.Vector2D;
import GravitySimulator.Render2D.FrameRenderer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FrameRenderer frameRenderer = new FrameRenderer(500,500,1);

        ArrayList<SpaceBody> spaceBodies = new ArrayList<>();

        Vector2D.convertToDegree(Vector2D.angleTwoPoints(0,0,0.3327850241072f, -0.4612964108314f));

        while(true){

            //testingDemoVisuals(frameRenderer,spaceBodies);
            Thread.sleep(10);
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