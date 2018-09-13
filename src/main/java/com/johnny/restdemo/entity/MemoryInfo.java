package com.johnny.restdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class MemoryInfo {
    private final long heap;
    private final long nonHeap;
    private final long ts;

    public MemoryInfo(long heap, long nonHeap) {
        this(heap, nonHeap, new Date().getTime());
    }
}
