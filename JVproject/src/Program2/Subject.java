package Program2;

import java.util.*;
import static Program2.Course.submap;

public class Subject {
	private String id;
	private String name;
	private double year;
	private ArrayList<Subject> next;
	private ArrayList<Subject> require;
	
	public void addNext(Subject s) {
		if(next.indexOf(s)==-1) next.add(s);
	}
	
	public void addReq(Subject s) {
		if(require.indexOf(s)==-1) require.add(s);
	}
	
	public Subject(String id, String name, String year) {
		submap.put(id, this);
		this.id = id;
		this.name = name;
		this.year = Double.valueOf(year);
		this.next = new ArrayList<Subject>();
		this.require = new ArrayList<Subject>();	
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getYear() {
		return year;
	}
	public ArrayList<Subject> getNext() {
		return next;
	}
	public ArrayList<Subject> getRequire() {
		return require;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
	public static ArrayList<Subject> insertSubject(String id, String req, ArrayList<Subject> root) {
		Subject s = new Subject(id,"","");
		if(req.equals("-")) {
			root.add(s);
			submap.put(id, s);
		}else {		
			submap.put(id, s);
			s.addReq(submap.get(req));
			submap.get(req).addNext(s);		
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		ArrayList<Subject> rootSub = new ArrayList<Subject>();
		
		String st = "a";
		String req = "-";	
		rootSub = insertSubject(st, req, rootSub);
		
		st = "b";
		req = "a";
		rootSub = insertSubject(st, req, rootSub);
		
		st = "c";
		req = "b";
		rootSub = insertSubject(st, req, rootSub);
		
		for(Subject s : rootSub) {
			System.out.println(s);
			for(Subject sN : s.next) {
				System.out.println(sN);
				for(Subject sNN : sN.next) {
					System.out.println(sNN);
				}
			}
		}
		

	}
	
	
}
