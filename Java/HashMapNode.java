public class HashMapNode {
    private String key;
    private int value;

    public HashMapNode(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getKey() {
        return this.key;
    }
}
