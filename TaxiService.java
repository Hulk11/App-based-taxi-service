import java.util.*;
import java.util.Collections;
public class TaxiService{
   Taxi taxy;
   Graph g;
   int time = 0;
   List<Taxi> tSet = new ArrayList<Taxi>();
   public Taxi getTaxi(Taxi req){
	   Iterator<Taxi> ty = tSet.iterator();
	   Taxi tmp = new Taxi("sd",new jagah(new Edge("s","d",9),8));
	   while(ty.hasNext()){
		   tmp = ty.next();
		   if(req.equals(tmp))
			   break;
	   }
	  return tmp;  
   }
   Vector<String> medion = new Vector<String>();
	
	 public TaxiService() {
	          g =  new Graph();
	 }
       
	/*Collections.sort(medion);*/
	 public void taxi(String name,jagah position){
		
		Taxi t = new Taxi(name,position);
		tSet.add(t);
	    Iterator<String> ghost = medion.iterator();
		while(ghost.hasNext()){
			g.dijkstra(position.pehla());
			g.printPath(ghost.next());
			t.tcon = g.rahul();
		}
		
	}
	
	
	public int miminum(int a,int b,int c,int d){
	int ans=0;
	if((a<b)&&(a<c)&&(a<d)){
		ans = a;
	}
	if((b<a)&&(b<c)&&(b<d)){
		ans = b;
	}
	if((c<b)&&(c<a)&&(c<d)){
		ans = c;
	}
	if((d<b)&&(d<c)&&(d<a)){
		ans = d;
	}
	return ans;
	}	
	
	
	
	public void customer(jagah src,jagah dst,int tim){
		System.out.println();
		System.out.println();
		System.out.println();
		time = tim;
		Map<Integer,Taxi> distances = new HashMap<Integer,Taxi>();
        	Iterator<Taxi> it = tSet.iterator();
        System.out.println("Available taxis:");
		Taxi t;
		int fltu1=0;
		int fltu2=0;
		int fltu3=0;
		int fltu4=0;
		int ffin=0;
		int a1=0;
		int i=Integer.MAX_VALUE;
		while(it.hasNext()){
			t = it.next();
			if(t.tcon<time){
				t.availafter = 0;
			}
	
			System.out.print("/*   ");
			g.dijkstra(t.taxiPosition().pehla());
			g.printPath(src.pehla());
			fltu1 = g.rahul();
			
			g.dijkstra(t.taxiPosition().pehla());
			g.printPath(src.dusra());
			fltu2 = g.rahul();
			
			g.dijkstra(t.taxiPosition().dusra());
			g.printPath(src.pehla());
			fltu3 = g.rahul();
			
			g.dijkstra(t.taxiPosition().dusra());
			g.printPath(src.dusra());
			fltu4 = g.rahul();
			System.out.print("    */");
			ffin = miminum(fltu1,fltu2,fltu3,fltu4);
			System.out.println();
			System.out.println("Path of "+t.givName()+" : ");
			
			if(ffin==fltu1){
				g.dijkstra(t.taxiPosition().pehla());
			g.printPath(src.pehla());
			a1=g.rahul()+src.lngth()-t.taxiPosition().lngth();
			System.out.print("in time "+Math.abs(a1));
			}
			else
				if(ffin==fltu2){
				g.dijkstra(t.taxiPosition().pehla());
			g.printPath(src.dusra());
			a1=g.rahul()+src.lngth()-src.edglngth-t.taxiPosition().lngth();
			System.out.print("in time "+Math.abs(a1));
			}
			else
				if(ffin==fltu3){
				g.dijkstra(t.taxiPosition().dusra());
			g.printPath(src.pehla());
			a1=g.rahul()+src.lngth()+t.taxiPosition().lngth();
			System.out.print("in time "+Math.abs(a1));
			}
			else
				if(ffin==fltu4){
				g.dijkstra(t.taxiPosition().dusra());
			g.printPath(src.dusra());
			a1=g.rahul()+src.lngth()-src.edglngth+t.taxiPosition().lngth();
			System.out.print("in time "+Math.abs(a1));
						}
			
			distances.put(Math.abs(a1),t);
			System.out.println();
		}
		for(Map.Entry<Integer,Taxi> k : distances.entrySet())
		{
		if((k.getKey()<=i)&&(distances.get(k.getKey()).availafter==0)){
			i=k.getKey();
		}
		}
Taxi usable = distances.get(i);
while(it.hasNext()){
			Taxi t8 = it.next();
			if(!t8.equals(usable)){
				t8.tcon = tim;
			}
		}
System.out.println();
System.out.println("Choose "+usable.givName()+" to service the customer ");
	int cena1=0;
	int cena2=0;
	int cena3=0;
	int cena4=0;
	int fincena=0;
	System.out.print("/*  ");
	g.dijkstra(src.pehla());
    g.printPath(dst.pehla());
	cena1 = g.rahul();
	g.dijkstra(src.pehla());
	g.printPath(dst.dusra());
	cena2 = g.rahul();
	g.dijkstra(src.dusra());
    g.printPath(dst.pehla());
	cena3 = g.rahul();
	g.dijkstra(src.dusra());
	g.printPath(dst.dusra());
		cena4 = g.rahul();
		System.out.print("   */");
		System.out.println();
		fincena = miminum(cena1,cena2,cena3,cena4);
		if(fincena==cena1){
		 g.dijkstra(src.pehla());
		 g.printPath(dst.pehla());
		}
		else
			if(fincena==cena2){
		 g.dijkstra(src.pehla());
		 g.printPath(dst.dusra());
		}
		else
			if(fincena==cena3){
		 g.dijkstra(src.dusra());
		 g.printPath(dst.pehla());
		}
		else
			if(fincena==cena4){
		 g.dijkstra(src.dusra());
		 g.printPath(dst.dusra());
		}
		System.out.print("int time "+g.rahul());
		System.out.println();
		usable.tcon = time+i+g.rahul();
		usable.pos = dst;
		usable.availafter=1;
	}
	
	public void addEdge(Edge esd){
		g.addedge(esd.pdo(),esd.ddo(),esd.dido());
        if(!medion.contains(esd.pdo())){
		medion.add(esd.pdo());}
		if(!medion.contains(esd.ddo())){
		medion.add(esd.ddo());}
		}
	
	public void printTaxiPosition(int uer){
	    Iterator<Taxi> ch = tSet.iterator();
       while(ch.hasNext()){		
	   Taxi asd = ch.next();
           if(asd.tcon<=uer){	   
		   System.out.println(asd.givName()+": "+asd.taxiPosition());}
	   }
	   System.out.println();
	   System.out.println();
	}
	
	
	public void performAction(String actionMessage) {
		
		if(actionMessage.charAt(0)=='t'){
			String taxiname = actionMessage.substring(5,actionMessage.lastIndexOf(" "));
			String pos = actionMessage.substring(actionMessage.lastIndexOf(" ")+1,actionMessage.length());
			jagah tmpooo = new jagah(new Edge(pos,pos,0),0);
			taxi(taxiname,tmpooo);
		}
		
		if(actionMessage.charAt(0)=='e'){
		
		    String vertices = actionMessage.substring(actionMessage.indexOf(" ") + 1, actionMessage.lastIndexOf(" "));
			String source = vertices.substring(0,vertices.indexOf(" "));
            String destination = vertices.substring(vertices.indexOf(" ")+1,vertices.length());
			String integ = actionMessage.substring(6+vertices.length(),actionMessage.length());
			int i = Integer.parseInt(integ);
			Edge tryka = new Edge(source,destination,i);
			addEdge(tryka);
		}
		
		if(actionMessage.charAt(0)=='c'){
			
		 String[] tmop = actionMessage.split(" ");
		 String kane1 = tmop[0];
		 String kane2 = tmop[1];
		 String kane3 = tmop[2];
		 String kane4 = tmop[3];
		 String kane5 = tmop[4];
		 String kane6 = tmop[5];
		 String kane7 = tmop[6];
	    
        		 
		}
		
		
		if(actionMessage.charAt(0)=='p'){
			String sd = actionMessage.substring(actionMessage.indexOf(" ")+1,actionMessage.length());
		    int ier = Integer.parseInt(sd);
			printTaxiPosition(ier);
		}
}}
	class runthis{
	public static void main(String args[]){
		TaxiService td = new TaxiService();
		
		
		
		
		Edge e1 = new Edge("indiagate","chanakyapuri",30);
Edge e2 = new Edge("indiagate","AIIMS",30);
Edge e3 = new Edge("indiagate","lajpatnagar",50);
Edge e4 = new Edge("chanakyapuri","AIIMS",20);
Edge e5 = new Edge("AIIMS","lajpatnagar",15);
Edge e6 = new Edge("chanakyapuri","iitmaingate",50);
Edge e7 = new Edge("AIIMS","iitmaingate",30);
Edge e8 = new Edge("lajpatnagar","iitmaingate",40);
Edge e9 = new Edge("iitmaingate","iitmaingate",0);
Edge e10 = new Edge("indiagate","indiagate",0);
Edge e11 = new Edge("lajpatnagar","lajpatnagar",0);
Edge e12 = new Edge("AIIMS","AIIMS",0);
Edge e13 = new Edge("chanakyapuri","chanakyapuri",0);
td.addEdge(e1);
td.addEdge(e2);
td.addEdge(e3);
td.addEdge(e4);
td.addEdge(e5);
td.addEdge(e6);
td.addEdge(e7);
td.addEdge(e8);
jagah j1 = new jagah(e1,0);
jagah j2 = new jagah(e2,20);
jagah j3 = new jagah(e3,0);
jagah j4 = new jagah(e4,0);
jagah j5 = new jagah(e5,0);
jagah j6 = new jagah(e3,1);
jagah j7 = new jagah(e7,10);
jagah j8 = new jagah(e8,0);
jagah j9 = new jagah(e9,0);
jagah j10 = new jagah(e10,0);
jagah j11 = new jagah(e11,0);
jagah j12 = new jagah(e12,0);
jagah j13 = new jagah(e13,0);

td.taxi("shaktimaan",j9);
td.taxi("batman",j11);
td.taxi("superman",j10);

td.customer(j8,j1,1);
td.customer(j1,j4,52);
td.customer(j5,j5,70);
td.customer(j1,j1,150);
td.customer(j3,j6,150);
td.customer(j8,j8,150);
}
}
