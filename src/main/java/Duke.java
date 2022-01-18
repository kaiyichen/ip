
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.* ;

public class Duke {


    public static void main(String[] args) throws IOException {
        String greeting = "Hello! I'm Duke\nWhat can I do for you?";

        String separation = "\n******************************\n";
        System.out.println(separation + greeting + separation);
        ArrayList<Task> list_of_inputs = new ArrayList<>();

        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inp = br.readLine();
            String[] temp = inp.split(" ",2);

            if (inp.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (inp.equals("list")) {
                System.out.println("Here are your task(s):");
                for (int i = 0; i < list_of_inputs.size(); i++) {

                    System.out.println(((i + 1) + ". " + list_of_inputs.get(i).message()));
                }
            } else if (temp[0].equals("mark")) {
                int curr_no = Integer.parseInt(temp[1]) - 1;
                Task task_done = list_of_inputs.get(curr_no);

                System.out.println("Good work!! I have marked it done: \n" + task_done.markedDone());

            } else if (temp[0].equals("unmark")) {
                int curr_no = Integer.parseInt(temp[1]) - 1;
                Task task_undone = list_of_inputs.get(curr_no);
                task_undone.markedUndone();
                System.out.println("Alrightt! I have marked it undone: \n" + task_undone.markedUndone());

            } else if (temp[0].equals("todo")) {
                Todos todo = new Todos(temp[1]);
                list_of_inputs.add(todo);
                System.out.println("Okayy!! I've added this task:\n " + todo.message() + "\n You have " + list_of_inputs.size() + " tasks in the list.");

            }  else if (temp[0].equals("deadline")) {
                String[] deadL = temp[1].split("/by", 2);
                Deadline deadLineTemp = new Deadline(deadL[0],deadL[1]);
                list_of_inputs.add(deadLineTemp);
                System.out.println("Deadline for this task:\n " + deadLineTemp.message() + "\n You have " + list_of_inputs.size() + " tasks in the list.");

             } else {
                System.out.println("added:" + inp);
                list_of_inputs.add(new Task(inp));
            }
        }

    }


}
