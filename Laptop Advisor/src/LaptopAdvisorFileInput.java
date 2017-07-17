/*
 * This class reads (by using a scanner)the laptop.csv file that we exported from google sheets
 * regarding the specifications of the laptops that we found (20 laptops)
 * This is important for sending information to the other classes
 * Author - Leon Li
 */

import java.io.*;
import java.util.Scanner;

public class LaptopAdvisorFileInput {
	
	public LaptopAdvisorFileInput(Laptop[] laptop) {

		try {

			//reads in laptop CSV file
			Scanner input = new Scanner(new File("laptop.csv"));
			input.useDelimiter(","); //

			input.nextLine();  //gets rid of the header row

			int index = 0;  //tracks the laptop index (0-19)

			while (input.hasNextLine()){ //runs a loop that sets laptop values for laptops 0 -29

				laptop[index] = new Laptop();
				
				laptop[index].setBrand(input.next().replaceAll("\r\n", "")); //ignores the auto generated text at the start of each line
				laptop[index].setSeries(input.next());
				laptop[index].setOS(input.next());
				laptop[index].setModel(input.next());

				laptop[index].setPrice(input.nextDouble());
				laptop[index].setScreenSize(input.nextDouble());
				
				laptop[index].setResolution(input.next());
				laptop[index].getRatings()[0] = input.nextInt(); //resolution rating

				laptop[index].setDimensions(input.next()); 
				laptop[index].setWeight(input.nextDouble());
				
				laptop[index].setGpu(input.next());
				laptop[index].getRatings()[1]= (input.nextInt()); //gpu rating

				laptop[index].setBattery(input.nextInt());
				laptop[index].getRatings()[2]= (input.nextInt()); //battery rating 

				laptop[index].setTouchscreen(input.nextBoolean());
				
				laptop[index].setRam(input.nextInt());
				laptop[index].getRatings()[3]= (input.nextInt()); //GPU rating

				laptop[index].setHdd(input.nextBoolean());
				laptop[index].getRatings()[4]= (input.nextInt()); //storage type rating

				laptop[index].setStorageSize(input.nextInt());
				laptop[index].getRatings()[5]= (input.nextInt()); //storage size rating

				laptop[index].setCpu(input.next());
				laptop[index].getRatings()[6]= (input.nextInt()); //CPU rating

				laptop[index].setProcessorCores(input.nextInt());
				laptop[index].setProcessorSpeed(input.nextDouble());
				
				laptop[index].setOpticalDrive(input.nextBoolean());
				laptop[index].getRatings()[7]= (input.nextInt()); //Optical drive rating

				laptop[index].setPorts(input.next());
				
				laptop[index].setBluetooth(input.nextBoolean());
				laptop[index].getRatings()[8]= (input.nextInt()); //Bluetooth rating
				
				laptop[index].setColour(input.next());
				laptop[index].setLink(input.next());
				
				
				index++; //increases the index so ratings can be set for next laptop
			}

			input.close();
			
		} catch (FileNotFoundException e){ //checks if there is an error in reading the excel file and prints an error out if there is.
			System.out.println("Sorry error with file- pls check name");
		}

	}//end of while loop


}//end of class

