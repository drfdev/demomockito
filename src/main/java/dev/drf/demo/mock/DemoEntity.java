package dev.drf.demo.mock;

import java.time.Instant;

public class DemoEntity implements Entity {
    private long id;
    private String name;
    private String demo;
    private Instant create;
    private User user;

    public DemoEntity() {
    }

    public User getById(Long id) {
        return user;
    }

    public User getUserById(Long id) {
        return user;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public Instant getCreate() {
        return create;
    }

    public void setCreate(Instant create) {
        this.create = create;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
