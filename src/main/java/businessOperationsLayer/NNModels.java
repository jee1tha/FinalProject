package businessOperationsLayer;

import databaseLayer.Applicants;

public interface NNModels {
	public void trainAndSaveModel();
	public double loadAndEvaluateModel(Applicants app);
}
