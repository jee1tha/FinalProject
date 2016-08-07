package encog;

import java.io.File;

import org.encog.app.analyst.AnalystFileFormat;
import org.encog.app.analyst.EncogAnalyst;
import org.encog.app.analyst.csv.normalize.AnalystNormalizeCSV;
import org.encog.app.analyst.wizard.AnalystWizard;
import org.encog.util.csv.CSVFormat;

public class ecog {

	public static void main(String[] args) {
		
		
		
		ecogTest();
		
	}
	
	public static void ecogTest(){
		File sourceFile = new File("source.txt");
		File targetFile = new File("target.txt");
		
		EncogAnalyst analyst = new EncogAnalyst();
		AnalystWizard wizard = new AnalystWizard(analyst);
		
		wizard.wizard(sourceFile, true, AnalystFileFormat.DECPNT_COMMA);
		
		final AnalystNormalizeCSV norm = new AnalystNormalizeCSV();
		norm.analyze(sourceFile, true, CSVFormat.ENGLISH, analyst);
		
		norm.setProduceOutputHeaders(true);
		
		norm.normalize(targetFile);
		
		analyst.save(new File("stats.ega"));
	}
}
