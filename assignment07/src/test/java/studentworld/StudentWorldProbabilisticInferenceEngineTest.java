package studentworld;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StudentWorldProbabilisticInferenceEngineTest {

	@Test
	public void testCaseOne() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseOne();
			List<String> smellyCells = generateSmellyCellsForCaseOne();
			String targetCell = StudentWorldProbabilisticInferenceEngine.getTargetCell(riskyFringeCells, smellyCells);
			String[] expectedTargetCells = {"student (0,2) = [0,1]", "student (2,0) = [0,1]"};
			if(!Arrays.asList(expectedTargetCells).contains(targetCell)) {
				fail("getTargetCell returning incorrect cell: " + targetCell);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	@Test
	public void testCaseOneProbabilities() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseOne();
			List<String> smellyCells = generateSmellyCellsForCaseOne();
			
			Double p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (0,2) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			Double expectedP = 0.31;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (1,1) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.86;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (2,0) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.31;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);

			
		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	@Test
	public void testCaseTwo() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseTwo();
			List<String> smellyCells = generateSmellyCellsForCaseTwo();
			String targetCell = StudentWorldProbabilisticInferenceEngine.getTargetCell(riskyFringeCells, smellyCells);
			String expectedTargetCell = "student (3,2) = [0,1]";
			assertEquals("getTargetCell not returning correct cell", expectedTargetCell, targetCell);
		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	@Test
	public void testCaseTwoProbabilities() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseTwo();
			List<String> smellyCells = generateSmellyCellsForCaseTwo();
			
			Double p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (0,4) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			Double expectedP = 0.55;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (1,3) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.55;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (3,2) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.20;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);

			
		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	@Test
	public void testCaseThree() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseThree();
			List<String> smellyCells = generateSmellyCellsForCaseThree();
			String targetCell = StudentWorldProbabilisticInferenceEngine.getTargetCell(riskyFringeCells, smellyCells);
			String[] expectedTargetCells = {"student (3,1) = [0,1]", "student (4,2) = [0,1]"};
			if(!Arrays.asList(expectedTargetCells).contains(targetCell)) {
				fail("getTargetCell returning incorrect cell: " + targetCell);
			}		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	@Test
	public void testCaseThreeProbabilities() {
		try {
			List<String> riskyFringeCells = generateRiskyCellsForCaseThree();
			List<String> smellyCells = generateSmellyCellsForCaseThree();
			
			Double p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (2,4) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			Double expectedP = 0.37;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (3,1) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.27;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (3,3) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.77;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);
			
			p = StudentWorldProbabilisticInferenceEngine.calculateStudentProbabilityForCell("student (4,2) = [0,1]", riskyFringeCells, smellyCells);
			p = Math.floor(p*100)/100.0;
			expectedP = 0.27;
			assertEquals("getTargetCell not returning correct cell", expectedP, p);

			
		} catch(Exception e) {
			e.printStackTrace();
			fail("check the console for the exception stack trace");
		}
	}
	
	private List<String> generateRiskyCellsForCaseOne() {
		List<String> riskyFringeCells = new ArrayList<String>();
		riskyFringeCells.add("student (0,2) = [0,1]");
		riskyFringeCells.add("student (1,1) = [0,1]");
		riskyFringeCells.add("student (2,0) = [0,1]");
		return riskyFringeCells;
	}
	
	private List<String> generateSmellyCellsForCaseOne() {
		List<String> smellyCells = new ArrayList<String>();
		smellyCells.add("smelly (0,1) = 1");
		smellyCells.add("smelly (1,0) = 1");
		return smellyCells;
	}
	
	private List<String> generateRiskyCellsForCaseTwo() {
		List<String> riskyFringeCells = new ArrayList<String>();
		riskyFringeCells.add("student (0,4) = [0,1]");
		riskyFringeCells.add("student (1,3) = [0,1]");
		riskyFringeCells.add("student (2,2) = 1");
		riskyFringeCells.add("student (3,2) = [0,1]");
		riskyFringeCells.add("student (4,1) = 1");
		return riskyFringeCells;
	}
	
	private List<String> generateSmellyCellsForCaseTwo() {
		List<String> smellyCells = new ArrayList<String>();
		smellyCells.add("smelly (0,3) = 1");
		smellyCells.add("smelly (1,2) = 1");
		smellyCells.add("smelly (2,1) = 1");
		smellyCells.add("smelly (3,1) = 1");
		smellyCells.add("smelly (4,0) = 1");
		return smellyCells;
	}
	
	private List<String> generateRiskyCellsForCaseThree() {
		List<String> riskyFringeCells = new ArrayList<String>();
		riskyFringeCells.add("student (0,4) = 1");
		riskyFringeCells.add("student (2,0) = 1");
		riskyFringeCells.add("student (2,4) = [0,1]");
		riskyFringeCells.add("student (3,1) = [0,1]");
		riskyFringeCells.add("student (3,3) = [0,1]");
		riskyFringeCells.add("student (4,2) = [0,1]");
		return riskyFringeCells;
	}
	
	private List<String> generateSmellyCellsForCaseThree() {
		List<String> smellyCells = new ArrayList<String>();
		smellyCells.add("smelly (0,3) = 1");
		smellyCells.add("smelly (1,0) = 1");
		smellyCells.add("smelly (1,4) = 1");
		smellyCells.add("smelly (2,1) = 1");
		smellyCells.add("smelly (2,3) = 1");
		smellyCells.add("smelly (3,2) = 1");
		return smellyCells;
	}
}
