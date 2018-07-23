package java_Studing_day51_IO_fileExtraction;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	/**
	 * 场景：汇总某个路径下的指定格式的文件到一个统一的路径下，便于统一查看
	 * 
	 * 需求分析：
	 * 	读取指定目录下的文件列表，
	 * 	找出其中符合条件的所有文件，
	 * 	写入到指定的目标目录下
	 * 
	 * 思路:
	 *  1.文件有深度，必须进行深度遍历
	 *  2.遍历的过程中过滤符合条件的文件路径存储到容器中
	 *  3.对容器中的路径进行遍历,获取文件名,并封装成文件,
	 *  4.读取文件并写入到目标路径下
	 * 
	 */	
	public static void main(String[] args) throws IOException {
		
		//指定要读取目录或者盘符  
		File dir=new File("F://BaiduNetdiskDownload/java高级篇/");
		//指定要写入的目录或者盘符
		File TargetFile=new File("F://java学习之路/javastudy/提高篇文档");		
		if(!TargetFile.exists())
		TargetFile.mkdir();		
		//描述一个过滤器
		FilenameFilter filter=new MyFilter(".doc");		
		//定义一个容器
		List<String> fileNamelist=new ArrayList<String>();
		
		//遍历指定目录下的文件
		PickUpFile puf=new PickUpFile();
		puf.getFile(dir,filter,fileNamelist);
		//写入到指定目录		
		puf.writeToFile(fileNamelist,TargetFile);

	}
}
