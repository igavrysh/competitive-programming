import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class AddressBook {
    Node root;

    public static class Node {
        public String value;
        public HashMap<String, Node> subNodes = new HashMap<>();
        public Node() {}
        public Node(String value) {
            this.value = value;
        }
        public void putSubnode(Node node) {
            this.subNodes.put(node.value, node);
        }
        public Node getOrSetDefaultSubnode(String value) {
            Node node = subNodes.getOrDefault(value, new Node(value));
            putSubnode(node);
            return node;
        }
    }

    public static class Record {
        public String number;
        public String street;
        public String city;
        public String state;
        public Record(Integer number, String street, String city, String state) {
            this.number = number == null ? null : Integer.toString(number);
            this.street = street;
            this.city = city;
            this.state = state;
        }
    }

    public static class SearchQuery {
        public String number;
        public String street;
        public String city;
        public String state;
        public SearchQuery(Integer number, String street, String city, String state) {
            this.number = number == null ? null : Integer.toString(number);
            this.street = street;
            this.city = city;
            this.state = state;
        }
    }

    public AddressBook(List<Record> records) {
        root = new Node();
        for (Record record : records) {
            Node state = root.getOrSetDefaultSubnode(record.state);
            Node city = state.getOrSetDefaultSubnode(record.city);
            Node street = city.getOrSetDefaultSubnode(record.street);
            street.getOrSetDefaultSubnode(new String(record.number));
        }
    }

    public static List<Node> unnest(int idx, String[] query, List<Node> candidats) {
        if (idx >= query.length) {
            return null;
        }
        List<Node> output = new LinkedList<>();
        String param = query[idx];
        for (Node candidate : candidats) {
            if (param == null) {
                output.addAll(candidate.subNodes.values());
            } else {
                Node toAdd = candidate.subNodes.get(param);
                if (toAdd != null) {
                    output.add(toAdd);
                }
            }
        }
        return output;
    }

    public boolean query(SearchQuery query) {
        String[] queryA = {query.state, query.city, query.street, query.number};
        List<Node> candidates = new ArrayList<>() {{ 
            add(root);
        }};
        for (int i = 0; i < queryA.length; i++) {
            candidates = unnest(i, queryA, candidates);
        }
        return candidates.size() != 0;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        /* 
        addressbook = [
            (number: 42, city: "Seattle", street: "Brandon", state: "Washington"),
            (number: 42, city: "San Francisco", street: "baz", state: "foobar")
        ]
        query: (number: null, city: "Seattle", street: null, state: "Washington") should return true
        query: (number: 42, city: "Seattle", street: "Xoxoxo", state:null) should return false
        query: (number: null, city: null, street: null, state:null) should return true
        query: (number: null, city: "seattle", street: null, state: "Washington") should return false (Seattle in address book starts with capital letter)
        */
        AddressBook ab = new AddressBook(new ArrayList<>(){{
            add(new AddressBook.Record(42, "Brandon", "Seattle", "Washington"));
            add(new AddressBook.Record(42, "baz", "San Francisco", "foobar"));
        }});
        boolean passed = true;
        passed = passed && (ab.query(new AddressBook.SearchQuery(null, null, "Seattle", null)) == true);
        passed = passed && (ab.query(new AddressBook.SearchQuery(42, "Xoxoxo", "Seattle", null)) == false);
        passed = passed && (ab.query(new AddressBook.SearchQuery(null, null, null, null)) == true);
        passed = passed && (ab.query(new AddressBook.SearchQuery(null, null, "seattle", "Washington")) == false);
        System.out.println("test1: " + (passed ? "passed" : "failed"));        
    }
}