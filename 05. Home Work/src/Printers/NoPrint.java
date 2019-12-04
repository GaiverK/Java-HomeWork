package Printers;

import Converters.IStudentConverter;
import com.company.Student;

public class NoPrint implements IStudentPrinter {
    IStudentConverter converter;

    public NoPrint(IStudentConverter converter) {
        this.converter = converter;
    }

    @Override
    public void StudentOut(Student st) {
        // Empty print
    }
}
