package databaseLayer;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.Perceptron;

public class nn {

	public void neun(){
		NeuralNetwork neuralNetwork = new Perceptron(2, 1);

		// create training set
		TrainingSet<SupervisedTrainingElement> trainingSet =
		 new TrainingSet<SupervisedTrainingElement>(2, 1); 
	}
}
