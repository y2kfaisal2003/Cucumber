package com.utilities;

import java.io.File;

import com.dataExcelReader.ExcelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class FileUtility {

	public static void copyFile(String strSource, String strDestination){
		InputStream inStream = null;
		OutputStream outStream = null;

		try{

			File source =new File(System.getProperty("user.dir")+strSource);
			File dest =new File(System.getProperty("user.dir")+strDestination);
			dest.deleteOnExit();
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(dest);
			dest.deleteOnExit();
			byte[] buffer = new byte[1024];

			int length;
			//copy the file content in bytes 
			while ((length = inStream.read(buffer)) > 0){
				outStream.write(buffer, 0, length);
			}

			inStream.close();
			outStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private static List<List<String>>  getExcelData(String filePath, String testsheet) throws ClassNotFoundException {

		String strFilePaht=System.getProperty("user.dir")+filePath;
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
		.setFileLocation(strFilePaht)
		.setSheet(testsheet)
		.build();
		List<List<String>> excelData = getExcelSheetData(reader);

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


	public static Boolean compareFiles(String strSource, String strSourceSheet, String strDestination,
			String strDestinationSheet) throws ClassNotFoundException {
		List<List<String>> expectedData =getExcelData(strSource,strSourceSheet);
		List<List<String>> actualData =getExcelData(strDestination,strDestinationSheet);
		return validateExpectedResult(expectedData,actualData);
	}


	private static Boolean validateExpectedResult(List<List<String>> expectedData, List<List<String>> actualData) {
		return true;
	}




}
