package com.example.mynews;

public interface Lifecycles<V> {
    void bind(V view);

    void unbind();
}
