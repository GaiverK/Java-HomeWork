package Printers;

import Converters.IStudentConverter;
import com.company.Student;

public class PrintDelegate implements IStudentPrinter {

    public PrintDelegate(IStudentPrinter[] isp, Student aStudent) {
        for( IStudentPrinter printer : isp ){
            printer.StudentOut(aStudent);
        }
    }

    @Override
    public void StudentOut(Student st) {

    }
}
