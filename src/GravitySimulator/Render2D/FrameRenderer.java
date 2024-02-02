package GravitySimulator.Render2D;
import GravitySimulator.SpaceBody;
import javax.swing.*;
import java.util.ArrayList;

public class FrameRenderer extends JFrame {
    //This class handles rendering
    PanelRenderer panelRenderer;

    public FrameRenderer(int width, int height, float radiusMassRatio){

        this.panelRenderer = new PanelRenderer(width,height,radiusMassRatio);
        //create panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelRenderer);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //get functions
    public int getPanelWidth(){
        return panelRenderer.getWidth();
    }

    public int getPanelHeight(){
        return panelRenderer.getHeight();
    }

    //calls the function to render the next frame
    public void newFrame(ArrayList<SpaceBody> spaceBodies){
        panelRenderer.setSpaceBodies(spaceBodies);
        panelRenderer.repaint();
    }

}
