package com.shuaib.hscodes;

public interface Query<I, O> {
    O execute(I input);
}
