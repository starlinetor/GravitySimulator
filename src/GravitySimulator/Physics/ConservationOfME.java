package GravitySimulator.Physics;
import GravitySimulator.SpaceBody;

import java.util.ArrayList;

public class ConservationOfME {

    //counter, number of frames elapsed
    int frameCounter;
    //starting momentum
    float sMomentum;
    //maximum momentum
    float mMomentum;
    //frame momentum
    float fMomentum;

    //builder
    public ConservationOfME(ArrayList<SpaceBody> SB){
        this.frameCounter = 0;
        this.sMomentum = ConservationOfME.calculateMomentum(SB).getModule();
        mMomentum = 0;
    }

    //debugger for momentum
    public void momentumTester(ArrayList<SpaceBody> SB, float deltaT){
        frameCounter ++;

        fMomentum = ConservationOfME.calculateMomentum(SB).getModule();

        if(mMomentum < fMomentum){
            mMomentum = fMomentum;

            //momentum of the system
            System.out.println("Momentum : " + fMomentum);
            //this is the drift parameter, indicates how much did the momentum deviate from the actual value
            System.out.println("Drift : " + mMomentum/sMomentum);
            //Higher values are better, indicates how much does the simulation deviate for the number of simulation steps
            //multiplied by deltaT. The reason is because I care about the precision not for each frame but on a lenght.
            //Ex a 0.1f deltaT will take 10 times more frame to simulate a revolution instead of a 1f deltaT
            //by multiplying by the deltaT we get a value that describes lenghts and not frames.
            System.out.println("Drift for unit space : " + (frameCounter*deltaT) / (mMomentum/sMomentum) );
        }
    }


    //calculates the momentum of a system or of a single object
    public static Vector2D calculateMomentum(ArrayList<SpaceBody> SB) {

        Vector2D totalMomentum = new Vector2D();

        for (SpaceBody sb : SB) {

            totalMomentum.add(new Vector2D(
                    sb.getMass() * sb.getVelocity().getXComponent(),
                    sb.getMass() * sb.getVelocity().getYComponent(),
                    false));

        }
        return totalMomentum;
    }


    public static Vector2D calculateMomentum(SpaceBody sb) {
        return new Vector2D(
                sb.getMass()*sb.getVelocity().getXComponent(),
                sb.getMass()*sb.getVelocity().getYComponent(),
                false);

    }


    //these don't work
    public static void fixMomentum(float correctM, float newM, ArrayList<SpaceBody> SB){
        //momentum multiplier
        float MMultiplier = correctM/newM;

        for (int i = 0; i < SB.size();i++){
            SB.get(i).getVelocity().multiply(MMultiplier);
        }

    }
    public static void fixMomentum(float correctM, float newM, SpaceBody SB){
        //momentum multiplier
        float MMultiplier = correctM/newM;
        SB.getVelocity().multiply(MMultiplier);
    }


}
