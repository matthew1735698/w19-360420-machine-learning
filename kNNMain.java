import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String pathToData = args[0];
	
	List<DataPoint> flower = DataSet.readDataSet(pathToData);
	
	DataPoint dp = flower.get (32);
	
	System.out.println(dp.getLabel());
	
	String printableX = Arrays.toString(dp.getX());
	
	System.out.println(printableX);

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> testSet = DataSet.getTestSet(flower, 0.3);
	
	List<DataPoint> trainingSet = DataSet.getTrainingSet(flower, 0.7);
	
	
    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier nearestnb = new KNNClassifier(5);
	String prediction = nearestnb.predict(trainingSet, trainingSet.get(30));
	System.out.println("Test: "+prediction);
	
	
	


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	double correct = 0.;
	double total = 0.;
	
	for (int i = 0; i<105; i++) {
		
		String prediction1 = nearestnb.predict(trainingSet, trainingSet.get(i));
		
		if (prediction1.equals(trainingSet.get(i).getLabel())) {
		
		correct++;
		}
		total++;
	}
	double error = Math.round((correct/total)*10000)/100;
	System.out.println(error);


  }

}
