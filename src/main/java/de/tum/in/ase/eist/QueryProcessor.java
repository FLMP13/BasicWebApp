package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "MyTeam";
        } else if (query.contains("which of the following numbers is the largest")) {
            String[] table = new String[Integer.MAX_VALUE];
            table = query.split("%");

            List<Integer> numbers = new ArrayList<>();

            for (String e : table) {
                try{
                    numbers.add(Integer.parseInt(e));
                } catch (NumberFormatException ignored){

                }

            }
            return String.valueOf(numbers.stream().max(Integer::compare));
        }
        return "";
    }
}
