import java.util.*;
class Vertex implements Comparable<Vertex>{
      Graph g = new Graph();     
	  
	  public int compareTo(Vertex v67) {
         return Integer.compare(dist, v67.dist);
      } 
      public String name;
      
	  public int dist = Integer.MAX_VALUE;
      
	  public Vertex previous = null;
	  
	  public List<Integer> chamap = new ArrayList<>();
	  
	  public ArrayList<Taxi> taxiSet = new ArrayList<Taxi>();
      
	  public Map<Vertex, Integer> neighbours = new HashMap<>();
    
      public int shortestpath; 
 	
      public ArrayList<Taxi> taxisHere(){
		  return taxiSet;
	  }
      
	  public Vertex(String vname) {
         name = vname;
      }
      
	  
      
	  public void printPath() {
         if(this.equals(this.previous)) {
            System.out.print(this.name+" ,");
         } else if(this.previous.equals(null)) {
            System.out.print(this.name+" ,");
         } else{
            this.previous.printPath();
            System.out.print(this.name+" ,");
         }
		 shortestpath = (this.dist);
		 }
	   
	  public int getDist(){
			 return shortestpath;
		 }
      
       	  
	 
}