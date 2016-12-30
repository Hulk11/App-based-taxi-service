import java.util.*;
class jagah{
	public String d1;
	public String d2;
	public int g;
	public int edglngth;
	Map<Integer,jagah> allps;
	public jagah(Edge e,int y){
		d1 = e.pdo();
		d2 = e.ddo();
      g = y;	
	  allps = new HashMap<Integer,jagah>();
	edglngth = e.dido();
	}
	
	public String pehla(){
		return d1;
	}
	public String dusra(){
		return d2;
	}
	
	public int lngth(){
		return g;
	}
}