package edward.springframework.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id; // we use Long because object type can be null, and primitive cannot be null.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
