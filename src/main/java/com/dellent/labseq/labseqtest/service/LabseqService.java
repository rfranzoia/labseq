package com.dellent.labseq.labseqtest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabseqService {

    private final List<Long> list;

    /**
     * Constructor
     */
    public LabseqService() {
        // basic cach array initialization
        list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        list.add(0L);
        list.add(1L);
    }

    /**
     *
     * @return List of the labseq calculation currently in cache
     */
    public List<Long> getLabseqArray() {
        return list;
    }

    /**
     * Returns Number in the index position of the cache array list
     * if the index request is greater than the current array, the array is recalculated for the new index
     *
     * @param index the desired index
     * @return Long the result number in the labseq calculation
     */
    public Long getLabseq(Integer index) {

        if (index > list.size() - 1) {
            recalculateList(index);
        }

        return list.get(index);
    }

    /**
     * Recalculate the cache array List
     * @param toIndex the new index of the cache array
     */
    public void recalculateList(Integer toIndex) {

        while (toIndex > list.size() -1) {
            Long n = list.get(list.size() - 4);
            Long m = list.get(list.size() - 3);
            Long sum = m + n;
            list.add(sum);
        }

    }
}
