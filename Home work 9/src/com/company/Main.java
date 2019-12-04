package com.company;

public class Main {

    public static void main(String[] args) {
        // Student for testing exceptions
        Student newStudent = new Student();
        // Task 5
//        try {
//            Student.deserialize(null);
//        } catch (MyDomainExcception e) {
//            System.out.println("Детали ошибки: " + e.getMessage());
//            e.printStackTrace();
//        }

        // Inner class for testing
        Main.TestOnErrors mtoe = new Main(). new TestOnErrors();

        // Task 6
//        try{
//            mtoe.testThrowe();
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        // Task 7
//        try{
//            mtoe.TestThrowCaused();
//        }catch (Exception e){
//            System.out.println("Caused: " + e.getMessage());
//            e.printStackTrace();
//        }
        String errorres = "No errors";
        // Task 8
        try{
            newStudent.setName(null);
            newStudent.setAge(-1);
        }catch(NullPointerException e){ // Looking for null
            System.out.println("Catch 1: " + e.getMessage());
            errorres = e.getMessage();
        }catch(IllegalArgumentException e){ // Looking for empty string exception
            System.out.println("Catch 2: " + e.getMessage());
            errorres = e.getMessage();
        }catch(RuntimeException e){ // if not NullPointer or not IllegalArgument and exception is from Runtime
            System.out.println("Catch 3: " + e.getMessage());
        }catch(Exception e){ // other exceptions
            errorres = e.getMessage();
            System.out.println("Catch 3: " + e.getMessage());
        }
        // task 9
        finally {
            System.out.println("Operation finished - " + errorres);
        }
    }

    class TestOnErrors{
        public void testThrowe() throws MyDomainExcception {
            try{
                Student.deserialize(null);
            }catch (Exception e){
                System.out.println("Детали ошибки: " + e.getMessage());
                throw e;
            }
        }

        public void TestThrowCaused(){
            try {
                Student.deserialize(null);
            } catch (Exception e) {
                System.out.println("Детали ошибки caused: " + e.getMessage());
                throw new MyDomainRuntimeException(e.getMessage(), e);
            }
        }
    }
}
