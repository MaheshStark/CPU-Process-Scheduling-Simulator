/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package process.scheduling.simulator;

import java.util.ArrayList;
import java.util.List;
import process.scheduling.simulator.fcfs.FirstComeFirstServe;
import process.scheduling.simulator.roundRobin.RoundRobin;
import process.scheduling.simulator.sjf.ShortestJobFirst;
import process.scheduling.simulator.srtf.ShortestRemainingTime;

/**
 *
 * @author Mahesh
 */
public class ProcessSchedulingSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ProcessObj p1 = new ProcessObj("p1",1,0,1);
        ProcessObj p2 = new ProcessObj("p2",2,0,2);
        ProcessObj p3 = new ProcessObj("p3",3,1,1);
        ProcessObj p4 = new ProcessObj("p4",4,2,3);
        List<ProcessObj> l = new ArrayList<>();
        l.add(p1);
        l.add(p3);
        l.add(p2);
        l.add(p4);
        
        List<ProcessObj> c = new ArrayList<>();
        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);
//        FirstComeFirstServe f1 = new FirstComeFirstServe();
//        f1.allocateResources(l);
        ShortestJobFirst s1 = new ShortestJobFirst();
        s1.allocateResources(l);
//        ShortestRemainingTime s1 = new ShortestRemainingTime();
//        List<ProcessObj> listCompleted= f1.allocateResources(l,c);
//          RoundRobin r = new RoundRobin();
//          r.allocateResources(l, 2);
    }
    
}
