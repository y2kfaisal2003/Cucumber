package com.dataProivder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.dataEntity.TestEntity;
import com.dataEntity.TestEntityAPI;
import com.dataEntity.ExcelDataToEntity;

public class DataProviderSource {
	
	
	@DataProvider(name="TestMethod") 
    public Iterator<TestEntity> getEntityData(Method method) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//System.out.println(method.getName());
		List<TestEntity> testentity=ExcelDataToEntity.getTestEntityData("/resources/DataSource/TestData.xlsx", method.getName());
        return testentity.iterator();
    }
	
	@DataProvider(name="TestMethodAPI") 
    public Iterator<TestEntityAPI> getAPIData(Method method) throws ClassNotFoundException {
		System.out.println(method.getName());
		List<TestEntityAPI> testentity=ExcelDataToEntity.getAPITestEntityData("/resources/DataSource/APITestData.xlsx", method.getName());
        return testentity.iterator();
    }
	
	
	
	
//	@DataProvider
//	public Object[][] scenarioData(){
//	return new Object[][]{{5, "five"}, {6, "six"}};
//	}
//	
//	@DataProvider
//	public Object[] scenarioData1(){
//	return new Object[]{"five", "six", "seven"};
//}
//	@DataProvider(name="scenarioData3")
//    public static Object[][] getScenarioData(Method method) {       
//        String testCase = method.getName();
//        if ("scenario1".equals(testCase)) {
//            return new Object[][]{{"Scenario1 data"}};
//        } else if ("scenario2".equals(testCase)) {
//            return new Object[][]{{"Scenario2 data"}};
//        } else {
//            return new Object[][]{{"Common scenario data"}};
//        }
//    }   
//     
//    @DataProvider(name="TestType")
//    public static Object[][] getTestTypeData(ITestContext context) {        
//        String testName = context.getClass().getName();
//        if ("IntegrationLevel".equals(testName)) {
//            return new Object[][]{{"Integration test data"}};
//        } else if ("AcceptanceLevel".equals(testName)) {
//            return new Object[][]{{"Acceptance test data"}};
//        } else {
//            return new Object[][]{{"Common test data"}};
//        }
//    }   
    
    
}
