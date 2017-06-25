package DeveloperDAO;

import Developer.Developer;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface GenericsDAO<T,ID>{
void save(T entity);
void update(T entity);
void remove (T entity) throws IOException;
Developer getById(ID id);
Collection<T> getAll();

}
