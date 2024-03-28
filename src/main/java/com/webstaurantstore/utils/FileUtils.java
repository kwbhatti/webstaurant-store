package com.webstaurantstore.utils;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

/**
 * Utility to manage Files
 * @author kbhatti
 *
 */
public class FileUtils {
	
	public static File createDir(File directory) {
		if (!directory.exists()) directory.mkdirs();
        return directory;
    }
	
	public static File createCopy(File sourceFile, File destFile) throws IOException {
		Files.copy(sourceFile, destFile);
		return destFile;
    }
}
