/**
 * 
 */
package java112.analyzer;

/**
 * @author azsupport
 *
 */
/**
 * @author azsupport
 *
 */
public class AnalyzerThread extends Thread {
	
	private AnalyzeFile analyzeFile;
	private Analyzer analyzer;
	
	/**
	 * @param analyzeFile Analyzer initiators
	 * @param analyzer An analyzer to process file tokens
	 */
	public AnalyzerThread(AnalyzeFile analyzeFile, Analyzer analyzer) {
		super();		
		this.analyzeFile = analyzeFile;
		this.analyzer = analyzer;
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		analyzeFile.processAllTokens(analyzer);
		analyzeFile.writeAllOutputFiles(analyzer);
	}

}
