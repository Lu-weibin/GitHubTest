package demo;

import java.util.Optional;

/**
 * Created by luwb on 2020/04/27.
 */
public class OptionalApi {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.empty();
        System.out.println(stringOptional.orElse("default"));

    }

}
