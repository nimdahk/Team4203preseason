/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.*;

/**
 *
 * @author CLentner
 */
public class EncoderTest {
    private Encoder toughbox;
    
    public EncoderTest(int slotA, int slotB){
        toughbox = new Encoder(slotA, slotB);
        toughbox.reset();
    }
    
    public int getCount(){
        return toughbox.get();
    }
    public boolean getDirection(){
        return toughbox.getDirection();
    }
    public double getDistance(){
        return toughbox.getDistance();
    }
    public Encoder getToughbox(){
        return toughbox;
    }
}
