/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package process.scheduling.simulator;

/**
 *
 * @author Mahesh
 */
public class ProcessObj {
    private String name; 
    private int id;
    private int arrivalTime;
    private int brustTime;
    private int completeTime;
    private int turnaroundTime;
    private int waitingTime;

    /**
     * @param name
     * @param id
     * @param arrivalTime
     * @param brustTime
     */
    public ProcessObj(String name, int id, int arrivalTime, int brustTime){
        this.id = id;
        this.name = name;
        this.arrivalTime= arrivalTime;
        this.brustTime = brustTime;
    }

    public ProcessObj(ProcessObj obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the arrivalTime
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the brustTime
     */
    public int getBrustTime() {
        return brustTime;
    }

    /**
     * @param brustTime the brustTime to set
     */
    public void setBrustTime(int brustTime) {
        this.brustTime = brustTime;
    }

    /**
     * @return the completeTime
     */
    public int getCompleteTime() {
        return completeTime;
    }

    /**
     * @param completeTime the completeTime to set
     */
    public void setCompleteTime(int completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * @return the turnaroundTime
     */
    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    /**
     * @param turnaroundTime the turnaroundTime to set
     */
    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    /**
     * @return the waitingTime
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * @param waitingTime the waitingTime to set
     */
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
