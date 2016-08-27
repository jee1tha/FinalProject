package businessOperationsLayer;

import java.io.File;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.ml.train.MLTrain;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.Train;
import org.encog.neural.networks.training.propagation.Propagation;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.persist.EncogDirectoryPersistence;

public class EGpersis {

	public static double XOR_INPUT[][] = {  {0.0001,
		0.0002,
		0.0003,
		0.0004,
		0.0005},
             {0.0444,
			0.0555,
			0.0777,
			0.0888,
			0.0999},
        
		};
	public static double XORz_INPUT[][] ;

	public static double XOR_INPUT2[] = { 0.0001,
			0.0002,
			0.0003,
			0.0004,
			0.0005};
	public static double XOR_IDEAL[][] = { {1.0},
            {0.0},
           };
	
/*	public static double XOR_INPUT2[][] = { { 1.0, 1.0 }, { 1.0, 0.0 },
			{ 1.1, 1.0 }, { 1.0, 1.0 } };
	
	public static double XOR_IDEAL2[][] = { { 1.0 }, { 1.0 }, { 1.0 }, { 1.0 } };*/
	
	public static final String FILENAME = "network.eg";
	public static void main(String[] args) {
		EGpersis g = new EGpersis();
	//	g.trainAndSave();
		g.loadAndEvaluate();
	}
	
	public void trainAndSave(){
		
		
		
		System.out.println("Training XOR network under 1% error rate.");
		
		
		
		BasicNetwork network = new BasicNetwork();
		network.addLayer(new BasicLayer(5));
		network.addLayer(new BasicLayer(6));
		network.addLayer(new BasicLayer(1));
		network.getStructure().finalizeStructure();
		network.reset();
		
		// training data set
		
		MLDataSet trainingSet = new BasicMLDataSet(XOR_INPUT, XOR_IDEAL);
		
		final Propagation  train =  new Backpropagation(network, trainingSet);
		int epoch = 1;
		do {
			train.iteration();
			System.out.println("Epoch #" + epoch + 
                    " Error:" + train.getError());
					epoch++;

		} while (train.getError() > 0.001);
		
		double e = network.calculateError(trainingSet);
		System.out.println("Network trained to error :" + e);
		System.out.println("Saving Network");
		
		
		EncogDirectoryPersistence.saveObject(new File(FILENAME), network);
	}
	
	
	public void loadAndEvaluate(){
		System.out.println("Loading Network");
		BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));
		
	//	BasicMLData trainingSet = new BasicMLData(XOR_INPUT2);
	//	double e = network.calculateError(trainingSet);
	//	System.out.println(network.compute(trainingSet));
		double[] output = new double[1];
		network.compute(XOR_INPUT2, output);
	    System.out.println("Network output: " + output[0] + " (should be close to 0.0)");
	//	double d = network.winner((MLData) trainingSet);
		
	//	System.out.println(network.compute((MLData) trainingSet));
	//	System.out.println("Loaded network's error is (should be the same as above ):" + e);
		
	}
}
