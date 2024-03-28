package com.webstaurantstore.utils;

import java.nio.file.FileSystems;

public class FilePaths {

	private FilePaths() {}
	
	public static FilePath withRoot(String path) {
		return new FilePath(path);
	}
	
	public static String getUserDir() {
		return System.getProperty("user.dir");
	}
	
	public static class FilePath {
		
		private StringBuilder pathBuilder = null;
		private String seperator = FileSystems.getDefault().getSeparator();
		
		public FilePath(String rootPath) {
			pathBuilder = new StringBuilder(rootPath);
		}
		
		public FilePath append(String value) {
			pathBuilder.append(seperator).append(value);
			return this;
		}
		
		public String get() {
			return pathBuilder.toString();
		}
		
		@Override
		public String toString() {
			return get();
		}
	}
}
