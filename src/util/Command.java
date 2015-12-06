package util;

public interface Command<T> {
	void Run(T t);
}
