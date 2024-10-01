package Program2;

import java.util.*;
import java.io.*;

public class Course {
	public ArrayList<String> AllsubCode = new ArrayList<String>();
	public ArrayList<Subject> rootsub = new ArrayList<Subject>();
	public static HashMap<String, Subject> submap = new HashMap<String, Subject>();
	
	public Course(String file) {
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			for(int numLine = 0; (line = reader.readLine()) != null; numLine++) {
				if(numLine==0) continue; // don't want header!	
				String[] row = line.split(",");
				if(row.length == 0)
					continue;
				String id = row[0];
				String name = row[1];
				String year = row[4];
				
				Subject s;
				AllsubCode.add(id);
				if(!submap.containsKey(id)) {
					s = new Subject(id, name, year);
					submap.put(id, s);
				}else {
					s = submap.get(id);
					s.set(id, name, year);				
				}

				if(!row[3].equals("-")) {
					String[] prev = row[3].split("_");
					for(String req : prev) {
						if(submap.get(req) != null) {
							s.addReq(submap.get(req));
							submap.get(req).addNext(s);
						}else {
							Subject sub = new Subject(req, "undefine", "0");
							submap.put(req, sub);
							
							s.addReq(submap.get(req));
							submap.get(req).addNext(s);
						}
					}
				}	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Course cpe = new Course("src\\cpeTest.csv");
		
		for(String code : cpe.AllsubCode) {
			System.out.println("Name: " + submap.get(code).getName());
			System.out.println("id: " + submap.get(code).getId());
			System.out.print("Require-> ");
			if(submap.get(code).getRequire().isEmpty())
				System.out.println("null");
			for(Subject s : submap.get(code).getRequire()) {
				System.out.print(s.getId()+" ");
			}
			System.out.print("\nNext-> ");
			if(submap.get(code).getNext().isEmpty())
				System.out.println("null");
			for(Subject s : submap.get(code).getNext()) {
				System.out.print(s.getId()+" ");
			}
			System.out.println("\n");
		}
	}
}
