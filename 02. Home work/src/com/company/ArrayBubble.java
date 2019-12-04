package com.company;

class ArrayBubble{
    private Student[] a;   //ссылка на массив
    private int elems;  //количество элементов в массиве

    public ArrayBubble(Student[] aStudents){    //конструктор класса
        a = new Student[aStudents.length];          //создание массива размером max
        elems = 0;                  //при создании массив содержит 0 элементов
        for( Student k : aStudents ){
            this.into(k);
        }
    }

    public void into(Student value){   //метод вставки элемента в массив
        a[elems] = value;           //вставка value в массив a
        elems++;                    //размер массива увеличивается
    }

    public void printer(){          //метод вывода массива в консоль
        System.out.println("-----------------Start---------------------");
        for (int i = 0; i < elems; i++){    //для каждого элемента в массиве
            System.out.print(a[i].student_name + " " + a[i].student_age + " ");   //вывести в консоль
            System.out.println("");         //с новой строки
        }
        System.out.println("-----------------End---------------------");
    }

    private void toSwap(int first, int second){ //метод меняет местами пару чисел массива
        Student dummy = a[first];      //во временную переменную помещаем первый элемент
        a[first] = a[second];       //на место первого ставим второй элемент
        a[second] = dummy;          //вместо второго элемента пишем первый из временной памяти
    }

    public void bubbleSorter(String operator){     //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
        if( operator == "byAge" ){ // Sort by age ASC
            for (int out = elems - 1; out >= 1; out--){  //Внешний цикл
                for (int in = 0; in < out; in++){       //Внутренний цикл
                    if(a[in].student_age > a[in + 1].student_age) // Compare by Students ages ASC
                        toSwap(in, in + 1);             //вызвать метод, меняющий местами
                }
            }
        }else if( operator == "byName" ){  // Sort by names ASC
            for (int out = elems - 1; out >= 1; out--){
                for (int in = 0; in < out; in++){
                    if(a[in].student_name.compareTo(a[in + 1].student_name) > 0)
                        toSwap(in, in + 1);
                }
            }
        }

    }
}
