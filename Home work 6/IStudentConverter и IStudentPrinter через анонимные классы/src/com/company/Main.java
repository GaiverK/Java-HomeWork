package com.company;

import Converters.ConvertINI;
import Converters.ConvertJSON;
import Converters.ConvertXML;
import Converters.IStudentConverter;
import Printers.IStudentPrinter;
import Printers.NoPrint;
import Printers.PrintDelegate;
import Printers.PrintOUT;

public class Main {

    public static void main(String[] args) {
        // Create some student
	    Student newST = new Student("Kolyan", 53, "B1");

	    // Initialize converters
        ConvertINI cINI = new ConvertINI();
        IStudentConverter anonimConvINI = cINI.getConverter();
        String resINI = anonimConvINI.convertStudent(newST);

        ConvertJSON cJSON = new ConvertJSON();
        IStudentConverter anonimConvJSON = cJSON.getConverter();
        String resJSON = anonimConvJSON.convertStudent(newST);

        ConvertXML cXML = new ConvertXML();
        IStudentConverter anonimConvXML = cXML.getConverter();
        String resXML = anonimConvXML.convertStudent(newST);

        // Print converters results
        System.out.println(resINI);
        System.out.println(resJSON);
        System.out.println(resXML);

        System.out.println("=============================================");

        // Initialize printers

        PrintOUT pOutINI = new PrintOUT(anonimConvINI);
        PrintOUT pOutJSON = new PrintOUT(anonimConvJSON);
        PrintOUT pOutXML = new PrintOUT(anonimConvXML);

        NoPrint npINI = new NoPrint(anonimConvINI);
        NoPrint npJSON = new NoPrint(anonimConvJSON);
        NoPrint npXML = new NoPrint(anonimConvXML);

        IStudentPrinter[] printers = new IStudentPrinter[6];
        printers[0] = pOutINI.getPrinter();
        printers[1] = pOutJSON.getPrinter();
        printers[2] = pOutXML.getPrinter();
        printers[3] = npINI.getPrinter();
        printers[4] = npJSON.getPrinter();
        printers[5] = npXML.getPrinter();

        PrintDelegate prg = new PrintDelegate(printers, newST);

    }
}
