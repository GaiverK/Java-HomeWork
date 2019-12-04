package Printers;

import Converters.IStudentConverter;
import com.company.Student;

public class PrintOUT implements IStudentPrinter {
    IStudentConverter converter;

    public PrintOUT(IStudentConverter converter) {
        this.converter = converter;
    }

    @Override
    public void StudentOut(Student st) {
        System.out.print( converter.convertStudent(st) );
    }
}
