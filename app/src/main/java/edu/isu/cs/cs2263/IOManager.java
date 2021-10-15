package edu.isu.cs.cs2263;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class IOManager {

    public static void main(String[] args){

    }
    public ArrayList<Student> readData(String file){
        try{
            Gson gson = new Gson();
            File file1 = new File(file);
            Scanner reader = new Scanner(file1);
            ArrayList<Student> stuList = new ArrayList<>();
            while(reader.hasNextLine()){

                String data = reader.nextLine();
                Student stu = gson.fromJson(data,Student.class);
                stuList.add(stu);
            }
            reader.close();
            return stuList;
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public void writeData(String file, ArrayList<Student> studentList){
        try{
            Gson gson = new Gson();
            OutputStream outFile = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outFile);
            int size = studentList.size();
            for(int i=0; i<size; i++){
                Student stu = studentList.get(i);
                String json = gson.toJson(stu);
                writer.write(json);
                if(i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
