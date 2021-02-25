package pack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	public static int [] array;
	public static double numberOfChanges=0;
	
	public static void main(String[] args) throws IOException {
		
		//Assign the firstLine number that the number of cases the entry is going to have
		String strDataNumber=br.readLine();
		int dataNumber= Integer.valueOf(strDataNumber);
		
		//Go to the nextLine where the cases start
		String data=br.readLine();
		
		for (int i=0;i<dataNumber;i++) {
             
             String[] strArray=convertStringToArray(data); //
             double[] doubleArray=convertDataToDoubleArray(strArray, dataNumber);
             double[] sortedArray=bubbleSort(doubleArray);
             bw.write(numberOfChanges+"-"+convertArrayToString(sortedArray)+"\n");
             numberOfChanges=0;
             
             if(i!=dataNumber-1) {
             data = br.readLine();
             }
         }
      
		br.close();
		bw.close();
	}

	//This method converts the double array to a String Line that separates array elements with a " "
	public static String convertArrayToString(double[] array) {
		String lineMessage = null;
		String[] strArray= new String[array.length];
		
		for(int i=0;i<array.length;i++) {
			strArray[i]=String.valueOf(array[i]);
		}
		for(int i=0;i<strArray.length;i++) {
			if(i==0) {
				lineMessage=strArray[i]+" ";
			}
			else if(i!=strArray.length-1) {
				lineMessage+=strArray[i]+" ";
			}
			else {
				lineMessage+=strArray[i];
			}
		}
		return lineMessage;
		
	}
	
	public static String[] convertStringToArray(String data) throws IOException {
		String[] parts = data.split(" ");
		return parts;
		
	}
	
	public static double[] convertDataToDoubleArray(String[] strArray,int dataQuantity) {
		double [] dataArray=new double[strArray.length];
		for (int i=0;i<strArray.length;i++) {
			dataArray[i]=Double.parseDouble(strArray[i]);
        }
		return dataArray;
		
	}
	
	public static double[] bubbleSort(double[] array) {
		for(int j=1;j<array.length;j++) {
			for(int i=0;i<array.length-1;i++) {
				if(array[i]>array[i+1]) {
					double temp=array[i];
					array[i]=array[i+1];
					array[i+1]=temp;
					numberOfChanges++;
				}
			}
		}
		numberOfChanges=numberOfChanges/(array.length-1);
		numberOfChanges=eraseDecimals();
		return array;
	}
	public static double eraseDecimals() {
		double numero=numberOfChanges*100;
		numero=(int)numero;
		numero=numero/100;
		
		return numero;
		
	}
	

}