package Converters;

import com.company.Student;

public class ConvertINI {

    public IStudentConverter getConverter(){

        return new IStudentConverter(){
            @Override
            public String convertStudent(Student nst) {
                StringBuilder builder = new StringBuilder();

                builder.append("age=")
                        .append(nst.getAge())
                        .append("\n");

                builder.append("name=")
                        .append(nst.getName())
                        .append("\n");

                builder.append("groupName=")
                        .append(nst.getGroupName())
                        .append("\n");


                String result = builder.toString();
                return result;
            }
        };

    }

}
