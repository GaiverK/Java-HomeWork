package Converters;

import com.company.Student;

public class ConvertJSON {

    public IStudentConverter getConverter(){

        return new IStudentConverter(){

            @Override
            public String convertStudent(Student nst) {
                StringBuilder builder = new StringBuilder();

                builder.append("{");

                builder.append("\"age\":")
                        .append(nst.getAge())
                        .append(",");

                builder.append("\"name\":\"")
                        .append(nst.getName())
                        .append("\",");

                builder.append("\"groupName\":\"")
                        .append(nst.getGroupName())
                        .append("\"");

                builder.append("}").append("\n");

                String result = builder.toString();
                return result;
            }
        };

    }

}
