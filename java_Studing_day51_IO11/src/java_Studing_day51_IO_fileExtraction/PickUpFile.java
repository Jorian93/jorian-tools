package java_Studing_day51_IO_fileExtraction��11_�ۺ���ϰ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickUpFile {
	/**
	 * 获取所有文件
	 * @param dir 指定的文件获取目录
	 * @param filter  自定义的文件格式过滤器
	 * @param list	list容器
	 */
	public  void getFile(File dir,FilenameFilter filter,List<String> list){
		//获取目录列表
		File[] files=dir.listFiles();
		//深度遍历
		for(File file:files){
			//判断是否为文件夹
			if(file.isDirectory()){
				//递归
				getFile(file,filter,list);
			}else{
				//不是文件夹就是文件，用格式过滤器筛选
				if(filter.accept(dir, file.getName())){
					//添加结果到容器
					list.add(file.getAbsolutePath());
				}
			}
		}
	}

	/**
	 * 写入到指定目录
	 * @param list 文件路径列表
	 * @param TargetFile 目标路径
	 * @throws IOException
	 */
	public  void writeToFile(List<String> list,File TargetFile) throws IOException {
		int cont=1;
		//遍历列表
		for(String file:list){

			String fileName=new File(file).getName();  
			//输入流
			FileInputStream fis=new FileInputStream (new File(file));
			//输出流
			FileOutputStream fos=new FileOutputStream(new File(TargetFile,(cont)+fileName+".doc"));

			//读写操作
			int len=0;
			byte[]buf=new byte[1024];
			while((len=fis.read(buf))!=-1) {

				fos.write(buf, 0, len);
				fos.flush();	   
			}	    		
			cont++;
			fis.close();
			fos.close();
			System.out.println((cont)+"-"+fileName+".doc"+"读写完成.....");
		}

	}


}







