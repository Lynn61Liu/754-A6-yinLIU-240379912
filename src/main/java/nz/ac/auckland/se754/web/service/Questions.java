package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Questions {
    private final List<Item> items;

    public Questions() {
        items = new ArrayList<>();
        items.add(new Item(1, "boolean is the same as string", new HashMap<>() {{
            put("this is true", false);
            put("this is false", true);
        }}));
        items.add(new Item(2, "what is an example of a character", new HashMap<>() {{
            put("a", true);
            put("abc", false);
        }}));
    }

    public List<Item> retrieveQuestionsAndAnswers(String user) {
        return items;
    }
}