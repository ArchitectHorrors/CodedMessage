package codedmessage;

public class Pair<K, V> {
    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final K key;
    public final V value;

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
}
