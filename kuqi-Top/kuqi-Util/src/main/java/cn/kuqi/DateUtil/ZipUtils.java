package cn.kuqi.DateUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {
	
		//解压zip方法
		public static void resolveZip(String ZipFilePath) throws IOException {
			
			File file = new File(ZipFilePath);
			if (!file.exists()) {
				throw new RuntimeException("'"+file.getPath()+"'这个路径下的zip不存在");
			}
			
			ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			File filo = null;
			
			String docname = file.getName().substring(0, file.getName().length()-4);//获取文件名去后缀
			
			String parent = file.getParent();//获取该压缩文件的根目录
			
			ZipEntry entry;
			
			BufferedOutputStream bos = null;
			
			while ((entry = zipInputStream.getNextEntry()) != null) {
				
				File filedoc = new File(file.getParent(),docname);
				
				if (!filedoc.exists()) {
					filedoc.mkdirs();//创建解压后的根目录
				}
				if (!entry.isDirectory()) {
					File filefile = new File(filedoc.getAbsolutePath(),entry.getName());
					if (!filefile.exists()) {
						bos = new BufferedOutputStream(new FileOutputStream(filefile));
						int b = 0;
						byte[] byts = new byte[1024];
						while((b = zipInputStream.read(byts)) != -1) {
							bos.write(byts,0,b);
						}
						bos.close();
					}
				}else {
					File fliedir = new File(filedoc.getAbsolutePath(),entry.getName());
					if (!fliedir.exists()) {
						fliedir.mkdirs();
					}	
				}
			}
			zipInputStream.close();
		}
		
		
//		压缩
		public void compressZip() {
			 
		}
		
		
		
		//迭代
		public void getAllFileDoc(String path){
			File file = new File(path);
			File[] files = file.listFiles();
			if (files !=null) {
				for(int i = 0; i < files.length;i++) {
					if (files[i].isDirectory()) {
						getAllFileDoc(files[i].getAbsolutePath());
						System.out.println(files[i].getAbsolutePath() + files[i].getName());
					}else {
						getAllFileDoc(files[i].getAbsolutePath());
						System.out.println(files[i].getAbsolutePath() + files[i].getName());
					}
				}
			}
		}
}
