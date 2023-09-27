package Family_Tree;

import java.io.Serializable;

public interface Writable {

    void save(Serializable serializable);

    Object read();

}