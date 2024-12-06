package Models;

import java.util.function.Supplier;
import java.util.HashMap;
import java.util.Map;

public class AcquirerFactory <T>{
        private final Map<String, Supplier<T>> map = new HashMap<>();

        public void register(String acquirer, Supplier<T> acquirerSupplier) {
            map.put(acquirer, acquirerSupplier);
        }

        public T getObject(String name) {
            Supplier<T> object = map.get(name);
            return object != null ? object.get() : null;
        }
}
