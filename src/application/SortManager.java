package application;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import shape.Shape;

public clas SortManager {
	char comparison;
	char sortType;
	String fileName;
	Shape [] shapes;

	
	public SortManager(String[] args) {
		
	
		for (String arg: args)
		{
			if(arg.toLowerCase().startsWith("-t")) {
				comparison = arg.toLowerCase().charAt(2);
			}
			if(arg.toLowerCase().startsWith("-s")) {
				sortType = arg.toLowerCase().charAt(2);
			}
			if(arg.toLowerCase().startsWith("-f")) {
				fileName = arg.toLowerCase().substring(2);
			}
			
				
		}
		
		fillShapes();
		sortShapes();
		
	}


	private void sortShapes() {
		// TODO Auto-generated method stub
//		if(sortType == 'b' || sortType =='B')
//		{
//			if(compareType == 'h')
//			{
//				
//			}
//		}
		
	}


	private void fillShapes() {
		try 
		{
			Object o;
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            if ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); 
            }

			fileReader.close();
            bufferedReader.close();
            
            String [] fields = line.split(" ");
            shapes = new Shape[Integer.parseInt(fields[0])];
            int counter = 1; 
            
            for(int i = 0; i < shapes.length; i++) {
            	String className = "shape."+ fields[counter++];
                 
                //System.out.println(className);
                //this prints the Shape name
     			Class cls = Class.forName(className);
     			
     			
     			
 				Class paramTypes[] = new Class[2];
 				paramTypes[0] = Double.TYPE;
 				paramTypes[1] = Double.TYPE;
 				
 				
 				Constructor ct = cls.getConstructor(paramTypes);
 				
 				Object argList[] = new Object[2];
 				argList[0] = Double.parseDouble(fields[counter++]);
 				argList[1] = Double.parseDouble(fields[counter++]);
 				
 				o = ct.newInstance(argList);
 				
 				shapes[i] = (Shape) o;
 				//System.out.println(shapes[i]);
            	//this prints the values
            
           
			}
            
		} 
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
		catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

