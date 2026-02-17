package Session13.Bai4S13;

public interface Manage<T> {

    void add(T manageObj);
    void update(int index, T manageObj);
    void delete(int index);
    void display();
}
