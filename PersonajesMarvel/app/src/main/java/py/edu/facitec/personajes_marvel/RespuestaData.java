package py.edu.facitec.personajes_marvel;

import java.util.List;

public class RespuestaData {
    private Long offset;
    private Long limit;
    private Long total;
    private Long count;

    private List<PersonajeMarvel> results;

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

    public List<PersonajeMarvel> getResults() {
        return results;
    }

    public void setResults(List<PersonajeMarvel> results) {
        this.results = results;
    }

    public RespuestaData() {
    }

    public RespuestaData(Long offset, Long limit, Long total, Long count, List<PersonajeMarvel> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }
}
