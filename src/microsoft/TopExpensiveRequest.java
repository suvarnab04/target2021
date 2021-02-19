package microsoft;
/*
https://leetcode.com/discuss/interview-question/1051389/Microsoft-or-Phone-Interview
 */

import javafx.util.Pair;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDateTime;

public class TopExpensiveRequest {
    Map<String, Request> requestMap = new HashMap<>();

    static final int MAX_COUNT =5;

    class Request{
        LocalDateTime dateTime;
        String url;
        Long cpu;

        Request(String url, Long cpu){
            this.dateTime = LocalDateTime.now();
            this.url = url;
            this.cpu = cpu;

        }
        boolean isRequestValid(){
            if(ChronoUnit.MINUTES.between(LocalDateTime.now(),this.dateTime )<=20 ){
                return true;
            }
            return false;
        }
    }
    void onRequestCompleted(String uri, Long cpuUsed){
        Request newRequest = new Request(uri, cpuUsed);
        //no request is present
        if(requestMap.isEmpty()){
            requestMap.put(uri, newRequest);
            return;
        }

        List<Request> validRequests = getValidRequests();

       //request is not see before and size is less than 5 then we can add it directly to the map
        if(!requestMap.containsKey(uri)){
            if(requestMap.size() < 5){
                requestMap.put(uri, newRequest);
                return;
            }else{
                //remove the one with smallest cpu and add the new request
                Request remove = validRequests.get(MAX_COUNT);
                requestMap.remove(remove.url);
                requestMap.put(uri, newRequest);
                return;
            }

        }else{ //request map contains the url update the cpu
            newRequest.cpu += requestMap.get(uri).cpu;
            requestMap.put(uri, newRequest);
        }

    }

    public List<Request> getValidRequests(){
        List<Request> requests = new ArrayList<>();
        List<Request> deleteRequests = new ArrayList<>();
        int index =0;
        for(Request req :requestMap.values()){
            if(req.isRequestValid()){
                requests.add(req);
            }else{
                deleteRequests.add(req);
            }
        }
        for(Request req : deleteRequests){
           requestMap.remove(req.url);
        }
        Collections.sort(requests, (Request a, Request b)->Long.compare(b.cpu, a.cpu));
        return requests;
    }
    List<Pair<String,Long>> getTop5(){
        //check if any valid requests are presnt
        //request older than 20mins shoudl be purged
        List<Pair<String, Long>> topK = new ArrayList<>();
        List<Request> validRequests = getValidRequests();
        for(Request req : validRequests){
            topK.add(new Pair<>(req.url, req.cpu));
        }
       return topK;
    }
    void printList(List<Pair<String,Long>> top5){
        for(Pair<String, Long> pair : top5){
            System.out.println("\t"+pair.getKey() + "," +pair.getValue());
        }

    }
    public static void main(String[] args){
        TopExpensiveRequest top = new TopExpensiveRequest();
        System.out.println("adding a, 20");
        top.onRequestCompleted("a",20L);
        top.printList(top.getTop5());

        System.out.println("adding b, 40");
        top.onRequestCompleted("b",40L);
        top.printList(top.getTop5());

        System.out.println("adding a, 25");
        top.onRequestCompleted("a",25L);
        top.printList(top.getTop5());

        System.out.println("adding c, 60");
        top.onRequestCompleted("c",60L);
        top.printList(top.getTop5());

        System.out.println("adding b, 35");
        top.onRequestCompleted("b",35L);
        top.printList(top.getTop5());


    }
}
