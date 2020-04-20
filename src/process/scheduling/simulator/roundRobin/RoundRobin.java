/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.scheduling.simulator.roundRobin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import process.scheduling.simulator.ProcessObj;

/**
 *
 * @author Mahesh
 */
public class RoundRobin {

    int time = 0;
    int timeQuantum;
    List<ProcessObj> q = new ArrayList<>();
    List<ProcessObj> cloneq = new ArrayList<>();
    List<ProcessObj> list = new ArrayList<>();
    List<ProcessObj> completed = new ArrayList<>();

    public List<ProcessObj> allocateResources(List<ProcessObj> l, List<ProcessObj> c, int timeQ) throws InterruptedException {
        System.out.println("Started the round robin algorithm--->");
        list.addAll(l);
        completed.addAll(c);
        timeQuantum=timeQ;
        while (list.size() > 0 || q.size() > 0) {
            addToQueue();
            while (q.isEmpty()) {
                System.out.println("------Waiting to recive a process---------");
                TimeUnit.SECONDS.sleep(1);
                time++;
                addToQueue();
            }
              selectTheBest();
        }
        for (int j = 0; j < completed.size(); j++) {
            ProcessObj p = completed.get(j);
            p.setBrustTime(l.get(j).getBrustTime());
            p.setTurnaroundTime(p.getCompleteTime()- p.getArrivalTime());
            p.setWaitingTime(p.getTurnaroundTime()- p.getBrustTime());
            completed.set(j, p);
            }
        
        for (int i = 0; i < completed.size(); i++) {
            System.out.println(" process Arrival time = "+completed.get(i).getArrivalTime());
            System.out.println(" process completed time = "+completed.get(i).getCompleteTime());
            System.out.println(" process turnaround time = "+completed.get(i).getTurnaroundTime());
            System.out.println(" process burst time = "+completed.get(i).getBrustTime());
            System.out.println(" process waiting time = "+completed.get(i).getWaitingTime());
            System.out.println("---------------------------------------------------------");
        }
        return completed;
    }

    public void addToQueue() {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ProcessObj p = list.get(i);
                if (time >= p.getArrivalTime()) {
                    q.add(p);
                    list.remove(i);
                }
            }
        }
    }

    private void selectTheBest() throws InterruptedException {
        List<Integer> bTimelist = new ArrayList<>();
        if (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                bTimelist.add(q.get(i).getBrustTime());
            }
            Collections.sort(bTimelist);

            for (int i = 0; i < q.size(); i++) {
                if (bTimelist.get(0) == q.get(i).getBrustTime()) {
                    if (bTimelist.get(0) > timeQuantum) {
                        ProcessObj p = q.get(i);
                        ProcessObj pNext = p;
                        pNext.setBrustTime(p.getBrustTime() - timeQuantum);
                        q.set(i, pNext);
                         run(p,timeQuantum);

                    } else if (bTimelist.get(0) == timeQuantum) {
                        for (int j = 0; j < completed.size(); j++) {
                            if (q.get(i).getId() == completed.get(j).getId()) {
                                ProcessObj p = completed.get(j);
                                p.setCompleteTime(time + timeQuantum);
                                completed.set(j, p);
                            }
                        }
                        run(q.remove(i),timeQuantum);

                    } else if (bTimelist.get(0) < timeQuantum) {
                        for (int j = 0; j < completed.size(); j++) {
                            if (q.get(i).getId() == completed.get(j).getId()) {
                                ProcessObj p = completed.get(j);
                                p.setCompleteTime(time + bTimelist.get(0));
                                completed.set(j, p);
                            }
                        }
                        run(q.remove(i),bTimelist.get(0));
                    }
                }
            }
        }
    }

    private void run(ProcessObj processRun, Integer t) throws InterruptedException {
         System.out.println("Process which name - " + processRun.getName() + " and Id = " + processRun.getId() + " is going run");
        for (int j = 0; j < t; j++) {
                    System.out.println("------running a seccond--------");
                    TimeUnit.SECONDS.sleep(1);
                    time++;
                    addToQueue();
                }
    }

}
