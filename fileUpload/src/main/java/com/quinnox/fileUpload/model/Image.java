package com.quinnox.fileUpload.model;

public class Image {
	
		private String fileName;
		private String base64Image;
		
		public Image() {

		}

		public Image(String fileName, String base64Image) {
			this.fileName = fileName;
			this.base64Image = base64Image;
		}

		@Override
		public String toString() {
			return "Image [fileName=" + fileName + ", base64Image=" + base64Image + "]";
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getBase64Image() {
			return base64Image;
		}

		public void setBase64Image(String base64Image) {
			this.base64Image = base64Image;
		}
		
		
}
