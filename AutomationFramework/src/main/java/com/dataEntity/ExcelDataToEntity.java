package com.dataEntity;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.dataEntity.TestEntity;
import com.dataEntity.TestEntityAPI;
import com.dataExcelReader.ExcelReader;
public class ExcelDataToEntity {

	public static List<TestEntity> getTestEntityData(String filePath, String testMethod) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		String strFilePaht=System.getProperty("user.dir")+filePath;
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
		.setFileLocation(strFilePaht)
		.setSheet(testMethod)
		.build();
		List<List<String>> excelData = getExcelData(reader);
		List<TestEntity> dataEntity=getDataEntity(excelData);

		return dataEntity;
	}

	public static List<TestEntityAPI> getAPITestEntityData(String filePath, String testMethod) throws ClassNotFoundException {

		String strFilePaht=System.getProperty("user.dir")+filePath;
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
		.setFileLocation(strFilePaht)
		.setSheet(testMethod)
		.build();
		List<List<String>> excelData = getExcelSheetData(reader);
		List<TestEntityAPI> dataEntity=getApiDataEntity(excelData);

		return dataEntity;
	}

	private static List<TestEntityAPI> getApiDataEntity(List<List<String>> excelData) {
		List<TestEntityAPI> testEntities = new LinkedList<TestEntityAPI>();
		for(int i=1;i<excelData.size();i++){
			List<String> listRows =excelData.get(i);
			if(listRows.get(0).equalsIgnoreCase("Y")){
				TestEntityAPI testEntity = new TestEntityAPI();
				testEntity.setRUN(listRows.get(0));
				testEntity.setModule(listRows.get(1));
				testEntity.setTestName(listRows.get(2));
				testEntity.setMethod(listRows.get(3));
				testEntity.setEndPoint(listRows.get(4));
				testEntity.setURI(listRows.get(5));
				testEntity.setStatusCode(listRows.get(6));
				testEntity.setStatusLine(listRows.get(7));
				testEntity.setBody(listRows.get(8));
				testEntities.add(testEntity);
			}
			else
				continue;
		}
		return testEntities;
	}

	// Old Implementation
	private static List<TestEntity> getDataEntity1(List<List<String>> excelData) {
		List<TestEntity> testEntities = new LinkedList<TestEntity>();
		for(int i=1;i<excelData.size();i++){
			List<String> listRows =excelData.get(i);
			if(listRows.get(0).equalsIgnoreCase("Y")){
				TestEntity testEntity = new TestEntity();
				testEntity.setRun(listRows.get(0));
				testEntity.setTestName(listRows.get(1));
				testEntity.setUser(listRows.get(2));
				testEntity.setPassword(listRows.get(3));
				testEntity.setPageTitle(listRows.get(4));
				testEntity.setSearchText(listRows.get(5));
				testEntity.setActionText(listRows.get(6));
				testEntities.add(testEntity);
			}
			else
				continue;
		}
		return testEntities;
	}


	private static List<TestEntity> getDataEntity(List<List<String>> excelData) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		List<TestEntity> testEntities = new LinkedList<TestEntity>();
		List<String> listRowsHeaders =excelData.get(0);
		Class[] paramString = new Class[1];	
		paramString[0] = String.class;
		for(int i=1;i<excelData.size();i++){
			List<String> listRows =excelData.get(i);
			Class<?> testEntityClass = Class.forName("com.dataEntity.TestEntity");
			Object testEntity = testEntityClass.newInstance();
			if(listRows.get(0).equalsIgnoreCase("Y")){
				for (int j=1;j< listRows.size();j++){
					String methodName="set"+listRowsHeaders.get(j);
					Method method = testEntityClass.getDeclaredMethod(methodName, paramString);
					method.invoke(testEntity, listRows.get(j));
				}
				testEntities.add((TestEntity) testEntity);
			}
			else
				continue;
		}
		return testEntities;
	}


	private static List<List<String>> getExcelData(ExcelReader reader) {
		List<List<String>> excelData = new LinkedList<List<String>>();
		try {
			excelData = reader.getSheetDataAt();
		} catch (InvalidFormatException  e) {
			throw new RuntimeException(e.getMessage());
		}catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}
	private static List<List<String>> getExcelSheetData(ExcelReader reader) {
		List<List<String>> excelData = new LinkedList<List<String>>();
		try {
			excelData = reader.getSheetData();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}

}
