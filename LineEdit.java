public class LineEdit {
    // instance variables
    String status;
    Stack<String> previous = new Stack<String>();


    // create a new LineEdit with given initial text
    public LineEdit(String text) {
        status = text;
    }

    // get the current state of the editor
    public String toString() {
        
        return status;
    }

    // add the given text at the end of the line
    public void append(String text) {
        previous.push(status);
        status = status + text;
    }

    // replace all occurrences of "from" with "to"
    public void replaceEach(String from, String to) {
        previous.push(status);
        status = status.replace(from, to);
    }

    // undo the latest append/replaceEach operation that hasn't already been undone
    public void undo() {
        if (!previous.isEmpty())
            status = previous.pop();
    }

    // test client
    public static void main(String[] args) {
        LineEdit line = new LineEdit("COS ROCKS");
        System.out.println(line);

        line.replaceEach("CKS", "X");
        System.out.println(line);

        line.append("!!");
        System.out.println(line);

        line.undo();
        System.out.println(line);

        line.undo();
        System.out.println(line);
    }
}
