package cn.kuqi.Poptis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class PropertiesUtils {
	
	private Properties prop;
	private String jarPath = "";
	private String fileName = "db.properties";
	private JarFile jFile = null;
	
	public PropertiesUtils() {
		prop = null == null ? new Properties():prop;
		jarPath = this.getClass().getClassLoader().getResource(fileName).getPath().replace("!/"+fileName, "").substring(6);
		try {
			jFile = null == null ? new JarFile(jarPath) : jFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JarEntry getJarEntry(JarFile jFile) {
		try {
			jFile = new JarFile(jarPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jFile.getJarEntry(fileName);
	}
	
	private InputStream getInputProp() throws IOException {
		JarEntry entry = getJarEntry(jFile);
		return jFile.getInputStream(entry);
	}
	
	private OutputStream getOutputProp() {
//		Manifest manifest = jFile.getManifest();
		File file = new File(jarPath+fileName);
		FileOutputStream fileOutputStream = null;
		JarOutputStream jOutputStream;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			jOutputStream = new JarOutputStream(fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		JarEntry entry = getJarEntry(jFile);
		return null;
	}
	
	public void isFile() {
		try {
			InputStream iStream = getInputProp();
			prop.load(iStream);
			String key = prop.getProperty("jdbc.user");
			System.out.println(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
