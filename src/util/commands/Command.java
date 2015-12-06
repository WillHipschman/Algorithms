package util.commands;

public interface Command<T> {
	void Run(T t);
}
