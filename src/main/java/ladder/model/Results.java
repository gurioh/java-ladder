package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;


    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String[] values){
       return new Results(Arrays.stream(values)
               .map(Result::new)
               .collect(Collectors.toList()));
    }

    public Results(String[] values)
    {
        this.results = Arrays.stream(values)
                .map(Result::new)
                .collect(Collectors.toList());
    }


    public List<Result> list(){
        return Collections.unmodifiableList(results);
    }

    public int size() {
        return results.size();
    }

}
