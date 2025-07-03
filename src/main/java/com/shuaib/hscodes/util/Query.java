package com.shuaib.hscodes.util;

public interface Query<I, O> {
    O execute(I input);
}
