import java.util.ArrayList;

public interface Iterable {

    Iterator createIterator();

    ArrayList<TravelEntity> getList();

}