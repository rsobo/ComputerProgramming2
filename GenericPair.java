
public class GenericPair<T, S> {
	private T key;
	private S value;
	
	public GenericPair(T key, S value) {
		this.key = key;
		this.value = value;
	}
	
	public void add(T key, S value) {
		this.key = key;
		this.value = value;
	}
	
	public T getKey() {
		return key;
	}
	
	public S getValue() {
		return value;
	}
	
}
