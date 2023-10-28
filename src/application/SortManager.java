package application;

import java.io.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

import utility.Sorts;

import shape.Shape;

public class SortManager{
	char comparison;
	char sortType;
	char compareType;
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
		
//		fillShapes();
//		sortShapes();
		
	}
	
	


	public void sortShapes() {
	    if (sortType == 'b' || sortType == 'B') {  // Check if bubble sort is selected
	        if (comparison == 'h' || comparison == 'H') {  // Check if comparison is based on height
	            Sorts.bubbleSort(shapes);  // Use natural ordering (height)
	        } else if (comparison == 'v' || comparison == 'V') {  // Check if comparison is based on volume
	            Sorts.bubbleSort(shapes, new Comparator<Shape>() {
	                @Override
	                public int compare(Shape firstshape, Shape secondshape) {
	                    return firstshape.compare(firstshape, secondshape);  // Use volume comparison
	                }
	            });
	        }
	    }
	}


	public void fillShapes() {
		try 
		{
			Object o;
            FileReader fileReader = new FileReader("C:\\Users\\user\\Desktop\\OOP 3\\Assign1_OOP\\res\\polyfor1.txt");
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
                 
                System.out.println(className);
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
 				System.out.println(shapes[i]);
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

