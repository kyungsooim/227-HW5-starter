// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

import java.util.Scanner;

public class QuestionsGame {

    private QuestionNode overallRoot;

    //Constructor with string input null string check
    //creates a tree with single node with the given data
    public QuestionsGame(String data){
        if(data.isEmpty()){
            throw new IllegalArgumentException("Sting cannot be empty.");
        }
        overallRoot = new QuestionNode(data);
    }

    //Constructor takes console scanner and constructs the tree.
    public QuestionsGame(Scanner console){
        overallRoot = buildTree(overallRoot, console);
    }

    //Builds tree based on file input
    private QuestionNode buildTree(QuestionNode root, Scanner console){
        if(!console.hasNextLine()){
            return null;
        } else {
            String type = console.nextLine();
            String data = console.nextLine();
            root = new QuestionNode(data);

            //only if this is a question do recursion
            if(type.equals("Q:")){
                //build left and right children
                root.left = buildTree(root.left, console);
                root.right = buildTree(root.right, console);
            }
            return root;
        }
    }

    //This method controls the actual "game"
    //Calls helper method to recursively go through tree structure.
    //Also calls improveKnowledge if the answer was not correct.
    public void play(Scanner console){
        processQuestion(overallRoot, console, null, false);
    }

    //Recursive helper to go through the question tree.
    //Returns answer nodes only, if not then goes through tree again recursively.
    private void processQuestion(QuestionNode root, Scanner console, QuestionNode parent, boolean isLeft){
        if(root.left == null && root.right == null){
            //root is the final answer we guessed
            processAnswer(root, console, parent, isLeft);
            //TODO implement processAnswer method
        }
        else{
            //TODO your code here
        }
    }


    //
    //
    // TODO Your code here
    //
    //


    //Static utility method for getting input for correct answer
    private static String getCorrectAnswer(Scanner console){
        System.out.println("Boo! I Lose.  Please help me get better!");
        System.out.print("What is your object? ");
        return console.nextLine();
    }

    //Static utility method for getting input for new question
    private static String getQuestionString(Scanner console, String answer, String incorrectAnswer){
        System.out.println("Please give me a yes/no question that distinguishes between " + answer + " and " +
                incorrectAnswer + ".");
        System.out.print("Q: ");
        return console.nextLine();
    }

    //Static utility method for asking user input for yes or no
    private static boolean isYes(Scanner console){
        System.out.print(" (y/n)? ");
        return console.nextLine().trim().toLowerCase().startsWith("y");
    }

    //QuestionNode class
    private static class QuestionNode {
        private final String data;
        private QuestionNode left; //yes
        private QuestionNode right; //no

        public QuestionNode(String data){
            this(data, null, null);
        }

        public QuestionNode(String data, QuestionNode left, QuestionNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
