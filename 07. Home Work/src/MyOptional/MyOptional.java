package MyOptional;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyOptional<T> {
    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public boolean isPresent(){
        if( this.value != null ) return true;
        return false;
    }

    public T get(){
        if( isPresent() ) return this.value;
        else throw new NoSuchElementException("No element");
    }

    public static <T> MyOptional<T> of(T value){
        if( value == null ) throw new NullPointerException("No value");
        return new MyOptional<T>(value);
    }

    public static <T> MyOptional<T> ofNullable(T value){
        if( value != null ) return new MyOptional<T>(value);
        return empty();
    }

    public static <T> MyOptional<T> empty(){
        return new MyOptional<T>(null);
    }

    public T orElse(T other){
        return isPresent() ? this.value : other;
    }


    /**
     *
     *  ADVANCED SECTION
     *
     */


    // Advanced 1
    public void ifPresent(Consumer<? super T> consumer){
        if(isPresent() && consumer != null) consumer.accept(value);
        if(isPresent() && consumer == null) throw new NullPointerException("Consumer is null");
    }
    // Advanced 2
    public T orElseGet(Supplier<? extends T> other){
        if( !isPresent() && other == null ) throw new NullPointerException("Supplier is null");
        return (isPresent()) ? value : ( !isPresent() && other != null ) ? other.get() : null; // I am tried to put new NullPointerException("Supplier is null") instead null, how can i do it?
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if( !isPresent() && exceptionSupplier == null ) throw new NullPointerException("No value and supplier is null");
        if( isPresent() ) return value;
        throw exceptionSupplier.get();
    }

    public MyOptional<T> filter(Predicate<? super T> predicate){
        if( predicate == null ) throw new NullPointerException("No predicate");
        return ( isPresent() && predicate.test(value) ) ? of(value) : empty();


//        if( isPresent() && predicate.test(value) ) return MyOptional.of(value);
//        return MyOptional.empty();
    }

    // Advanced 4
    public <U> MyOptional<U> map(Function<? super T,? extends U> mapper){
        if( mapper == null ) throw new NullPointerException("Mapper is null");
        return isPresent() ? ofNullable(mapper.apply(value)) : empty();
    }

    // Advanced 5
    public <U> MyOptional<U> flatMap(Function<? super T,MyOptional<U>> mapper){
        if( mapper == null ) throw new NullPointerException("No mapper");
        MyOptional res = mapper.apply(value);
        if( res == null ) throw new NullPointerException();
        return res.isPresent() ? res : empty();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!( other instanceof MyOptional )) return false;
        MyOptional that = (MyOptional) other;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return (!isPresent()) ? 0 : Objects.hash(this.value);
    }
}
