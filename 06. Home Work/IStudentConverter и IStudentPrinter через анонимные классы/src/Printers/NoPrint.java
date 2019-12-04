package Printers;

import Converters.IStudentConverter;
import com.company.Student;

public class NoPrint {
    IStudentConverter converter;

    public NoPrint(IStudentConverter converter) {
        this.converter = converter;
    }

    public IStudentPrinter getPrinter(){

        return new IStudentPrinter(){
            @Override
            public void StudentOut(Student st) {
                // Empty print
            }
        };

    }

}
