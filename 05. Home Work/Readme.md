### Домашнее задание 5
1. Создать интерфейс IStudentStringConverter, предоставляющий 1
метод для преобразования экземпляра Student в String по какому-то
алгоритму.
2. Создать реализации этого интерфейса, которые преобразовывают
объект в строку, используя StringBuilder:
a. JSON
b. XML
c. Многострочный простой текст вида “параметр=значение”
3. Создать интерфейс IStudentPrinter, предоставляющий 1 метод для
вывода экземпляра Student куда-то.
4. Создать реализации этого интерфейса, которые:
a. Используют экземпляр IStudentStringConverter для
преобразования студента в строку
b. Полученную после преобразования строку выводят ее:
i. На консоль используя System.out
ii. Никуда (класс-пустышка)
iii. Делегируют в другие экземпляры IStudentPrinter
5. Создать экземпляры объявленных классов и продемонстрировать
их работу