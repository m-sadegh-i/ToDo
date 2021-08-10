package ir.maktab.todo.base.domain;

public class BaseEntity<ID> {

    private ID Id;

    public BaseEntity() {
    }

    public ID getId() {
        return Id;
    }

    public void setId(ID id) {
        Id = id;
    }
}
