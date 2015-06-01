import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Point {
    private int xCoord;
    private int yCoord;  

    public Point(int xCoord, int yCoord) {
        super();
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }




    @Override
    public String toString() {
        return "[x=" + xCoord + ", y=" + yCoord + "]";
    }




    public int getxCoord() {
        return xCoord;
    }




    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }




    public int getyCoord() {
        return yCoord;
    }




    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    
    public double getDistance(Point a){
        double distance;
        distance= Math.abs(Math.sqrt((this.getxCoord()-a.getxCoord())*(this.getxCoord()-a.getxCoord())+
                (this.getyCoord()-a.getyCoord())*(this.getyCoord()-a.getyCoord())));
        return distance;
    }


    public static List<Point> generatePoints(){
        List <Point> listofPoints = new LinkedList<Point>();
        Random randomGenerator = new Random();
        
        for (int i = 1; i <= 100000; i++){
          int randomX = randomGenerator.nextInt(10000);
          int randomY =randomGenerator.nextInt(10000);
          listofPoints.add(new Point(randomX,randomY));
        }
        
        return listofPoints;
    }
    
//    public static Map<Point,Point> getNearestPoints(List<Point> generatedPoints){
//        Map <Point,Point> mapofNearestPoits = new HashMap<Point, Point>();
//        Point temporary= new Point(0,0);
//        for (int i=0; i<generatedPoints.size();i++) {
//            if (i==generatedPoints.size()-1){
//                double temp=generatedPoints.get(i).getDistance(generatedPoints.get(0));
//                temporary=generatedPoints.get(0);
//                for (int j =0; j<generatedPoints.size();j++){
//                    if((!generatedPoints.get(i).equals(generatedPoints.get(j))) && j!=i+1){
//                          if( temp > generatedPoints.get(i).getDistance(generatedPoints.get(j))){
//                            temp=generatedPoints.get(i).getDistance(generatedPoints.get(j));
//                            temporary= generatedPoints.get(j);
//                        }
//                        
//                    }
//                }   
//            }else{
//            double temp=generatedPoints.get(i).getDistance(generatedPoints.get(i+1));
//            temporary=generatedPoints.get(i+1);
//            for (int j =0; j<generatedPoints.size();j++){
//                if((!generatedPoints.get(i).equals(generatedPoints.get(j))) && j!=i+1){
//                      if( temp > generatedPoints.get(i).getDistance(generatedPoints.get(j))){
//                        temp=generatedPoints.get(i).getDistance(generatedPoints.get(j));
//                        temporary= generatedPoints.get(j);
//                    }
//                    
//                }
//            } 
//            System.out.println(temporary.toString());
//            }
//            System.out.println(generatedPoints.get(i)+"Before/// "+temporary.toString());
//            mapofNearestPoits.put(generatedPoints.get(i), temporary);
//            
//        }
//        System.out.println(mapofNearestPoits.toString());
//        
//        return mapofNearestPoits;
//    }
    
    
    public static Map<Point,Point> getNearestPoints(List<Point> generatedPoints){
        final Map<Point,Point> outMap= new HashMap<Point, Point>();
        
        Runnable firstThread= new Thread(){
            
            @Override
            public void run() {
                synchronized(this){
                   doCalculations(generatedPoints, 0, generatedPoints.size()/2, outMap); 
                    }
                }
        };
        Runnable secondThread= new Thread(){
            
            @Override
            public void run() {
                synchronized(this){
                   doCalculations(generatedPoints, generatedPoints.size()/2, generatedPoints.size(), outMap); 
                    }
                }
        };
        
        firstThread.run();
        secondThread.run();
        
        return outMap;
    }
    
    public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap){
        Point temporary= new Point(0,0);
        for (int i=indexFrom; i<indexTo;i++) {
            if (i==inPoints.size()-1){
                double temp=inPoints.get(i).getDistance(inPoints.get(0));
                temporary=inPoints.get(0);
                for (int j =indexFrom; j<indexTo;j++){
                    if((!inPoints.get(i).equals(inPoints.get(j))) && j!=i+1){
                          if( temp > inPoints.get(i).getDistance(inPoints.get(j))){
                            temp=inPoints.get(i).getDistance(inPoints.get(j));
                            temporary= inPoints.get(j);
                        }
                        
                    }
                }   
            }else{
            double temp=inPoints.get(i).getDistance(inPoints.get(i+1));
            temporary=inPoints.get(i+1);
            for (int j =indexFrom; j<indexTo;j++){
                if((!inPoints.get(i).equals(inPoints.get(j))) && j!=i+1){
                      if( temp > inPoints.get(i).getDistance(inPoints.get(j))){
                        temp=inPoints.get(i).getDistance(inPoints.get(j));
                        temporary= inPoints.get(j);
                    }
                    
                }
            } 
            
            }
            outMap.put(inPoints.get(i), temporary);
            
        }
      //  System.out.println(outMap.toString());
        System.out.println("terminate");
    }


    public static void main(String[] args) {
//        Point a= new Point(0,0);
//       // Point b= new Point(1,0);
//        Point c= new Point(1,1);
//        Point d= new Point(2,1);
//       // Point e= new Point(1,3);
//        Point f= new Point(3,3);
        List <Point> listPoints = generatePoints();
//        listPoints.add(a);
//      //  listPoints.add(b);
//        listPoints.add(c);
//        listPoints.add(d);
//       // listPoints.add(e);
//        listPoints.add(f);
        getNearestPoints(listPoints);
        

    }

}
