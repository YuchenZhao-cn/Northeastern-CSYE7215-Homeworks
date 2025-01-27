package YuchenZhao.NO4.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MyThread implements Runnable {

	File f = new File("src/Grade.txt");
	FileWriter writer = new FileWriter(f, true);
	Student st = new Student();
	
	public MyThread() throws IOException {
		f.createNewFile();
	}

	@Override
	public void run() {
		try {
			writer.write("Name: " + st.Name + " ID: " + st.ID + " Midterm: " + st.Midterm + " Project: " + st.Project + " Final: " + st.Final + " Grade: " + st.Grade +"\n");
			System.out.println(Thread.currentThread().getName() + " completed!");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
