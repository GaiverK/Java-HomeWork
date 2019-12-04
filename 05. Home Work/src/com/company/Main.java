package com.company;

import Converters.ConvertINI;
import Converters.ConvertJSON;
import Converters.ConvertXML;
import Printers.IStudentPrinter;
import Printers.NoPrint;
import Printers.PrintDelegate;
import Printers.PrintOUT;

public class Main {

    public static void main(String[] args) {
	    Student newST = new Student("Kolyan", 53, "B1");

        ConvertINI cINI = new ConvertINI();
        String resINI = cINI.convertStudent(newST);

        ConvertJSON cJSON = new ConvertJSON();
        String resJSON = cJSON.convertStudent(newST);

        ConvertXML cXML = new ConvertXML();
        String resXML = cXML.convertStudent(newST);

        // Print converters results
        System.out.println(resINI);
        System.out.println(resJSON);
        System.out.println(resXML);

        System.out.println("=============================================");

        IStudentPrinter[] printers = new IStudentPrinter[6];
        printers[0] = new PrintOUT(cINI);
        printers[1] = new PrintOUT(cJSON);
        printers[2] = new PrintOUT(cXML);
        printers[3] = new NoPrint(cINI);
        printers[4] = new NoPrint(cJSON);
        printers[5] = new NoPrint(cXML);

        PrintDelegate prg = new PrintDelegate(printers, newST);
        prg.StudentOut(newST);
    }
}
