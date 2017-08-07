package org.jsystem;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

import org.junit.Before;
import org.junit.Test;

public class FileOperations extends SystemTestCase4 {

	private String fileName;
	private FileSystemSo fileSystem;

	@Before
	public void setUp() throws Exception {
		fileSystem = (FileSystemSo) system.getSystemObject("fileSystemSo");
	}

   	/**
	 * Verifies that the specified file exists in the current folder
	 */
	@Test
        @TestProperties(name = "Verify that file ${fileName} exists", paramsInclude = { "fileName" })
        public void verifyFileExistence(){
		fileSystem.verifyFileExistence(fileName);

        }

        public String getFileName() {
            return fileName;
        }

       @ParameterProperties(description = "Expected file name")
       public void setFileName(String fileName) {
           this.fileName = fileName;
       }

}