package GravitySimulator.Render2D;

import GravitySimulator.SpaceBody;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelRenderer extends JPanel {

    private boolean legacy;
    private ArrayList<SpaceBody> spaceBodies;
    final private float radiusMassRatio;
    //number that represents the ration between the mass of a body and the outer radius to see it better

    PanelRenderer(int width, int height, float radiusMassRatio,boolean legacy){
        this.setPreferredSize(new Dimension(width,height));
        this.radiusMassRatio = radiusMassRatio;
        this.legacy = legacy;
    }

    public float getRadiusMassRatio(){
        return radiusMassRatio;
    }

    public void setSpaceBodies(ArrayList<SpaceBody> spaceBodies){
        this.spaceBodies = spaceBodies;
    }

    public void paint(Graphics g){


        if(spaceBodies == null){
            return;
        }

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        if(legacy) {
            for (SpaceBody body : spaceBodies) {
                g2D.setColor(body.getColor());
                g2D.drawLine(
                        (int) body.getXCoordinate(),
                        (int) body.getYCoordinate(),
                        (int) body.getXCoordinate(),
                        (int) body.getYCoordinate());
                g2D.drawOval(
                        (int) body.getXCoordinate() - (int) body.getMass() * (int) radiusMassRatio,
                        (int) body.getYCoordinate() - (int) body.getMass() * (int) radiusMassRatio,
                        //because the oval x and y are the top left corner we need to subtract the radius of the object to get the right coordinates
                        (int) body.getMass() * (int) radiusMassRatio * 2,
                        (int) body.getMass() * (int) radiusMassRatio * 2);
            }
        }else{
            for (SpaceBody body : spaceBodies) {
                g2D.setColor(body.getColor());

                int xCoordinate = (int) body.getCoordinates().getXComponent();
                int yCoordinate = (int) body.getCoordinates().getYComponent();

                g2D.drawLine(
                        (int) xCoordinate,
                        (int) yCoordinate,
                        (int) xCoordinate,
                        (int) yCoordinate);
                g2D.drawOval(
                        (int) xCoordinate - (int) Math.log10( body.getMass()) * (int) radiusMassRatio,
                        (int) yCoordinate - (int) Math.log10( body.getMass()) * (int) radiusMassRatio,
                        //because the oval x and y are the top left corner we need to subtract the radius of the object to get the right coordinates
                        (int) Math.log10( body.getMass()) * (int) radiusMassRatio * 2,
                        (int) Math.log10( body.getMass()) * (int) radiusMassRatio * 2);
            }
        }
    }
}
