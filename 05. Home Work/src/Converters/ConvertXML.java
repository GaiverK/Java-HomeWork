package Converters;

import com.company.Student;

public class ConvertXML implements  IStudentConverter {

    @Override
    public String convertStudent(Student nst) {
        StringBuilder builder = new StringBuilder();

        builder.append("<student>").append("\n");

        builder.append("\t")
                .append("<age>")
                .append(nst.getAge())
                .append("</age>")
                .append("\n");

        builder.append("\t")
                .append("<name>")
                .append(nst.getName())
                .append("</name>")
                .append("\n");

        builder.append("\t")
                .append("<groupname>")
                .append(nst.getGroupName())
                .append("</groupname>")
                .append("\n");

        builder.append("</student>").append("\n");

        String result = builder.toString();
        return result;
    }
}
