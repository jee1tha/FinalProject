package businessOperationsLayer;

import databaseLayer.Applicants;

public interface NNModels {
	public int trainAndSaveModel();
	public double loadAndEvaluateModel(Applicants app);
}
