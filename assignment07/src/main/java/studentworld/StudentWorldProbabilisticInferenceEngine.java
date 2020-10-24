package studentworld;

import java.util.ArrayList;
import java.util.List;

public class StudentWorldProbabilisticInferenceEngine {
	
	public static String getTargetCell(List<String> frontierCells, List<String> smellyCells) {
	    //todo: implement
	    ArrayList<String> riskyCells = new ArrayList<String>();
	    generateRiskyCells(frontierCells, riskyCells);
	    System.out.println("hu");
	    double[] findBestMove = new double[frontierCells.size()];
	    for(int i = 0; i < frontierCells.size(); i++)
	    {
	        String cell = frontierCells.get(i);
	        findBestMove[i] = calculateStudentProbabilityForCell(cell, frontierCells, smellyCells);
	    }
	    
	    //double min = findBestMove[0];
	    double min = Integer.MAX_VALUE;
	    String nextMove = frontierCells.get(0);
	    for(int i = 0; i < findBestMove.length; i++)
	    {
	        if(findBestMove[i] < min)
	        {
	            min = findBestMove[i];
	            nextMove = frontierCells.get(i);
	        }
	    }
	    
	    return nextMove;
	}
	
	
	public static double calculateStudentProbabilityForCell(String cell, List<String> frontierCells, List<String> smellyCells) {
		//todo: implement
		// case 1: assume there is a student
		
		double hasStudent = calculateProbabilitySum(cell, true,  frontierCells, smellyCells);
		double noStudent = calculateProbabilitySum(cell, false,  frontierCells, smellyCells);

		// multiply
		double pKnown = 0.2 * hasStudent;
		double pUnknown = 0.8 * noStudent;
		
		// normalize
		double percentKnown = pKnown / (pKnown + pUnknown);
		//double percentUnknown = pUnknown / (pKnown + pUnknown);
		return percentKnown;
		//return Math.max(percentKnown, percentUnknown);
	}
	
	
	/*
	 * boolean hasStudent: indicates whether or not you're trying to calculate probability sum assuming String cell contains a student
	 * 						or assuming this cell does not contain a student. Look at the last few powerpoint slides
	 */
	public static double calculateProbabilitySum(String cell, boolean hasStudent, List<String> frontierCells, List<String> smellyCells) {
		StudentWorldProbabilisticInferenceEngineConstraintSolver swpiecs = new StudentWorldProbabilisticInferenceEngineConstraintSolver();
		frontierCells = new ArrayList<String>(frontierCells);
		String riskyCell;
		
		for(int i=0; i<frontierCells.size(); i++) {
			riskyCell = frontierCells.get(i);
			if(riskyCell.equals(cell)) {
				if(hasStudent) {
					riskyCell = riskyCell.replace("= [0,1]", "= 1").replace("student", "fixed-student");
				} else {
					riskyCell = riskyCell.replace("= [0,1]", "= 0").replace("student", "fixed-student");
				}
				frontierCells.set(i, riskyCell);
				break;
			}
		}

		return swpiecs.findSolutionsForProbabilisticInferenceEngine(frontierCells, smellyCells);
	}
	
	private static void generateRiskyCells(List<String> frontierCells, List<String> riskyCells) {
		String riskyCell;
		for(int i=0; i<frontierCells.size(); i++) {
			riskyCell = frontierCells.get(i);
			if(riskyCell.startsWith("student") && riskyCell.endsWith("1")) {
				riskyCell = riskyCell.replace("student", "fixed-student");
				frontierCells.set(i, riskyCell);
			} else {
				riskyCells.add(riskyCell);
			}
		}
	}
}