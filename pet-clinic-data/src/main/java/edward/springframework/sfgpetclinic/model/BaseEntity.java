package edward.springframework.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // we use Long because object type can be null, and primitive cannot be null.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
