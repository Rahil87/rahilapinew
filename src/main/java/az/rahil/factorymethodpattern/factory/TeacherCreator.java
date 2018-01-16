package az.rahil.factorymethodpattern.factory;

import az.rahil.factorymethodpattern.product.Model;
import az.rahil.factorymethodpattern.product.Teacher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeacherCreator implements  Factory {
    @Override
    public Model getData() {

            Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Adi daxil edin:");
            String data;
            data=scanner.next();
            System.out.println("Soyadi daxil edin:");
            data=scanner.next();
            System.out.println("Unvani daxil edin:");
            data=scanner.next();
            File file = new File("C:/New Text Document.txt");
            FileWriter fw= new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(data);
            bw.close();
            System.out.println("Melumat ugurla elave olundu");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("xeta bas verdi!!!");
        }
                return  new Teacher();
    }
}
