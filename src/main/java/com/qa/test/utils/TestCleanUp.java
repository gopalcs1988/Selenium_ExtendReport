package com.qa.test.utils;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TestCleanUp {

	public static void clearTempFolder() throws IOException {
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current DIR: " + currentDir);
		String location = currentDir + "/src/test/resources/TestDataFiles/Snapshots";
		System.out.println("Current DIR Location: " + location);
		try {

			File file = new File(location);
			FileUtils.cleanDirectory(file);

		} catch (IOException e) {
// Do nothing since we do not worry about the files that cannot be deleted
// Include exception handler logic if you want to
		}
	}

}
