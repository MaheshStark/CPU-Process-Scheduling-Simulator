/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package process.scheduling.simulator.sjf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import process.scheduling.simulator.ProcessObj;

/**
 *
 * @author Mahesh
 */
public class ShortestJobFirst {
     int time = 0;
        List<ProcessObj> q = new ArrayList<>();
        List<ProcessObj> list = new ArrayList<>();
        List<ProcessObj> completed = new ArrayList<>();
    public List<ProcessObj> allocateResources( List<ProcessObj> l) throws InterruptedException {
        System.out.println("Started the Shortest job first algorithm--->");
        list=l;
//        addToQueue();
        while (list.size()>0 || q.size()>0) { 
            addToQueue();
            while (q.isEmpty()) {                
                System.out.println("------Waiting to recive a process---------");
                TimeUnit.SECONDS.sleep(1);
                time++;
                addToQueue();
            }
            ProcessObj processRun = selectTheBest();
            System.out.println("Process which name - " + processRun.getName() + " and Id = " + processRun.getId() + " is going run");
            for (int j = 0; j < processRun.getBrustTime(); j++) {
                System.out.println("------running a seccond--------");
                TimeUnit.SECONDS.sleep(1);
                time++;
                addToQueue();
            }
            processRun.setCompleteTime(time);
            processRun.setTurnaroundTime(time-processRun.getArrivalTime());
            processRun.setWaitingTime(processRun.getTurnaroundTime()-processRun.getBrustTime());
            System.out.println(" process completed time = "+processRun.getCompleteTime());
            System.out.println(" process turnaround time = "+processRun.getTurnaroundTime());
            System.out.println(" process waiting time = "+processRun.getWaitingTime());
            
            this.completed.add(processRun);
            
        }
        return completed;
     }
    
    public void addToQueue(){
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
            ProcessObj p = list.get(i);
            if (time >= p.getArrivalTime()) {
                q.add(p);
                list.remove(i);
            }
        }
                                
        }
    }

    private ProcessObj selectTheBest() {
        List<Integer> bTimelist = new ArrayList<>();
        if(!q.isEmpty()){
            for (int i = 0; i < q.size(); i++) {
                bTimelist.add(q.get(i).getBrustTime());
            }
            Collections.sort(bTimelist);
            
            for (int i = 0; i < q.size(); i++) {
                if (bTimelist.get(0)== q.get(i).getBrustTime()) {
                    return q.remove(i);
                }
            }
        }
        return null;
    }

}
