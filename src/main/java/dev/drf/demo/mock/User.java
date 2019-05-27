package dev.drf.demo.mock;

public class User implements Entity {
    private long id;
    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
