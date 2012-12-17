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
    
    public EncoderTest(){
        toughbox = new Encoder(2, 1);
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
}
