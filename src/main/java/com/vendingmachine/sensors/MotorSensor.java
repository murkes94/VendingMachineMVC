package com.vendingmachine.sensors;

/**
 * Uses to check internal motors, e.g. water pump, motor issuing goods, etc
 */
public class MotorSensor {

    /**
     * Call internal Motors(water pump/product or ingredient motor) by id,
     * returns bad response if something is not working
     * @param id
     * @return whether motor is ok or not
     */
    //simulator. one of motors is not working e.g. water pump / product or ingredient motor etc.
    public static boolean isMotorOk(String id) {
        //some logic ...
        return true;
    }
}
