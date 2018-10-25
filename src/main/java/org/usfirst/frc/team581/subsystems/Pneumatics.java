package org.usfirst.frc.team581.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team581.commands.CompressorLoop;

import org.usfirst.frc.team581.robot.RobotMap;

public class Pneumatics extends Subsystem {

  Solenoid idk = new Solenoid(RobotMap.idk);
  Solenoid idc = new Solenoid(RobotMap.idc);
  DoubleSolenoid doubleSolenoid = new DoubleSolenoid(0, 1);
  Compressor compressor = new Compressor(0);
  boolean compressorEnable = false;

  public Pneumatics() {
    this.dsolenoidOff();
    this.solenoidOff();
  }

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new CompressorLoop());
  }

  public void solenoidOn() {
    idk.set(true);
  }

  public void solenoidOff() {
    idk.set(false);
  }

  public void solenoidCOn() {
    idc.set(true);
  }

  public void solenoidCOff() {
    idc.set(false);
  }

  public void dsolenoidExtend() {
    doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void dsolenoidRetract() {
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void dsolenoidOff() {
    doubleSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void toggleCompressor() {
    // System.out.println("--> Toggle boolean");
    compressorEnable = !compressorEnable;
  }

  /**
   * Start and stop the compressor when we want.
   */
  public void compressorLoop() {
    if (compressorEnable) {
      compressor.start();
    } else {
      compressor.stop();
    }
  }

}
