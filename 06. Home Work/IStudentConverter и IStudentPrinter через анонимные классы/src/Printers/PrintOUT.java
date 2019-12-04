package Printers;

import Converters.IStudentConverter;
import com.company.Student;

public class PrintOUT{
    IStudentConverter converter;

    public PrintOUT(IStudentConverter converter) {
        this.converter = converter;
    }

    public IStudentPrinter getPrinter(){

        return new IStudentPrinter(){
            @Override
            public void StudentOut(Student st) {
                System.out.print( converter.convertStudent(st) );
            }
        };

    }

}
