package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;
import java.util.List;

import py.edu.facitec.marvelcharacters.models.Character;

public class RestClientData implements Serializable {
    private Long offset;
    private Long limit;
    private Long total;
    private Long count;
    private List<Character> results;

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    public RestClientData() {
    }

    public RestClientData(Long offset, Long limit, Long total, Long count, List<Character> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

    @Override
    public String toString() {
        return "RestClientData{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", total=" + total +
                ", count=" + count +
                ", results=" + results +
                '}';
    }
}
