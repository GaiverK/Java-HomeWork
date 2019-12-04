package com.gaiver.observer;

public interface Observer {
//    void onStart(); Я понял варианты использования нескольких методов.
    void update(Long seconds, String state); // Мне понравился больше такой вариант
//    void onStop();
}
