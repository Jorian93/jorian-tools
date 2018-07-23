package java_Studing_day51_IO_fileExtraction;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter implements FilenameFilter {

	private String endWith;
	
	MyFilter(String endWith){
		this.endWith=endWith;
	}
	
	@Override
	public boolean accept(File dir, String endWith) {
		endWith=this.endWith;
		//f返回以.jpg结尾的文件
		return endWith.endsWith(endWith);
	}

}
