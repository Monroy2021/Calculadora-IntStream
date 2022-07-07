package Calculadora;

import java.util.function.BiFunction;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class calculadora {
    private final static Logger LOGGER = Logger.getLogger("Calculadora");
    public static void main(String[] args) {


        BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> resta = (a, b) -> a - b;

        BiFunction<Integer, Integer, Integer> multiplicacion = (a, b) -> IntStream.range(0, b + 1)
                .reduce((accu, number) -> suma.apply(accu, a))
                .getAsInt();


        BiFunction<Integer, Integer, Integer> division = (a, b) -> {

            if(b.equals(0)){
                throw new IllegalArgumentException("Indefinida");
            }
            return IntStream.range(0, a)
                    .reduce((accu, number) -> multiplicacion.apply(number, b) <= a ? suma.apply(accu, 1) : accu)
                    .orElse(0);

        };

        LOGGER.info("suma: " + suma.apply(10,5));
        LOGGER.info("resta: " + resta.apply(8,4));
        LOGGER.info("multiplicacion: " + multiplicacion.apply(20,3));
        LOGGER.info("Division: " + division.apply(11,2));

    }
}
