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
public class Claw {
    private Solenoid piston1;
    private Solenoid piston2;
    private Relay relay1;
    
    private boolean relayIsOn;
    
    public Claw(int slotSolenoid1, int slotSolenoid2, int slotSpike){
        piston1 = new Solenoid(slotSolenoid1);
        piston2 = new Solenoid(slotSolenoid2);
        piston2.set(true);
        relay1 = new Relay(slotSpike);
        relay1.setDirection(Relay.Direction.kForward);
    }
    public void RelayToggle(){
        if (!relayIsOn){
            relay1.set(Relay.Value.kOn);
            relayIsOn = true;
        }else{
            relay1.set(Relay.Value.kOff);
            relayIsOn = false;
        }
    }
    public void Extend(){
        piston1.set(true);
        piston2.set(false);
    }
    public void Retract(){
        piston1.set(false);
        piston2.set(true);
    }
    public void RelayOff(){
        relay1.set(Relay.Value.kOff);
    }
    public Solenoid getPiston1(){
        return piston1;
    }
    public Solenoid getPiston2(){
        return piston2;
    }
    public Relay getRelay(){
        return relay1;
    }
}
